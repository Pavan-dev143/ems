package com.pavan.emp_manager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pavan.emp_manager.dto.EmployeeDTO;
import com.pavan.emp_manager.service.EmployeeService;

@CrossOrigin("*")
@RestController
@RequestMapping("/employees")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	@PostMapping
	public ResponseEntity<EmployeeDTO> saveEmployee(@RequestBody EmployeeDTO employeeDTO){
		
		EmployeeDTO savedEmployee = employeeService.createEmployee(employeeDTO);
		
		return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
	}
	
	@GetMapping("{id}")
	public ResponseEntity<EmployeeDTO> getEmployeeById(@PathVariable("id") int employeeId){
		
		EmployeeDTO employeeById = employeeService.getEmployeeById(employeeId);
		
		return ResponseEntity.ok(employeeById);
	}
	
	@GetMapping
	public ResponseEntity<List<EmployeeDTO>> getAllEmployees(){
		
		List<EmployeeDTO> allEmployees = employeeService.getAllEmployees();
		
		return ResponseEntity.ok(allEmployees);
	}
	
	@PutMapping("{id}")
	public ResponseEntity<EmployeeDTO> updateEmployee(@PathVariable int id, @RequestBody EmployeeDTO employeeDTO){
		
		EmployeeDTO updatedEmployee = employeeService.updateEmployee(id, employeeDTO);
		
		return ResponseEntity.ok(updatedEmployee);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteEmployee(@PathVariable int id){
		
		employeeService.deleteEmployee(id);
		
		return ResponseEntity.ok("user deleted successfully");
	}
	
	@GetMapping("/test")
	public ResponseEntity<String> testPage() {

		return ResponseEntity.ok("Just testing page");
	}
	
}
