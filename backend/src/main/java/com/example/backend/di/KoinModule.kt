package com.example.backend.di


import com.example.backend.storage.exposed.LocalSource
import com.example.backend.storage.exposed.LocalSourceImpl
import io.ktor.server.application.*
import org.koin.dsl.module

internal fun Application.getKoinModule() = module {
    single<LocalSource> { LocalSourceImpl(this@getKoinModule) }
}