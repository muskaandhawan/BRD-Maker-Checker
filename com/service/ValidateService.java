package com.service;

import com.model.dto.CustomerDTO;
import com.service.serviceinterface.CustomerMasterServiceInterface;
import com.service.serviceinterface.CustomerTempServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.regex.Pattern;

@Service
public class ValidateService {
    @Autowired
    private CustomerTempServiceInterface tempService;
    @Autowired
    private CustomerMasterServiceInterface masterService;
    private boolean matchPattern( String input, String regex, boolean isNotNull){
        if(isNotNull && input.isEmpty()){
            return false;
        }
        if(!isNotNull && input.isEmpty()){
            return true;
        }
        return Pattern.matches(regex, input);
    }

    public boolean validate(List<String> arr){

        if(!(matchPattern(arr.get(0), "^[a-zA-Z0-9 ,./-]*$",true) && matchPattern(arr.get(2),"^[a-zA-Z0-9 ,./-]*$", true) && matchPattern(arr.get(3),"^[a-zA-Z0-9 ,./-]*$", false))){
            return false;
        }

        if(!(matchPattern(arr.get(1),"^[a-zA-Z0-9]*$", true) && matchPattern(arr.get(7),"^[a-zA-Z0-9]*$", true))){
            return false;
        }

        if(!(matchPattern(arr.get(4),"^[1-9][0-9]{5,5}$", true) && matchPattern(arr.get(6),"^[1-9][0-9]{9,9}$", false))){
            return false;
        }

        if(!matchPattern(arr.get(5), "[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,}$", true)){
            return false;
        }

        if(arr.get(8).equals("Active") || arr.get(8).equals("A")){
            arr.set(8,"A");
        }
        else if (arr.get(8).equals("Inactive") || arr.get(8).equals("I")) {
            arr.set(8,"I");
        }
        else{
            return false;
        }

        return true;
    }

    public boolean codeExists(String code){
        List<CustomerDTO> tempCustomers = tempService.getCustomers();
        List<CustomerDTO> masterCustomers = masterService.getCustomers();
        for(CustomerDTO c: tempCustomers){
            if(c.getCustomerCode().equals(code)){
                return true;
            }
        }
        for(CustomerDTO c: masterCustomers){
            if(c.getCustomerCode().equals(code)){
                return true;
            }
        }
        return false;
    }
}
