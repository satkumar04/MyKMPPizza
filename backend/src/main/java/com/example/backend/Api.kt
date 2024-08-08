package com.example.backend

import com.example.backend.storage.exposed.LocalSource
import io.ktor.server.application.call
import io.ktor.server.request.receive
import io.ktor.server.response.respond
import io.ktor.server.routing.Routing
import io.ktor.server.routing.get
import io.ktor.server.routing.post


internal fun Routing.api(localSource: LocalSource) {
    pizza(localSource)
    addRecipe(localSource)
    getRecipes(localSource)
    getRecipe(localSource)
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

private fun Routing.addRecipe(localSource: LocalSource) {
    post("/recipes") {
        val recipeId = localSource.addRecipe(call.receive())
        call.respond(recipeId)
    }
}

private fun Routing.getRecipes(localSource: LocalSource) {
    get("/recipes") {
        localSource.getRecipes().let {
            call.respond(it)
        }
    }
}

private fun Routing.getRecipe(localSource: LocalSource) {
    get("/recipes/{recipeId}") {
        val recipeId = call.parameters["recipeId"]!!.toLong()
        localSource.getRecipe(recipeId).let {
            call.respond(it)
        }
    }
}