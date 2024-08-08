package com.example.backend

import com.example.backend.di.getKoinModule
import com.example.backend.storage.exposed.LocalSource
import io.ktor.server.application.Application
import io.ktor.server.application.install
import io.ktor.server.plugins.contentnegotiation.ContentNegotiation
import io.ktor.server.plugins.statuspages.StatusPages
import io.ktor.server.response.respond
import io.ktor.server.routing.Routing
import org.koin.ktor.ext.inject
import org.koin.ktor.plugin.Koin
import io.ktor.serialization.kotlinx.json.*

internal fun Application.module() {
    install(Koin) {
       // slf4jLogger()
        modules(getKoinModule())
    }

    val localSource by inject<LocalSource>()

    install(Routing) {
        api(localSource)
    }

    install(StatusPages) {
        exception<Throwable> { call, cause ->
            call.respond(cause.toString())
        }
    }
    install(ContentNegotiation) {
        json()
    }
}
