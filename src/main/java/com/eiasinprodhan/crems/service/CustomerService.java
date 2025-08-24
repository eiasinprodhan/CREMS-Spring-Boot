package com.eiasinprodhan.crems.service;

import com.eiasinprodhan.crems.entity.Customer;
import com.eiasinprodhan.crems.repository.ICustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    private ICustomerRepository customerRepository;

    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    public Customer findById(Integer id) {
        return customerRepository.findById(id).get();
    }

    public Customer save(Customer customer) {
        return customerRepository.save(customer);
    }

    public void deleteById(Integer id) {
        customerRepository.deleteById(id);
    }
}
