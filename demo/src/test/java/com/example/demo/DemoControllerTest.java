package com.example.demo;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.example.demo.controller.DemoController;
import com.example.demo.service.DemoService;

@WebMvcTest(DemoController.class)
public class DemoControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	@Mock
	private DemoService service;
	record Person(String name, int age) {};
	void test_getPersonReturnNotAcceptable() throws Exception {
		
		List<Person> mocklist = new ArrayList<Person>();
		Person p = new Person("alice",12);
		mocklist.add(p);
		
		when(service.getNames()).thenReturn(mocklist);
		mockMvc.perform(MockMvcRequestBuilders.get("/api/person"))
		.andExpect(status().isNotAcceptable())
		.andExpect(content().json("[{\"name\":\"alice\",\"age\":12}]"));
	}
}
