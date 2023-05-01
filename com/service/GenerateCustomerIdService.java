package com.service;

import com.model.dto.CustomerDTO;
import com.service.serviceinterface.CustomerMasterServiceInterface;
import com.service.serviceinterface.CustomerTempServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GenerateCustomerIdService {
    @Autowired
    private CustomerTempServiceInterface tempService;
    @Autowired
    private CustomerMasterServiceInterface masterService;

    public int generatedId(){
        List<CustomerDTO> customers = tempService.getCustomers();
        customers.addAll(masterService.getCustomers());
        List<Integer> ids = new ArrayList<>();
        int id = 0;

        for(CustomerDTO c: customers){
            ids.add(c.getCustomerId());
        }

        for(int i=1;i<=Integer.MAX_VALUE;i++){
            if(!(ids.contains(i))){
                id=i;
                break;
            }
        }

        return id;
    }
}
