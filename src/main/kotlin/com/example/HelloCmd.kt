package com.example

import javax.inject.Inject

import io.quarkus.runtime.QuarkusApplication
import io.quarkus.runtime.annotations.QuarkusMain
import org.eclipse.microprofile.config.Config

@QuarkusMain
class HelloCmd : QuarkusApplication {

    @Inject
    private val config: Config? = null

    @Inject
    private val configuration: HelloConfiguration? = null

    override fun run(vararg args: String?): Int {
//        val name = if (args.isNotEmpty()) args.joinToString(",") else "邱张华"
        println(config?.getValue("wc.name", String::class.java))
//        println(config?.propertyNames)
//        println(config?.getValue("wc.repos", JsonObject::class.java))
        println(configuration?.repos)
        val obj = configuration?.repos?.get("repos")?.asJsonArray()
        obj?.forEach { x ->
            println(x.asJsonObject().getString("url"))
        }
        configuration?.init()
        return 0
    }

}
