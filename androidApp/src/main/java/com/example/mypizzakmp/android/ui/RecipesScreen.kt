package com.example.mypizzakmp.android.ui

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import com.example.mypizzakmp.model.Recipe
import com.example.mypizzakmp.viewmodel.RecipeViewModel

@Composable
public fun RecipesScreen() {
    val viewModel = remember {
        RecipeViewModel()
    }
    val recipes by viewModel.recipes.collectAsState()

    Recipes (items = recipes)
}

@Composable
fun Recipes(
    items: List<Recipe>
) {
    LazyColumn {
        itemsIndexed(items = items,
            itemContent = { _, item ->
                Text(text = item.title)
            })

    }
}