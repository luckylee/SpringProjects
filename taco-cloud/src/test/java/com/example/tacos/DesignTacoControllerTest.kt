package com.example.tacos

import com.example.tacos.data.IngredientRepository
import com.example.tacos.data.OrderRepository
import org.hamcrest.Matchers
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers

@WebMvcTest
class DesignTacoControllerTest {

    @Autowired
    private val mockMvc: MockMvc? = null

    @MockBean
    private val ingredientRepository: IngredientRepository? = null

    @MockBean
    private val orderRepository: OrderRepository? = null

    @Test
    @Throws(Exception::class)
    fun testHomePage() {
        mockMvc!!.perform(MockMvcRequestBuilders.get("/"))
            .andExpect(MockMvcResultMatchers.status().isOk)
            .andExpect(MockMvcResultMatchers.view().name("home"))
            .andExpect(
                MockMvcResultMatchers.content().string(
                    Matchers.containsString("Welcome to the Magic Taco-Could store")
                )
            )
    }

}