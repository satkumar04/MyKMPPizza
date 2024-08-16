package com.example.mypizzakmp.repository

import com.example.mypizzakmp.model.Recipe
import com.example.mypizzakmp.model.RecipeRequest
import com.example.mypizzakmp.remote.RecipeRemoteSource
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class RecipeRepository: KoinComponent {
    private val recipeRemoteSource: RecipeRemoteSource by inject()

    suspend fun postRecipe(recipe: RecipeRequest): Long? = recipeRemoteSource.postRecipe(recipe)
    suspend fun getRecipes(): List<Recipe> = recipeRemoteSource.getRecipes()
}