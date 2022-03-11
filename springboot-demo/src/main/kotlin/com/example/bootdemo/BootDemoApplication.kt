package com.example.bootdemo

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController


@SpringBootApplication
class BootDemoApplication

fun main(args: Array<String>) {
	runApplication<BootDemoApplication>(*args)
}

@RestController
class HomeController() {

	@GetMapping("/hello")
	fun hello(@RequestParam(value = "name", defaultValue = "World") name: String): String {
		return String.format("Hello %s!", name)
	}
}

