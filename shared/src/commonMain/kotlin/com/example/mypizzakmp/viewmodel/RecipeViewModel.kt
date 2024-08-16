package com.example.mypizzakmp.viewmodel

import com.example.mypizzakmp.model.Recipe
import com.example.mypizzakmp.repository.RecipeRepository
import com.example.mypizzakmp.util.CoroutineViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class RecipeViewModel : CoroutineViewModel(),KoinComponent {
    private val recipeRepository: RecipeRepository by inject()
    private val _recipes = MutableStateFlow<List<Recipe>>(emptyList())
    val recipes: StateFlow<List<Recipe>> = _recipes
    init {
        getRecipes()

    }

    fun getRecipes() {
        coroutineScope.launch {
            _recipes.value = recipeRepository.getRecipes()
        }
    }

    fun observeRecipes(onChange: (List<Recipe>) -> Unit) {
        recipes.onEach {
            onChange(it)
        }.launchIn(coroutineScope)
    }
}