package com.example.backend

import com.example.backend.di.getKoinModule
import com.example.backend.storage.exposed.LocalSource
import io.ktor.server.application.*
import io.ktor.server.routing.Routing
import org.koin.ktor.ext.inject
import org.koin.ktor.plugin.Koin

import org.koin.logger.slf4jLogger


internal fun Application.module() {
    install(Koin) {
       // slf4jLogger()
        modules(getKoinModule())
    }

    val localSource by inject<LocalSource>()

    install(Routing) {
        api(localSource)
    }
}
