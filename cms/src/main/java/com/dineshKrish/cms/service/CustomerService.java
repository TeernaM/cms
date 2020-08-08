package com.dineshKrish.cms.service;

import com.dineshKrish.cms.dao.CustomerDao;
import com.dineshKrish.cms.exception.CustomerNotFoundException;
import com.dineshKrish.cms.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CopyOnWriteArrayList;

@Component //to use the autowired annotation in the resource class
public class CustomerService {

    @Autowired
    private CustomerDao customerDao;
    private int customerIdCount = 1;
    private List<Customer> customerList = new CopyOnWriteArrayList<>();

    public Customer addCustomer(Customer customer){
//        customer.setCustomerId(customerIdCount);
//        customerList.add(customer);
//        customerIdCount++;
//        return customer;
        return customerDao.save(customer);
    }

    public List<Customer> getCustomers(){
        //return customerList;
        return customerDao.findAll();
    }
    public Customer getCustomer(int customerId){
//        return customerList
//                .stream()
//                .filter(customer -> customer.getCustomerId() == customerId)
//                .findFirst()
//                .get();
        Optional<Customer> optionalCustomer = customerDao.findById(customerId);
        if(!optionalCustomer.isPresent())
            throw new CustomerNotFoundException("customer record not found");
        return optionalCustomer.get();
    }
    public Customer updateCustomer(int customerId, Customer customer){
      //  customerList
//                .stream()
//                .forEach( customer1 -> {
//                        if(customer1.getCustomerId() == customerId){
//                            customer1.setCustomerFirstName(customer.getCustomerFirstName());
//                            customer1.setCustomerLastName(customer.getCustomerLastName());
//                            customer1.setCustomerEmail(customer.getCustomerEmail());
//                        }
//                });
//        return  customerList
//                .stream()
//                .filter(c -> c.getCustomerId() == customerId)
//                .findFirst()
//                .get();
        customer.setCustomerId(customerId);
        return customerDao.save(customer);

    }
    public void deleteCustomer(int customerId){

//        customerList
//                .stream()
//                .forEach(customer -> {
//                    if(customer.getCustomerId() == customerId){
//                        customerList.remove(customer);
//                    }
//                });
        customerDao.deleteById(customerId);
    }
}
