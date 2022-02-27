package org.example.service;
import org.example.model.Customer;
import org.example.repository.CustomerRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

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
    public ResponseEntity<Customer> getCustomer(Long id) {
        Optional<Customer> optionalCustomer = repository.findById(id);
        if (optionalCustomer.isPresent()) {
            return new ResponseEntity<>(optionalCustomer.get(), HttpStatus.OK);

        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "customer not found");
    }

    @Override
    public void delCustomer(Long id) {
//before deleting, verify that customer is in DB.
        Optional<Customer> optionalCustomer = repository.findById(id);
        if (optionalCustomer.isPresent()) {
            repository.deleteById(id);
        }
// return new ResponseEntity<>(optionalCustomer.get(),HttpStatus.OK);
        throw new ResponseStatusException(HttpStatus.OK, "customer succesfully deleted");
    }
    @Override
    public Customer saveCustomer(Customer customer)
    {
        return repository.saveAndFlush(customer);
    }
    @Override
    public Customer updateCustomer(Long id, Customer customer) {
        ResponseEntity<Customer> responseEntity = getCustomer(id);
        if(responseEntity.getStatusCode().is4xxClientError()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "invalid customer id");
        }
        Customer existingCustomer = responseEntity.getBody();
        BeanUtils.copyProperties(customer, existingCustomer, "id");
        return repository.saveAndFlush(existingCustomer);
    }
}

