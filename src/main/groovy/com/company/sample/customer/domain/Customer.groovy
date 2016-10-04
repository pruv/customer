package com.company.sample.customer.domain

import com.fasterxml.jackson.annotation.JsonAutoDetect
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@JsonAutoDetect
@JsonIgnoreProperties(ignoreUnknown=true)
@Document(collection = 'customers')
class Customer {

    @Id
    String id
    String name
    String gender
    int age
    String email
    String phone
    Address address

}