package com.example.backend.storage.exposed.instruction

import com.example.backend.storage.exposed.recipe.RecipeTable
import org.jetbrains.exposed.dao.id.IntIdTable
import org.jetbrains.exposed.sql.ReferenceOption

internal object InstructionTable : IntIdTable("instructions") {
    val order = integer("order")
    val description = varchar("description", 100)
    val recipe = reference(
        "recipe_id",
        RecipeTable,
        onDelete = ReferenceOption.CASCADE,
        onUpdate = ReferenceOption.CASCADE
    )
}