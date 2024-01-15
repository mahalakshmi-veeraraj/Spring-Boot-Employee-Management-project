package com.maha.Employee_Management_Application.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.maha.Employee_Management_Application.dto.EmployeeDTO;
import com.maha.Employee_Management_Application.entity.EmployeeEntity;

@Service
public interface EmployeeService {
	public String add(EmployeeEntity empEntity);

	public String modify(EmployeeEntity empEntity);

	public EmployeeDTO search(int id) throws Exception;

	public List<EmployeeDTO> searchAll() throws Exception;

	public String remove(int id);
}
