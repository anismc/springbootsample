package com.example.demo;

import java.util.List;

import com.example.demo.service.DemoService;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DemoServiceTest { 
	
	private final DemoService demoService = new DemoService();

@Test
void testGetNames() {
    // Call method
    List<DemoService.Person> result = demoService.getNames();

    // Assertions
    assertNotNull(result);
    assertEquals(2, result.size()); // Should return 2 people
    assertEquals("Ethan", result.get(0).name()); // First person's name should be "Ethan"
    assertEquals(4, result.get(0).age()); // First person's age should be 4
    assertEquals("alan", result.get(1).name()); // Second person's name should be "alan"
    assertEquals(12, result.get(1).age()); // Second person's age should be 12
}

@Test
void testGetNamesByAgeAndName() {
    // Call method
    List<DemoService.Person> result = demoService.getNames(30, "John");

    // Assertions
    assertNotNull(result);
    assertEquals(1, result.size()); // Should return 1 person
    assertEquals("John", result.get(0).name()); // Name should match
    assertEquals(30, result.get(0).age()); // Age should match
}
}
