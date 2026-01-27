package com.example.ElasticSearchLecture.contollers;

import com.example.ElasticSearchLecture.domain.Customer;
import com.example.ElasticSearchLecture.repositories.CustomerRepository;
import com.example.ElasticSearchLecture.requests.CustomerSaveRequest;
import com.example.ElasticSearchLecture.services.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/customer")
public class CustomerController {

    private final CustomerService customerService;

//    @GetMapping("/save")
//    public void save() {
//        customerRepository.save(Customer.builder().name("murat").build());
//    }

    @PostMapping("/save")
    public ResponseEntity<Customer> saveCustomer(@RequestBody CustomerSaveRequest customer) {

        return ResponseEntity.ok(customerService.saveCustomer(customer));

    }

    @GetMapping("/get-all")
    public ResponseEntity<Iterable<Customer>> getAllCustomers() {
        return ResponseEntity.ok(customerService.getAllCustomer());
    }
}
