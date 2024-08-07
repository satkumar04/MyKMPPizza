package com.example.backend

import com.example.backend.storage.exposed.LocalSource
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*


internal fun Routing.api(localSource: LocalSource) {
    pizza(localSource)
}

//private fun Routing.hello() {
//    get("/hello") {
//        call.respondText("Hello!")
//    }
//}

private fun Routing.pizza(localSource: LocalSource) {
    get("/pizza") {
        localSource.getPizza().let {
            call.respond(it)
        }
    }
}