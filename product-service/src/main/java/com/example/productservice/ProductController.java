package com.example.productservice;


import java.util.List;
import java.util.Arrays;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/Products")
@RestController
public class ProductController {
    private final static List<Product> products = Arrays.asList(
        new Product(1, "iPhone", "ABC", 100000.00),
        new Product(2, "Galaxy s20", "ABCDE", 80000.00)
        );

    @GetMapping("/")
    public List<Product> getAllProducts() {
        return products;
    }

    @GetMapping("/{id}")
    public Product getProducts(@PathVariable Integer id) {
        for(Product product: products) {
            if(product.getId() == id) {
                return product;
            }
        }
        return new Product();
    }
}
