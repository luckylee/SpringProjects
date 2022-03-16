package com.example.bootdemo

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.core.env.Environment
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.sql.Connection
import java.sql.DriverManager
import java.sql.ResultSet
import java.sql.Statement

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
	runApplication<BootDemoApplication>(*args)
}

fun testfun1() : Int {
	val mutableList : MutableList<String> = mutableListOf<String>("wegin", "lee")
	mutableList.add("Yaping")

	println("listString is: $mutableList")
	return mutableList.size
}

@RestController
class HomeController(@Autowired environment: Environment) {

	// 取得 application.yml 設定的配置數值
	private val url = environment.getProperty("spring.datasource.url");
	private val username = environment.getProperty("spring.datasource.username");
	private val password = environment.getProperty("spring.datasource.password");

	// 資料庫連線
	private val connection: Connection = DriverManager.getConnection(url, username, password)

	@GetMapping("/hello")
	fun hello(@RequestParam(value = "name", defaultValue = "World") name: String): String {
		testfun1()
		return String.format("Hello %s!", name)
	}


	/**
	 * 取得 Student 所有資料
	 */
	@GetMapping("/students")
	fun getStudentData(): ArrayList<MutableMap<String, Any>> {
		// 建立 Statement 進行資料庫操作
		val statement: Statement = connection.createStatement()

		// 取得 Student 資料表所有資料
		val record: ResultSet = statement.executeQuery("SELECT * FROM Student")

		// 將 Student 資料取出並儲存在一個集合進行輸出
		val result: ArrayList<MutableMap<String, Any>> = ArrayList()
		while (record.next()) {
			val item = mutableMapOf<String, Any>()
			item["id"] = record.getInt("id")
			item["name"] = record.getString("name")
			item["email"] = record.getString("email")
			result.add(item)
		}

		return result
	}
}

