package org;
import org.model.Customer;
import org.service.DefaultCustomerService;

import java.util.List;

    public class Application {

        public static void main(String[] args) {
            DefaultCustomerService service = new DefaultCustomerService();

            List<Customer> customers = service.getAllCustomers();

            customers.forEach(System.out::println);

        }
    }

