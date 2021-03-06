package com.example.bine.customer;


import com.example.bine.annotations.MDCLogged;
import com.example.bine.annotations.MDCTupleLogged;
import com.example.bine.annotations.Timed;
import com.googlecode.jmapper.JMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerService {

    @Autowired
    private CustomerDAO customerDAO;

    @Autowired
    private JMapper<CustomerDTO, CustomerDBO> customerDBO2DTOMapper;

    @Autowired
    private JMapper<CustomerDBO, CustomerDTO> customerDTO2DBOMapper;

    //@MDCLogged(putLabels = {"firstName","lastName"},removeLabels = {"country"})
    @MDCLogged(labelsAndValues = {@MDCTupleLogged(label = "firstName",value = "Bine")})
    @Transactional
    public List<CustomerDTO> getAllCustomers(){


        List<CustomerDBO> customers =  customerDAO.getAllCustomers();
        List<CustomerDTO> resultListOfCustomers = new ArrayList<>();

        customers.stream().forEach( x -> resultListOfCustomers.add( customerDBO2DTOMapper.getDestination(x)));

        return resultListOfCustomers;
    }

    @Transactional
    public CustomerDTO saveCustomer(String firstName, String lastName){

        CustomerDBO newCustomer = new CustomerDBO();
        newCustomer.setFirstName(firstName);
        newCustomer.setLastName(lastName);

        return customerDBO2DTOMapper.getDestination(customerDAO.saveCustomer(newCustomer));
    }

    @MDCLogged(labelsAndValues = {@MDCTupleLogged(label = "firstName",value = "Bine")})
    public void addLogging(String label, String value){

    }

    @Timed
    @Transactional
    public List<CustomerDTO> getAllCustomersForAddressId(Integer addressId) {

        List<CustomerDBO> allCustomersForAddressId = customerDAO.getAllCustomersForAddressId(addressId);
        List<CustomerDTO> resultList = new ArrayList<>();
        allCustomersForAddressId.stream().forEach(x -> resultList.add(customerDBO2DTOMapper.getDestination(x)));
        return resultList;
    }
}
