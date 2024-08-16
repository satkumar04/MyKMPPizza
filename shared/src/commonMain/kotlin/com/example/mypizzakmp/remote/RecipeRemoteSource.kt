package com.example.mypizzakmp.remote

import com.example.mypizzakmp.api.RecipesApi
import com.example.mypizzakmp.model.RecipeRequest

class RecipeRemoteSource( private val recipesApi: RecipesApi) {
    suspend fun getRecipes() = recipesApi.getRecipes()
    suspend fun postRecipe(recipe: RecipeRequest) = recipesApi.postRecipe(recipe)
}