package com.eiasinprodhan.crems.restcontroller;

import com.eiasinprodhan.crems.entity.Customer;
import com.eiasinprodhan.crems.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
@CrossOrigin("*")
public class CustomerRestController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/")
    public List<Customer> findAll() {
        return customerService.findAll();
    }

    @GetMapping("/{id}")
    public Customer findById(@PathVariable Integer id) {
        return customerService.findById(id);
    }

    @PostMapping("/")
    public Customer save(@RequestBody Customer customer) {
        return customerService.save(customer);
    }

    @PutMapping("/")
    public Customer update(@RequestBody Customer customer) {
        return customerService.save(customer);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        customerService.deleteById(id);
    }
}
