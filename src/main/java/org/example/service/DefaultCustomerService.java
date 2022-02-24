package org.example.service;
import org.example.model.Customer;
import org.example.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@Service("customerService")
public class DefaultCustomerService implements CustomerService {
@Autowired
    private CustomerRepository repository;

    // injecting the repository using the constructor
    //public DefaultCustomerService(CustomerRepository repository) {
        //this.repository = repository;}


    public void setRepository(CustomerRepository repository) {
        this.repository = repository;
    }

    public List<Customer> getAllCustomers() {

        return repository.findAll();
    }

    @Override
    public Customer getCustomerByID(Long id) {
        Optional<Customer> customerbyId = repository.findById(id);
// if(customerbyId.isPresent())
        return customerbyId.get();

    }

}

