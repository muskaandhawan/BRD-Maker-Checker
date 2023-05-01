package com.model.dao.daointerface;

import com.model.entity.CustomerTemp;

import java.util.List;


public interface CustomerTempDAOInterface {
    void saveCustomer(CustomerTemp customer);

    void updateCustomer(CustomerTemp customer);

    void deleteCustomer(CustomerTemp customer);

    CustomerTemp getById(String id);

    void saveOrUpdateCustomer(CustomerTemp customer);

    List<CustomerTemp> getCustomers();
}
