package com.pavan.emp_manager.service;

import java.util.List;

import com.pavan.emp_manager.dto.EmployeeDTO;

public interface EmployeeService {

	EmployeeDTO createEmployee(EmployeeDTO employeeDTO);
	EmployeeDTO getEmployeeById(int id);
	List<EmployeeDTO> getAllEmployees();
	EmployeeDTO updateEmployee(int id, EmployeeDTO employeeDTO);
	void deleteEmployee(int id);
}
