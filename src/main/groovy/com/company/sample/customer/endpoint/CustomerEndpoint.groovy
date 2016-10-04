package com.company.sample.customer.endpoint

import com.company.sample.customer.domain.Customer
import com.company.sample.customer.service.CustomerService
import io.swagger.annotations.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

import javax.ws.rs.*

@RestController
@RequestMapping( path="/v1", produces = "application/json;charset=UTF-8")
@Api(value = "/v1", description = "Customer operations")
class CustomerEndpoint {

    @Autowired
    CustomerService customerService

    @RequestMapping(method = RequestMethod.GET, path="/customer/{customerId}", produces = "application/json")
    @ApiOperation(value = "Returns the customer by id", response = Customer.class)
    @ApiResponses([
            @ApiResponse(code = 400, message = "Missing customerId query param"),
            @ApiResponse(code = 404, message = "Unable to find customer based on customerId")
    ])
    Customer getCustomer(@ApiParam('customerId to idetify customer.') @PathVariable('customerId') String customerId) {
        return customerService.getCustomer(customerId);
    }

    @RequestMapping(method = RequestMethod.POST, path="/customer", produces = "application/json")
    @ApiOperation(value = "Add an item to the basket")
    @ApiResponses([
            @ApiResponse(code = 400, message = "bad data in customer request, failed add customer business rules")
    ])
    Customer addCustomer(@ApiParam(value = "Allowed attributes => name,") @RequestBody Customer customer
    ) {
        return customerService.addCustomer(customer)
    }

    @RequestMapping(method = RequestMethod.PATCH, path="/customer/{customerId}", produces = "application/json")
    @ApiOperation(value = "Updates an item in the basket")
    @ApiResponses([
            @ApiResponse(code = 400, message = "Missing customerId query param"),
            @ApiResponse(code = 404, message = "Unable to find customer based on customerId")
    ])
    Customer updateCustomer(@ApiParam('customerId to idetify customer.') @PathVariable('customerId') String customerId) {
        return customerService.updateCustomer(Integer.parseInt(customerId))
    }

    @RequestMapping(method = RequestMethod.DELETE, path="/customer/{customerId}", produces = "application/json")
    @ApiOperation(value = "Delete the basket")
    @ApiResponses([
            @ApiResponse(code = 204, message = "Operation succeeded.  No body to return."),
            @ApiResponse(code = 400, message = "Missing customerId query param"),
            @ApiResponse(code = 404, message = "Unable to find customer based on customerId")
    ])
    void deleteCustomer(@ApiParam('customerId to idetify customer.')@PathVariable('customerId') String customerId) {
        customerService.deleteCustomer(customerId)
    }

}
