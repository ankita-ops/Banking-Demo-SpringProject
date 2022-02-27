package org.example.service;
import org.example.model.Customer;
import org.springframework.http.ResponseEntity;

import java.util.List;

    public interface CustomerService {

        public List<Customer> getAllCustomers();

        ResponseEntity<Customer> getCustomer(Long id);

       public void delCustomer(Long id);

        Customer saveCustomer(Customer customer);

        Customer updateCustomer(Long id, Customer customer);
    }

