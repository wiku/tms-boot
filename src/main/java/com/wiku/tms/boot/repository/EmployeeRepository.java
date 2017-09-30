package com.wiku.tms.boot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wiku.tms.boot.model.assets.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>
{
    
}
