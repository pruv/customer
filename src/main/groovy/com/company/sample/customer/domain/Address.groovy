package com.company.sample.customer.domain

import com.fasterxml.jackson.annotation.JsonAutoDetect
import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties(ignoreUnknown=true)
class Address {

    String firstLine
    String secondLine
    String city
    String state
    String zipCode
}