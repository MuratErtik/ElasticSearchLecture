package com.example.ElasticSearchLecture.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.client.ClientConfiguration;
import org.springframework.data.elasticsearch.client.elc.ElasticsearchConfiguration;
import org.springframework.http.HttpHeaders;

//this configuration  for multinode
@Configuration
public class ElasticsearchConfig extends ElasticsearchConfiguration {

    @Override
    public ClientConfiguration clientConfiguration() {
        return ClientConfiguration.builder()
                .connectedTo("localhost:9200")//not necessary for single node http is ok
                .usingSsl() //not necessary for single node
                .withHeaders(() -> {
                    org.springframework.data.elasticsearch.support.HttpHeaders headers = new org.springframework.data.elasticsearch.support.HttpHeaders();
                    headers.add("Authorization", "ApiKey XXX");
                    return headers;
                })
                .build();
    }
}
