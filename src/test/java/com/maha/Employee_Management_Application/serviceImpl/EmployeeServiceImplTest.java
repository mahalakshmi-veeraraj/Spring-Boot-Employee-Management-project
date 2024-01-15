package com.maha.Employee_Management_Application.serviceImpl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.maha.Employee_Management_Application.dto.EmployeeDTO;
import com.maha.Employee_Management_Application.entity.EmployeeEntity;
import com.maha.Employee_Management_Application.repository.EmployeeRepository;

@SpringBootTest
public class EmployeeServiceImplTest {
	@Mock
	private EmployeeRepository employeeRepository;
	@InjectMocks
	private EmployeeServiceImpl employeeServiceImpl;

	@Test
	public void testAdd() {
		EmployeeEntity empEntity = new EmployeeEntity();
		empEntity.setId(1);
		when(employeeRepository.save(any())).thenReturn(empEntity);

		String result = employeeServiceImpl.add(empEntity);

		assertEquals("Employee Data Saved!!!. Employee Number is 1", result);
		verify(employeeRepository, times(1)).save(empEntity);
	}

	@Test
	public void testModify() {
		EmployeeEntity empEntity = new EmployeeEntity();
		empEntity.setId(1);
		when(employeeRepository.save(any())).thenReturn(empEntity);

		String result = employeeServiceImpl.modify(empEntity);

		assertEquals("Employee Data Updated!!!. Employee Number is 1", result);
		verify(employeeRepository, times(1)).save(empEntity);
	}

	@Test
	public void testSearch() throws Exception {
		EmployeeEntity empEntity = new EmployeeEntity();
		empEntity.setId(1);
		when(employeeRepository.findById(1)).thenReturn(Optional.of(empEntity));

		EmployeeDTO result = employeeServiceImpl.search(1);

		assertNotNull(result);
		assertEquals(1, result.getId());
	}

	@Test
	public void testSearchAll() throws Exception {
		List<EmployeeEntity> empEntities = new ArrayList<>();
		empEntities.add(new EmployeeEntity());
		empEntities.add(new EmployeeEntity());
		when(employeeRepository.findAll()).thenReturn(empEntities);

		List<EmployeeDTO> result = employeeServiceImpl.searchAll();

		assertNotNull(result);
		assertEquals(2, result.size());
	}

	@Test
	public void testRemove() {
		int id = 1;

		String result = employeeServiceImpl.remove(id);

		assertEquals("Employee Data Deleted!!!. Employee Number is 1", result);
		verify(employeeRepository, times(1)).deleteById(id);
	}
}
