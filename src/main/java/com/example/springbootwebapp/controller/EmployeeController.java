package com.example.springbootwebapp.controller;

import com.example.springbootwebapp.entity.Employee;
import com.example.springbootwebapp.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
public class EmployeeController {
    
    @Autowired
    private EmployeeRepository employeeRepository;
    
    @GetMapping({"/showEmployees", "/", "list"})
    public ModelAndView showEmployees() {
        ModelAndView modelAndView  = new ModelAndView("list-employees");
        List<Employee> employeeList = employeeRepository.findAll();
        modelAndView.addObject("employees", employeeList);
        return modelAndView;
    }
}
