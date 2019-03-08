package com.example.bine.customer;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class CustomerDAO {

    @Autowired
    EntityManager entityManager;

    public List<CustomerDBO> getAllCustomers(){

        String nativeQuery = "SELECT * FROM CUSTOMER";
        return  entityManager.createNativeQuery(nativeQuery, CustomerDBO.class).getResultList();


    }

    public CustomerDBO saveCustomer(CustomerDBO customerDBO) {

        return entityManager.merge(customerDBO);
    }
}
