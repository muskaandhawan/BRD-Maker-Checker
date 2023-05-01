package com.service;

import com.model.dao.daointerface.CustomerTempDAOInterface;
import com.model.dto.CustomerDTO;
import com.model.entity.CustomerTemp;
import com.service.serviceinterface.CustomerTempServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerTempService implements CustomerTempServiceInterface {
    @Autowired
    private ConverterService service;
    @Autowired
    private CustomerDTO customerDTO;
    @Autowired
    private CustomerTemp customerTemp;
    @Autowired
    private CustomerTempDAOInterface customerTempDAO;

    @Override
    public void save(CustomerDTO dto){
        customerTemp = service.dtoToTemp(dto);
        customerTempDAO.saveCustomer(customerTemp);
    }

    @Override
    public void update(CustomerDTO dto){
        customerTemp = service.dtoToTemp(dto);
        customerTempDAO.updateCustomer(customerTemp);
    }

    @Override
    public void delete(CustomerDTO dto){
        customerTemp = service.dtoToTemp(dto);
        customerTempDAO.deleteCustomer(customerTemp);
    }

    @Override
    public CustomerDTO getById(String id){
        customerDTO = service.tempToDto(customerTempDAO.getById(id));
        return customerDTO;
    }

    @Override
    public void saveOrUpdate(CustomerDTO dto){
        System.out.println("save or update service: "+dto);
        customerTemp = service.dtoToTemp(dto);
        customerTempDAO.saveOrUpdateCustomer(customerTemp);
    }

    @Override
    public List<CustomerDTO> getCustomers(){
        List<CustomerTemp> tempCustomers = customerTempDAO.getCustomers();
//        System.out.println("temp cust " + tempCustomers);
        List<CustomerDTO> dtoCustomers = new ArrayList<>();
        for(CustomerTemp c: tempCustomers){
//            System.out.println("c: "+c);
            dtoCustomers.add(service.tempToDto(c));
//            dtoCustomers.add(service.tempToDto(c));
//            System.out.println(dtoCustomers);
//            System.out.println("c to dto: "+service.tempToDto(c));
        }
//        System.out.println("temp dto cust: " + dtoCustomers);
        return dtoCustomers;
    }
}
