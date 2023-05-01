package com.service;

import com.model.dto.CustomerDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MakeDtoObjService {
    @Autowired
    CustomerDTO customer;

    public CustomerDTO makeObj(List<String> arr){
        customer = new CustomerDTO();
        customer.setCustomerCode(arr.get(0));
        customer.setCustomerName(arr.get(1));
        customer.setCustomerAddress1(arr.get(2));
        customer.setCustomerAddress2(arr.get(3));
        customer.setCustomerPinCode(arr.get(4));
        customer.setEmailAddress(arr.get(5));
        customer.setContactNumber(arr.get(6));
        customer.setPrimaryContactPerson(arr.get(7));
        customer.setActiveInactiveFlag(arr.get(8).charAt(0));
        return customer;
    }
}
