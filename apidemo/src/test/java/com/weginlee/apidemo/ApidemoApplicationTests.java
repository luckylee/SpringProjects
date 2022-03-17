package com.weginlee.apidemo;


import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.event.annotation.BeforeTestMethod;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
class ApidemoApplicationTests {

	private MockMvc mvc;

	@BeforeEach
	void setUp() {
		mvc = MockMvcBuilders.standaloneSetup(new HelloController()).build();

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
