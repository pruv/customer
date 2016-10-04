package com.company.sample.customer.dao

import com.company.sample.customer.domain.Customer
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Component

/**
 * Created by java on 10/3/16.
 */
public interface CustomerRepository extends MongoRepository<Customer, String> {
}
