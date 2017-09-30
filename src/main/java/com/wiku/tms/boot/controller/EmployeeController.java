package com.wiku.tms.boot.controller;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.wiku.tms.boot.model.assets.Employee;
import com.wiku.tms.boot.repository.EmployeeRepository;

@RestController
@RequestMapping("api/v1")
public class EmployeeController
{
    
    @Autowired
    private EmployeeRepository repository;

    @RequestMapping(value = "employees", method = RequestMethod.GET)
    public List<Employee> getAll()
    {
        return repository.findAll();
    }

    @RequestMapping(value = "employees/{id}", method = RequestMethod.GET)
    public Employee get(@PathVariable Integer id) throws ResourceNotFoundException
    {
        Employee employee = repository.findOne(id);
     
        if (employee == null)
            throw new ResourceNotFoundException(String.format("Employee id=%d does not exist", id));
        
        return employee;
    }

    @RequestMapping(value = "employees", method = RequestMethod.POST)
    public Employee create(@RequestBody Employee employee)
    {
        return repository.saveAndFlush(employee);
    }

    @RequestMapping(value = "employees/{id}", method = RequestMethod.PUT)
    public Employee update(@PathVariable Integer id, @RequestBody Employee employee) throws ResourceNotFoundException
    {
        Employee employeeToUpdate = repository.findOne(id);
        
        if (employeeToUpdate == null)
            throw new ResourceNotFoundException(String.format("Employee id=%d does not exist", id));

        BeanUtils.copyProperties(employee, employeeToUpdate);
        return repository.saveAndFlush(employeeToUpdate);
    }

    @RequestMapping(value = "employees/{id}", method = RequestMethod.DELETE)
    public Employee delete(@PathVariable Integer id) throws ResourceNotFoundException
    {
        Employee employeeToDelete = repository.findOne(id);
        
        if (employeeToDelete == null)
            throw new ResourceNotFoundException(String.format("Employee with id=%d does not exist", id));
        
        repository.delete(id);
        return employeeToDelete;
    }

}
