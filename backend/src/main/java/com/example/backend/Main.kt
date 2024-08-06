package com.example.backend

import io.ktor.server.application.*
import io.ktor.server.routing.Routing

internal fun Application.module() {
    install(Routing) {
        api()
    }
}
