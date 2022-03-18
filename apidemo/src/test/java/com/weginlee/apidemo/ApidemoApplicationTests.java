package com.weginlee.apidemo;


import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.event.annotation.BeforeTestMethod;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@SpringBootTest
@AutoConfigureMockMvc
public class ApidemoApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void noParamGreetingShouldReturnDefaultMessage() throws Exception {

		mockMvc.perform(get("/greeting")).andDo(print()).andExpect(status().isOk())
				.andExpect(jsonPath("$.content").value("Hello, World!"));
				//.andExpect(content().string(equalTo("Hello, World!")));
		// return is json format string, e.g "{\"id\":1,\"content\":\"Hello, World!\"}"

	}

	@Test
	public void paramGreetingShouldReturnTailoredMessage() throws Exception {

		mockMvc.perform(get("/greeting").param("name", "Spring Community"))
				.andDo(print()).andExpect(status().isOk())
				.andExpect(jsonPath("$.content").value("Hello, Spring Community!"));
	}

	@Test
	void helloControllerTest() throws Exception {

		RequestBuilder request;

		request = get( "/hello" );
		mockMvc.perform(request)
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(content().string(equalTo("Hello Wegin!")));

		mockMvc.perform(MockMvcRequestBuilders.get("/hello").accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(content().string(equalTo("Hello Wegin!")));

	}
}


/*
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ApidemoApplicationTests {

	// 建立一個空的WebApplicationContext
	@Autowired
	private WebApplicationContext webApplicationContext;

	private MockMvc mvc;

	@BeforeEach
	void setUp() {
		//mvc = MockMvcBuilders.standaloneSetup(new HelloController()).build();

		// 使用 webApplicationContext 建立初始化 MockMvc
		mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();

	}

	@Test
	void contextLoads() throws Exception {
		//Assume.assumeNotNull(mvc);

		RequestBuilder request;

		request = get( "/hello" );
		mvc.perform(request)
				.andExpect(status().isOk())
				.andExpect(content().string(equalTo("Hello World")));
		//.andExpect(content().string(equalTo("Welcome to the world of SpringBoot, Wegin")));

	}
}
*/