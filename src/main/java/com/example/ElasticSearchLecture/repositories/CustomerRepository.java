package com.example.ElasticSearchLecture.repositories;


import com.example.ElasticSearchLecture.domain.Customer;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;


public interface CustomerRepository extends ElasticsearchRepository<Customer,String> {
}
