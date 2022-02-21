package org.example.repository;

import org.example.model.Customer;

import java.util.List;

import static java.util.Arrays.asList;

public class CustomerRepositoryStub implements CustomerRepository {
public List<Customer> findAll()
{
    return asList(
            new Customer("1","Brijesh","New delhi"),
            new Customer("2","Dharmesh","New delhi"),
            new Customer("3","Taniya","New delhi")

    );

}
}
