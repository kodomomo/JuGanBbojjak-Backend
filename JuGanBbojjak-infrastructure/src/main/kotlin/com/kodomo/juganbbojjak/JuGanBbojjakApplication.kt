package com.kodomo.juganbbojjak

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.boot.runApplication

@ConfigurationPropertiesScan
@SpringBootApplication
class JuGanBbojjakApplication

fun main(args: Array<String>) {
    runApplication<JuGanBbojjakApplication>(*args)
}
