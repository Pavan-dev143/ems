package com.pavan.emp_manager.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pavan.emp_manager.dto.EmployeeDTO;
import com.pavan.emp_manager.entity.Employee;
import com.pavan.emp_manager.exception.ResourceNotFoundException1;
import com.pavan.emp_manager.mapper.EmployeeMapper;
import com.pavan.emp_manager.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepostory;

	@Override
	public EmployeeDTO createEmployee(EmployeeDTO employeeDTO) {
		
		Employee employee = EmployeeMapper.mapToEmployee(employeeDTO);
		
		Employee savedEmployee = employeeRepostory.save(employee);
		
		return EmployeeMapper.mapToEmployeeDTO(savedEmployee);
	}

	@Override
	public EmployeeDTO getEmployeeById(int id) {
		
		Employee employee = employeeRepostory.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException1("employee not exist with given id: " + id));
				
		return EmployeeMapper.mapToEmployeeDTO(employee);
	}

	@Override
	public List<EmployeeDTO> getAllEmployees() {
		
		List<Employee> allEmployees = employeeRepostory.findAll();
		
		return allEmployees.stream()
				.map(emp -> EmployeeMapper.mapToEmployeeDTO(emp))
				.collect(Collectors.toList());
	}

	@Override
	public EmployeeDTO updateEmployee(int id, EmployeeDTO employeeDTO) {
		
		Employee employee = employeeRepostory.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException1("employee not exist with given id: " + id));
		
		employee.setFirstName(employeeDTO.getFirstName());
		employee.setLastName(employeeDTO.getLastName());
		employee.setEmail(employeeDTO.getEmail());
		
		Employee savedEmp = employeeRepostory.save(employee);
		
		return EmployeeMapper.mapToEmployeeDTO(savedEmp);
	}

	@Override
	public void deleteEmployee(int id) {
		
		employeeRepostory.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException1("employee not exist with given id: " + id));
		
		employeeRepostory.deleteById(id);
		
	}

}
