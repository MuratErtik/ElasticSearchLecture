package com.example.ElasticSearchLecture.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.domain.Range;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Document(indexName = "customer")
@TypeAlias("CustomerClass") //it ll change _class name
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
    @Id
    String id;

    @Field(name = "customerName")
    String name;

    String lastName;

    @Transient // do not hash in DB
    String fullName;

    Long age;

    Boolean isActive;

//    @Field(type = FieldType.Integer_Range)
//    Range<Integer> ageRange; //gte,lte
}
