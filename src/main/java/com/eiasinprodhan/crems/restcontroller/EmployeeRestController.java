package com.eiasinprodhan.crems.restcontroller;

import com.eiasinprodhan.crems.entity.Employee;
import com.eiasinprodhan.crems.entity.User;
import com.eiasinprodhan.crems.service.AuthService;
import com.eiasinprodhan.crems.service.EmployeeService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/employees")
public class EmployeeRestController {

    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private AuthService authService;

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
    public ResponseEntity<Map<String, String>> registerEmployee(
            @RequestPart(value = "user") String userJson,
            @RequestPart(value = "employee") String employeeJson,
            @RequestParam(value = "photo") MultipartFile file
    ) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        User user = objectMapper.readValue(userJson, User.class);
        Employee employee = objectMapper.readValue(employeeJson, Employee.class);

        try {
            authService.registerEmployee(user, file, employee);
            Map<String, String> response = new HashMap<>();
            response.put("Message", "User Added Successfully ");

            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {

            Map<String, String> errorResponse = new HashMap<>();
            errorResponse.put("Message", "User Add Faild " + e);
            return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @PutMapping("/")
    public Employee update(
            @RequestPart(value = "employee") String employeeJson,
            @RequestParam(value = "photo") MultipartFile file
    ) throws JsonProcessingException {
        System.out.println("jkgfa");
        ObjectMapper objectMapper = new ObjectMapper();
        Employee employee = objectMapper.readValue(employeeJson, Employee.class);
        return employeeService.update(employee, file);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        employeeService.delete(id);
    }

    @GetMapping("/login")
    public Employee login(@RequestParam String email, @RequestParam String password) {
        return employeeService.login(email, password);
    }

    @GetMapping("/email/{email}")
    public Employee findByEmail(@PathVariable String email) {
        return employeeService.findByEmail(email);
    }

}
