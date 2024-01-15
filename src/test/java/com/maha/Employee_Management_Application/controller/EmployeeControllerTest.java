package com.maha.Employee_Management_Application.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;

import com.maha.Employee_Management_Application.dto.EmployeeDTO;
import com.maha.Employee_Management_Application.entity.EmployeeEntity;
import com.maha.Employee_Management_Application.serviceImpl.EmployeeServiceImpl;

@SpringBootTest
public class EmployeeControllerTest {
	@Mock
	private EmployeeServiceImpl employeeServiceImpl;
	@InjectMocks
	private EmployeeController employeeController;

	@Test
	public void testAdd() {
		EmployeeEntity empEntity = new EmployeeEntity();
		when(employeeServiceImpl.add(empEntity)).thenReturn("Employee Data Saved!!!. Employee Number is 1");

		ResponseEntity<String> result = employeeController.add(empEntity);

		assertEquals(HttpStatusCode.valueOf(200), result.getStatusCode());
		assertEquals("Employee Data Saved!!!. Employee Number is 1", result.getBody());
	}

	@Test
	public void testModify() {
		EmployeeEntity empEntity = new EmployeeEntity();
		when(employeeServiceImpl.modify(empEntity)).thenReturn("Employee Data Updated!!!. Employee Number is 1");

		ResponseEntity<String> result = employeeController.modify(empEntity);

		assertEquals(HttpStatusCode.valueOf(200), result.getStatusCode());
		assertEquals("Employee Data Updated!!!. Employee Number is 1", result.getBody());
	}

	@Test
	public void testSearch() throws Exception {
		int empId = 1;
		EmployeeDTO empDTO = new EmployeeDTO();
		empDTO.setId(empId);
		when(employeeServiceImpl.search(empId)).thenReturn(empDTO);

		ResponseEntity<EmployeeDTO> result = employeeController.search(empId);

		assertEquals(HttpStatusCode.valueOf(200), result.getStatusCode());
		assertEquals(empDTO, result.getBody());
	}

	@Test
	public void testSearchAll() throws Exception {
		List<EmployeeDTO> listEmpDTO = Arrays.asList(new EmployeeDTO(), new EmployeeDTO());
		when(employeeServiceImpl.searchAll()).thenReturn(listEmpDTO);

		ResponseEntity<List<EmployeeDTO>> result = employeeController.searchAll();

		assertEquals(HttpStatusCode.valueOf(200), result.getStatusCode());
		assertEquals(listEmpDTO, result.getBody());
	}

	@Test
	public void testRemove() {
		int empId = 1;
		when(employeeServiceImpl.remove(empId)).thenReturn("Employee Data Deleted!!!. Employee Number is 1");

		ResponseEntity<String> result = employeeController.remove(empId);

		assertEquals(HttpStatusCode.valueOf(200), result.getStatusCode());
		assertEquals("Employee Data Deleted!!!. Employee Number is 1", result.getBody());
	}
}
