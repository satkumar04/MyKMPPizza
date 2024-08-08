package com.example.backend.storage.exposed.recipe

import com.example.backend.model.Recipe
import com.example.backend.model.RecipeResponse
import com.example.backend.storage.exposed.ingridient.IngredientEntity
import com.example.backend.storage.exposed.ingridient.IngredientTable
import com.example.backend.storage.exposed.ingridient.toIngredient
import com.example.backend.storage.exposed.instruction.InstructionEntity
import com.example.backend.storage.exposed.instruction.InstructionTable
import com.example.backend.storage.exposed.instruction.toInstruction
import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.id.EntityID

class RecipeEntity(id: EntityID<Int>) : IntEntity(id) {
    companion object : IntEntityClass<RecipeEntity>(RecipeTable)

    var title by RecipeTable.title
    val ingredients by IngredientEntity referrersOn IngredientTable.recipe
    val instructions by InstructionEntity referrersOn InstructionTable.recipe
    //val recipeImages by RecipeImageEntity referrersOn RecipeImageTable.recipe
}

fun RecipeEntity.toRecipe() = Recipe(
    id.value.toLong(),
    title,
    ingredients.map{it.toIngredient()},
            instructions.map{it.toInstruction()}
)

fun RecipeEntity.toRecipeResponse() = RecipeResponse(
    id.value.toLong(),
    title,
    ingredients.map { it.toIngredient() },
    instructions.map { it.toInstruction() },
   )