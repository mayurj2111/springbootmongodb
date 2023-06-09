package com.csi.dao;

import com.csi.model.Customer;
import com.csi.repo.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class CustomerDaoImpl {
    @Autowired
    CustomerRepository customerRepositoryImpl;

    public Customer saveData(Customer customer){
        return customerRepositoryImpl.save(customer);
    }

    public Optional<Customer> getDataById(int custId){
        return customerRepositoryImpl.findById(custId);
    }

    public List<Customer> getAllData(){
        return customerRepositoryImpl.findAll();

    }

    public Customer updateData(Customer customer){
        return customerRepositoryImpl.save(customer);
    }

    public void deleteById(int custId){
        customerRepositoryImpl.deleteById(custId);
    }
}
