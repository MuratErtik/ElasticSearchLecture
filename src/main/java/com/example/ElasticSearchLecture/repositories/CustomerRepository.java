package com.example.ElasticSearchLecture.repositories;


import com.example.ElasticSearchLecture.entities.Customer;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;


public interface CustomerRepository extends ElasticsearchRepository<Customer,String> {
}
