package com.example.backend.di


import com.example.backend.storage.aws.AmazonFileStorage
import com.example.backend.storage.aws.FileStorage
import com.example.backend.storage.exposed.LocalSource
import com.example.backend.storage.exposed.LocalSourceImpl
import io.ktor.server.application.Application
import org.koin.dsl.module

internal fun Application.getKoinModule() = module {
    single<FileStorage> { AmazonFileStorage() }
    single<LocalSource> { LocalSourceImpl(get(),this@getKoinModule) }

}
