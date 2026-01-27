package com.example.ElasticSearchLecture.contollers;

import com.example.ElasticSearchLecture.entities.Customer;
import com.example.ElasticSearchLecture.repositories.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("customer")
public class CustomerController {

    private final CustomerRepository customerRepository;

    @GetMapping("/save")
    public void save() {
        customerRepository.save(Customer.builder().name("murat").build());
    }
}
