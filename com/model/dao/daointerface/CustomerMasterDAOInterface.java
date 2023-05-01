package com.model.dao.daointerface;

import com.model.entity.CustomerMaster;

import java.util.List;


public interface CustomerMasterDAOInterface {
    void saveCustomer(CustomerMaster customer);

    void updateCustomer(CustomerMaster customer);

    void deleteCustomer(CustomerMaster customer);

    CustomerMaster getById(String id);

    void saveOrUpdateCustomer(CustomerMaster customer);

    List<CustomerMaster> getCustomers();
}
