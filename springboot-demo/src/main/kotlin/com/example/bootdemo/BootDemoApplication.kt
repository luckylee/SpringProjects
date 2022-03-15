package com.example.bootdemo

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

/**
// Java transform into Kotlin version
@SpringBootApplication
@RestController
class DemoApplication {
	@GetMapping("/hello")
	fun hello(@RequestParam(value = "name", defaultValue = "World") name: String?): String {
		return String.format("Hello %s!", name)
	}

	companion object {
		@JvmStatic
		fun main(args: Array<String>) {
			SpringApplication.run(DemoApplication::class.java, *args)
		}
	}
}
*/


// The recommended Kotlin version

@SpringBootApplication
//@RestController
class BootDemoApplication {

/*	@GetMapping("/hello")
	fun hello(@RequestParam(value = "name", defaultValue = "World") name: String): String {
		return String.format("Hello %s!", name)
	}*/
}

// The fun is outside a class, and it is the static funtion.
fun main(args: Array<String>) {
	testfun1()
	runApplication<BootDemoApplication>(*args)
}

fun testfun1() : Int {
	val mutableList : MutableList<String> = mutableListOf<String>("wegin", "lee")
	mutableList.add("Yaping")

	println("listString is: $mutableList")
	return mutableList.size
}

fun testfun2() : Int {
	val mutableSet : MutableSet<String> = mutableSetOf<String>("wegin", "lee")
	mutableSet.add("Yaping")
	mutableSet.add("Lee")

	println("Set String is: $mutableSet")
	return mutableSet.size

}


@RestController
class HomeController() {
	@GetMapping("/hello")
	fun hello(@RequestParam(value = "name", defaultValue = "World") name: String): String {
		testfun2()
		return String.format("Hello %s!", name)
	}
}

