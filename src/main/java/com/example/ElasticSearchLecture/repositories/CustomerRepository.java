package com.example.ElasticSearchLecture.repositories;


import com.example.ElasticSearchLecture.domain.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.scheduling.annotation.Async;

import java.util.List;
import java.util.concurrent.Future;
import java.util.stream.Stream;


public interface CustomerRepository extends ElasticsearchRepository<Customer,String> {

    Iterable<Customer> findByLastNameLike(String lastName);


    Iterable<Customer> findByNameLike(String lastName);

    //spring sends rest request to elasticsearch like this
    /*
    POST customer/_search
    {
        "query":{
            "bool" : {
                "must":{
                    {"query_string":{"query" : "?" , "fields":["name"]}},
                    {"query_string":{"query" : "?" , "fields":["lastname"]}}

                }
            }
        }
    }


     */
    List<Customer> findByNameAndLastName(String name, String lastName);

    Page<Customer> findByLastNameLike(String name,Pageable pageable);

    @Async
    Future<Iterable<Customer>> findAllByName(String name);

    @Query("select m from customer m") // when we are writing a query, this query will overwrite method
    Stream<Customer> findAllStream();


    @Query("{\"match\" : {\"name\" : {\"query\" : {\"?0\"}}}")
    Page<Customer>  fetchByName(String name,Pageable pageable);

    @Query("""
            
            {
                "bool":{
                    "must":[
                        {
                            "term":{
                                "name": "#{#name}"
                            }
                        }
                    ]
                }
            }
            
            """)
    List<Customer>  fetchByNameABCMethodNameDoesNotSense(String name,Pageable pageable);

}
