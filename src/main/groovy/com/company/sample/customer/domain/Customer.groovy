package com.company.sample.customer.domain

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

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