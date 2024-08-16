package com.example.mypizzakmp.di

import com.example.mypizzakmp.api.KtorApi
import com.example.mypizzakmp.api.KtorApiImpl
import com.example.mypizzakmp.api.RecipesApi
import com.example.mypizzakmp.remote.RecipeRemoteSource
import com.example.mypizzakmp.repository.RecipeRepository
import com.example.mypizzakmp.viewmodel.RecipeViewModel
import org.koin.core.context.startKoin
import org.koin.dsl.KoinAppDeclaration
import org.koin.dsl.module

fun initKoin(appDeclaration: KoinAppDeclaration)  = startKoin {
    modules(
           apiModule,
           viewModelModule,
           repositoryModule
    )
}

private val apiModule = module {
    single<KtorApi> { KtorApiImpl() }
    factory { RecipesApi(get()) }
}

private val viewModelModule = module {
    single{ RecipeViewModel() }
}

private val repositoryModule = module {
    factory { RecipeRemoteSource(get()) }
    single { RecipeRepository() }
}
