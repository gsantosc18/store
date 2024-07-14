package com.github.gsantosc18.store

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.scheduling.annotation.EnableScheduling

@SpringBootApplication
@EnableScheduling
class StoreApplication

fun main(args: Array<String>) {
	runApplication<StoreApplication>(*args)
}
