package com.company.sample.customer.service

import com.company.sample.customer.domain.Customer
import com.company.sample.customer.dao.CustomerRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class CustomerService {

    @Autowired
    CustomerRepository customerRepository

    Customer getCustomer(String customerId){
        return customerRepository.findOne(customerId)
    }

    Customer addCustomer(Customer customer){
        return customerRepository.save(customer)
    }

    Customer updateCustomer(int customerId){
        return new Customer(id: customerId, name: 'updated customer')
    }

    void deleteCustomer(String customerId){
        customerRepository.delete(customerId)
    }

}
