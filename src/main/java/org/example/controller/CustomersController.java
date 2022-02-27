package org.example.controller;

import org.example.model.Customer;
import org.example.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;


import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/customers")
public class CustomersController {

    @Autowired
    private CustomerService customerService;

    @RequestMapping
    public List<Customer> getAllCustomers() {

        return customerService.getAllCustomers();
    }

    @RequestMapping("{id}")
    public ResponseEntity<Customer> getCustomer(@PathVariable Long id) {
        return customerService.getCustomer(id);
        //System.out.println("Customer ID received" +id);
        //return new Customer();
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public void deleteCustomer(Long id) {
//before deleting, verify that customer is in DB.
        customerService.delCustomer(id);
    }
    @PostMapping
    public Customer saveCustomer(@RequestBody Customer customer){
        return customerService.saveCustomer(customer);
    }
    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public Customer updateCustomer(@PathVariable Long id,@RequestBody Customer customer) {

        return customerService.updateCustomer(id,customer);
    }
}


