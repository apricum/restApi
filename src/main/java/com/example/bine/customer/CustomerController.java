package com.example.bine.customer;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;


    @GetMapping
    @ResponseStatus(value = HttpStatus.OK)
    public List<CustomerDTO> getAllCustomers(){
        return customerService.getAllCustomers();
    }

    @PostMapping
    @ResponseStatus(value = HttpStatus.OK)
    public CustomerDTO saveCustomer(@RequestParam() String firstName, @RequestParam() String lastName){
        return customerService.saveCustomer(firstName,lastName);
    }

}
