package com.example.ElasticSearchLecture.services;

import com.example.ElasticSearchLecture.domain.Customer;
import com.example.ElasticSearchLecture.repositories.CustomerRepository;
import com.example.ElasticSearchLecture.requests.CustomerSaveRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;


    public Customer saveCustomer(CustomerSaveRequest customer) {

        Customer customer1 =Customer.builder()
                .name(customer.getName())
                .age(customer.getAge())
                .lastName(customer.getLastName())
                .fullName(customer.getName()+" "+customer.getLastName())
                .isActive(true)
                .build();

        return customerRepository.save(customer1);
    }

    public Iterable<Customer> getAllCustomer() {
        return customerRepository.findAll();
    }
}
