package br.com.espressoapp.steampipe

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SteampipeApplication

fun main(args: Array<String>) {
    runApplication<SteampipeApplication>(*args)
}
