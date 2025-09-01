package com.eiasinprodhan.crems.restcontroller;

import com.eiasinprodhan.crems.entity.Employee;
import com.eiasinprodhan.crems.service.EmployeeService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/employees")
@CrossOrigin("*")
public class EmployeeRestController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/")
    public List<Employee> findAll() {
        return employeeService.findAll();
    }

    @GetMapping("/{id}")
    public Employee findById(@PathVariable int id) {
        return employeeService.findById(id);
    }

    @GetMapping
    public List<Employee> findByRole(@RequestParam String role) {
        return employeeService.findByRole(role);
    }

    @PostMapping("/")
    public Employee save(
            @RequestPart(value = "employee") String employeeJson,
            @RequestParam(value = "photo") MultipartFile file
    ) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        Employee employee = objectMapper.readValue(employeeJson, Employee.class);
        return employeeService.save(employee, file);
    }

    @PutMapping("/")
    public Employee update(
            @RequestPart(value = "employee") String employeeJson,
            @RequestParam(value = "photo") MultipartFile file
    ) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        Employee employee = objectMapper.readValue(employeeJson, Employee.class);
        return employeeService.save(employee, file);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        employeeService.delete(id);
    }

    @GetMapping("/login")
    public Employee login(@RequestParam  String email, @RequestParam String password) {
        return employeeService.login(email, password);
    }

}
