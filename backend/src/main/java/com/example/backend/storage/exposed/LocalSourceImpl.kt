package com.example.backend.storage.exposed


import com.example.backend.storage.aws.FileStorage
import com.example.backend.storage.exposed.images.RecipeImageEntity
import com.example.backend.storage.exposed.images.RecipeImageTable
import com.example.backend.storage.exposed.ingridient.IngredientEntity
import com.example.backend.storage.exposed.ingridient.IngredientTable
import com.example.backend.storage.exposed.instruction.InstructionEntity
import com.example.backend.storage.exposed.instruction.InstructionTable
import com.example.backend.storage.exposed.recipe.RecipeEntity
import com.example.backend.storage.exposed.recipe.RecipeTable
import com.example.backend.storage.exposed.recipe.toRecipe
import com.example.mypizzakmp.model.Ingredient
import com.example.mypizzakmp.model.Instruction
import com.example.mypizzakmp.model.Recipe
import com.zaxxer.hikari.HikariConfig
import com.zaxxer.hikari.HikariDataSource
import io.ktor.server.application.Application
import io.ktor.server.application.log
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.ObsoleteCoroutinesApi
import kotlinx.coroutines.newFixedThreadPoolContext
import kotlinx.coroutines.withContext
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.transactions.transaction
import java.io.File
import kotlin.coroutines.CoroutineContext

@OptIn(ObsoleteCoroutinesApi::class, DelicateCoroutinesApi::class)
internal class LocalSourceImpl(private val fileStorage: FileStorage,application: Application) : LocalSource {
    private val dispatcher: CoroutineContext

    init {
        val config = application.environment.config.config("database")
        val url = System.getenv("JDBC_DATABASE_URL")
        val driver = config.property("driver").getString()
        val poolSize = config.property("poolSize").getString().toInt()
        application.log.info("Connecting to db at $url")


        dispatcher = newFixedThreadPoolContext(poolSize, "database-pool")
        val hikariConfig = HikariConfig().apply {
            jdbcUrl = url
            maximumPoolSize = poolSize
            driverClassName = driver
            validate()
        }

        Database.connect(HikariDataSource(hikariConfig))

//        transaction {
//            SchemaUtils.createMissingTablesAndColumns(
//                RecipeTable,
//                IngredientTable,
//                InstructionTable
//            )
//        }

        transaction {
            SchemaUtils.createMissingTablesAndColumns(
                RecipeTable,
                IngredientTable,
                InstructionTable,
                RecipeImageTable
            )
        }
    }
    override suspend fun getPizza(): String = withContext(dispatcher) {
        "Pizza!"
    }

    override suspend fun addIngredient(recipeId: Long, ingredient: Ingredient) = withContext(dispatcher) {
        transaction {
            val recipe = RecipeEntity[recipeId.toInt()]
            IngredientEntity.new {
                name = ingredient.name
                amount = ingredient.amount.toBigDecimal()
                metric = ingredient.metric
                this.recipe = recipe
            }.id.value.toLong()
        }
    }

    override suspend fun addInstruction(recipeId: Long, instruction: Instruction) = withContext(dispatcher) {
        transaction {
            val recipe = RecipeEntity[recipeId.toInt()]
            InstructionEntity.new {
                order = instruction.order
                description = instruction.description
                this.recipe = recipe
            }.id.value.toLong()
        }
    }

    override suspend fun addRecipe(recipe: Recipe) = withContext(dispatcher) {
        withContext(dispatcher) {
            val recipeId = transaction {
                RecipeEntity.new {
                    title = recipe.title
                }.id.value.toLong()
            }

            recipe.ingredients.forEach{
                addIngredient(recipeId, it)
            }

            recipe.instructions.forEach{
                addInstruction(recipeId, it)
            }
            recipeId
        }
    }

    override suspend fun getRecipes() : List<Recipe> = withContext(dispatcher) {
        transaction {
            RecipeEntity.all().map { it.toRecipe() }
        }
    }

    override suspend fun getRecipe(recipeId: Long): Recipe = withContext(dispatcher) {
        transaction {
            RecipeEntity[recipeId.toInt()].toRecipe()
        }
    }

    override suspend fun saveImage(recipeId: Long, image: File) {
        withContext(dispatcher) {
            val imageUrl = fileStorage.save(image)
            transaction {
                val recipe = RecipeEntity[recipeId.toInt()]
                RecipeImageEntity.new {
                    this.image = imageUrl
                    this.recipe = recipe
                }
            }
        }
    }


}