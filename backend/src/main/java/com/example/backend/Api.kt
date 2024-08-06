package com.example.backend

import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*


internal fun Routing.api() {
    hello()
}

private fun Routing.hello() {
    get("/hello") {
        call.respondText("Hello!")
    }
}