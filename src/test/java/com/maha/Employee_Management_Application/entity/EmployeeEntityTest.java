package com.maha.Employee_Management_Application.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class EmployeeEntityTest {
	@Test
	public void testGettersAndSetters() {
		// Arrange
		EmployeeEntity employee = new EmployeeEntity();

		// Act
		employee.setId(1);
		employee.setName("John Doe");
		employee.setGender("Male");
		employee.setPhone("1234567890");
		employee.setEmail("john@example.com");
		employee.setDesignation("Developer");
		employee.setSalary(50000.0);

		// Assert
		assertEquals(1, employee.getId());
		assertEquals("John Doe", employee.getName());
		assertEquals("Male", employee.getGender());
		assertEquals("1234567890", employee.getPhone());
		assertEquals("john@example.com", employee.getEmail());
		assertEquals("Developer", employee.getDesignation());
		assertEquals(50000.0, employee.getSalary(), 0.001); // Using delta for double comparison
	}
}
