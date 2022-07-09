package com.example.plugins

import io.ktor.server.sessions.*
import io.ktor.server.application.*
import io.ktor.server.freemarker.*
import io.ktor.server.response.*
import io.ktor.server.request.*
import io.ktor.server.routing.*
import io.ktor.server.util.*

fun Application.configureSecurity() {

    data class MySession(val login: String, val password: String)
    install(Sessions) {
        cookie<MySession>("MY_SESSION") {
            cookie.extensions["SameSite"] = "lax"
        }
    }

    routing {
        get("/login") {
            println(23)
            if (call.sessions.get<MySession>() != null) {
                call.respondRedirect("articles")
                return@get
            }
            call.respond(FreeMarkerContent("login.ftl", null))
        }
        post ("/login") {
            val form = call.receiveParameters()
            val login = form.getOrFail("login")
            val password = form.getOrFail("password")
            val session = MySession(login, password)
            call.sessions.set(session)
            call.respondRedirect("articles")
        }
    }
}
