package com.example.mypizzakmp.api

import com.example.mypizzakmp.model.Recipe
import com.example.mypizzakmp.model.RecipeRequest
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.post
import io.ktor.client.request.setBody

class RecipesApi(private val ktorApi: KtorApi) : KtorApi by ktorApi {
    companion object {
        const val RECIPES_BASE_URL = "recipes"
    }

    suspend fun getPizza(): String {
        return client.get {
            apiUrl("pizza")
        }.body()
    }

    suspend fun getRecipes(): List<Recipe> {
        return client.get {
            apiUrl(RECIPES_BASE_URL)
        }.body()
    }

    suspend fun getRecipe(id: Long): Recipe {
        return client.get {
            apiUrl("$RECIPES_BASE_URL/$id")
        }.body()
    }

    suspend fun postRecipe(recipeRequest: RecipeRequest): Long? {
        try {
            return client.post {
                json()
                apiUrl(RECIPES_BASE_URL)
                setBody(recipeRequest)
            }.body()
        } catch (e: Exception) {
            return null
        }
    }
}

