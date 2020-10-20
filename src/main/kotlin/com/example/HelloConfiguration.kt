package com.example

import io.quarkus.arc.config.ConfigProperties
import org.eclipse.microprofile.config.inject.ConfigProperty
import javax.annotation.PostConstruct
import javax.inject.Inject
import javax.json.JsonObject

@ConfigProperties(prefix = "wc")
class HelloConfiguration {
    @Inject
    @ConfigProperty(name = "name")
    var name: String? = null

    @Inject
    @ConfigProperty(name = "repos")
    var repos: JsonObject? = null

    @PostConstruct
    fun init() {
        println(repos)
    }
}