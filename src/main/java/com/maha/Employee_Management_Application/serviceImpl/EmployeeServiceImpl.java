package com.maha.Employee_Management_Application.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maha.Employee_Management_Application.dto.EmployeeDTO;
import com.maha.Employee_Management_Application.entity.EmployeeEntity;
import com.maha.Employee_Management_Application.repository.EmployeeRepository;
import com.maha.Employee_Management_Application.service.EmployeeService;

import jakarta.transaction.Transactional;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	@Transactional
	public String add(EmployeeEntity empEntity) {
		employeeRepository.save(empEntity);
		return "Employee Data Saved!!!. Employee Number is " + empEntity.getId();
	}

	@Override
	public String modify(EmployeeEntity empEntity) {
		employeeRepository.save(empEntity);
		return "Employee Data Updated!!!. Employee Number is " + empEntity.getId();
	}

	@Override
	public EmployeeDTO search(int id) throws Exception {
		try {
			Optional<EmployeeEntity> empEntity = employeeRepository.findById(id);
			if (empEntity.isEmpty()) {
				throw new Exception("Employee Data Not Found.");
			}
			EmployeeDTO employeeDTO = new EmployeeDTO();
			BeanUtils.copyProperties(empEntity.get(), employeeDTO);
			return employeeDTO;
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public List<EmployeeDTO> searchAll() throws Exception {
		try {
			List<EmployeeEntity> listEmpEntity = employeeRepository.findAll();
			if (listEmpEntity.isEmpty()) {
				throw new Exception("Employee Data Not Found.");
			}
			List<EmployeeDTO> listEmployeeDTO = new ArrayList<>();
			for (EmployeeEntity employeeEntity : listEmpEntity) {
				EmployeeDTO employeeDTO = new EmployeeDTO();
				BeanUtils.copyProperties(employeeEntity, employeeDTO);
				listEmployeeDTO.add(employeeDTO);
			}
			return listEmployeeDTO;
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public String remove(int id) {
		employeeRepository.deleteById(id);
		return "Employee Data Deleted!!!. Employee Number is " + id;
	}
}
