package com.pavan.emp_manager.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pavan.emp_manager.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{

}
