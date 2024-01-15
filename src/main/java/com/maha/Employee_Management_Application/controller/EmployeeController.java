package com.maha.Employee_Management_Application.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.maha.Employee_Management_Application.dto.EmployeeDTO;
import com.maha.Employee_Management_Application.entity.EmployeeEntity;
import com.maha.Employee_Management_Application.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;

	@RequestMapping("/add")
	public ResponseEntity<String> add(@RequestBody EmployeeEntity empEntity) {
		try {
			String status = employeeService.add(empEntity);
			return ResponseEntity.ok().body(status);
		} catch (Exception e) {
			return ResponseEntity.badRequest().build();
		}
	}

	@RequestMapping("/modify")
	public ResponseEntity<String> modify(@RequestBody EmployeeEntity empEntity) {
		try {
			String status = employeeService.modify(empEntity);
			return ResponseEntity.ok().body(status);
		} catch (Exception e) {
			return ResponseEntity.badRequest().build();
		}
	}

	@RequestMapping("/search")
	public ResponseEntity<EmployeeDTO> search(@RequestParam(name = "empId", required = true) int empId) {
		try {
			EmployeeDTO empDTO = employeeService.search(empId);
			return ResponseEntity.ok().body(empDTO);
		} catch (Exception e) {
			return ResponseEntity.badRequest().build();
		}
	}

	@RequestMapping("/searchAll")
	public ResponseEntity<List<EmployeeDTO>> searchAll() {
		try {
			List<EmployeeDTO> listEmpDTO = employeeService.searchAll();
			return ResponseEntity.ok().body(listEmpDTO);
		} catch (Exception e) {
			return ResponseEntity.badRequest().build();
		}
	}

	@RequestMapping("/remove")
	public ResponseEntity<String> remove(@RequestParam(name = "empId", required = true) int empId) {
		try {
			String status = employeeService.remove(empId);
			return ResponseEntity.ok().body(status);
		} catch (Exception e) {
			return ResponseEntity.badRequest().build();
		}
	}
}
