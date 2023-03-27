package com.csi.controller;

import com.csi.exception.RecordNotFoundException;
import com.csi.model.Customer;
import com.csi.service.CustomerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class CustomerController {
    @Autowired
    CustomerServiceImpl customerServiceImpl;

    @PostMapping("/savedata")
    public ResponseEntity<Customer>saveData(@RequestBody Customer customer){
        return new ResponseEntity<>(customerServiceImpl.saveData(customer), HttpStatus.CREATED);
    }
    @GetMapping("/getdatabyid/{custId}")
    public ResponseEntity<Optional<Customer>> getDataByID(@PathVariable int custId){
        return ResponseEntity.ok(customerServiceImpl.getDataById(custId));
    }

    @GetMapping("/getalldata")
    public ResponseEntity<List<Customer>>getAllData(){
        return ResponseEntity.ok(customerServiceImpl.getAllData());
    }

    @PutMapping("/updatedata/{custId}")
    public ResponseEntity<Customer> updateData(@PathVariable int custId, @RequestBody Customer customer) throws RecordNotFoundException {
        Customer customer1= customerServiceImpl.getDataById(custId).orElseThrow(()-> new RecordNotFoundException("Id does not exist"));
        customer1.setCustName(customer.getCustName());
        customer1.setCustAddress(customer.getCustAddress());
        customer1.setCustDOB(customer.getCustDOB());
        customer1.setCustAccBal(customer.getCustAccBal());
        return ResponseEntity.ok(customerServiceImpl.updateData(customer1));

    }

    @DeleteMapping("/deletebyid/{custId}")
    public ResponseEntity<String>deleteById(@PathVariable int custId){
        customerServiceImpl.deleteById(custId);
        return ResponseEntity.ok("Data Deleted successfully");
    }
}
