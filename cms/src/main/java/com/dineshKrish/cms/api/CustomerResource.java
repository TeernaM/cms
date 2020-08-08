package com.dineshKrish.cms.api;

import com.dineshKrish.cms.model.Customer;
import com.dineshKrish.cms.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/customer") //whenever the client requests with this endpoint this class should be triggered
public class CustomerResource {

    @Autowired //inject the customerService to this resource class
    private CustomerService customerService;
    /*how are we going to get this customer object from the user?. In order to do that we have to use the annotation
    * called @RequestBody. Using this annotation you can pass the customer json and that will be converted
    * to customer object which can be passed to addCustomer method in the service class*/
    @PostMapping
    public Customer addCustomer(@RequestBody Customer customer){

        return customerService.addCustomer(customer);
    }

    @GetMapping
    public List<Customer> getCustomers(){

        return customerService.getCustomers();
    }

    /*In order to receive the customerId from the request and store it inside the customerId you have to use
    @PathVariable
    */
    @GetMapping(value = "/{customerId}")
    public Customer getCustomer(@PathVariable("customerId") int customerId){
        return customerService.getCustomer(customerId);
    }

    @PutMapping(value = "/{customerId}")
    public Customer updateCustomer(@PathVariable("customerId") int customerId, @RequestBody Customer customer){
            return  customerService.updateCustomer(customerId, customer);
    }

    @DeleteMapping(value = "/{customerId}")
    public void deleteCustomer(@PathVariable("customerId") int customerId){
        customerService.deleteCustomer(customerId);
    }
}
