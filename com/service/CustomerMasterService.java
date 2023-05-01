package com.service;

import com.model.dao.daointerface.CustomerMasterDAOInterface;
import com.model.dto.CustomerDTO;
import com.model.entity.CustomerMaster;
import com.service.serviceinterface.CustomerMasterServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerMasterService implements CustomerMasterServiceInterface {
    @Autowired
    CustomerMaster customerMaster;
    @Autowired
    ConverterService service;
    @Autowired
    CustomerMasterDAOInterface customerMasterDAO;
    @Autowired
    CustomerDTO customerDTO;

    @Override
    public void save(CustomerDTO dto){
        customerMaster = service.dtoToMaster(dto);
        customerMasterDAO.saveCustomer(customerMaster);
    }

    @Override
    public void update(CustomerDTO dto){
        customerMaster = service.dtoToMaster(dto);
        customerMasterDAO.updateCustomer(customerMaster);
    }

    @Override
    public void delete(CustomerDTO dto){
        customerMaster = service.dtoToMaster(dto);
        customerMasterDAO.deleteCustomer(customerMaster);
    }

    @Override
    public CustomerDTO getById(String id){
        System.out.println("id in master service: "+id);
        System.out.println(customerMasterDAO.getById(id));
        customerDTO = service.masterToDto(customerMasterDAO.getById(id));
        System.out.println(customerDTO);
        return customerDTO;
    }

    @Override
    public void saveOrUpdate(CustomerDTO dto){
        customerMaster = service.dtoToMaster(dto);
        customerMasterDAO.saveOrUpdateCustomer(customerMaster);
    }

    @Override
    public List<CustomerDTO> getCustomers(){
        List<CustomerMaster> masterCustomers = customerMasterDAO.getCustomers();
        List<CustomerDTO> dtoCustomers = new ArrayList<>();
        for(CustomerMaster c: masterCustomers){
            dtoCustomers.add(service.masterToDto(c));
        }
        return dtoCustomers;
    }

}
