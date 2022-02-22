package com.example.customerservice;


import java.util.List;
import java.util.Arrays;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/Customers")
@RestController
public class CustomerController {
    private final static List<Customer> customers = Arrays.asList(
        new Customer(1, "Felix", "ABC Street", "felix@gmail.com"),
        new Customer(2, "Marzia", "ABC Street", "marzia@gmail.com"),
        new Customer(3, "Jane", "XYZ Street", "jane@gmail.com"),
        new Customer(4, "Max", "BCD Street", "max@gmail.com")
        );

    @GetMapping("/")
    public List<Customer> getAllCustomers() {
        return customers;
    }

    @GetMapping("/{id}")
    public Customer getCustomer(@PathVariable Integer id) {
        for(Customer customer: customers) {
            if(customer.getId() == id) {
                return customer;
            }
        }
        return new Customer();
    }
}
