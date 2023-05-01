package com.service.serviceinterface;

import com.model.dto.CustomerDTO;

import java.util.List;

public interface CustomerMasterServiceInterface {
    void save(CustomerDTO dto);

    void update(CustomerDTO dto);

    void delete(CustomerDTO dto);

    CustomerDTO getById(String id);

    void saveOrUpdate(CustomerDTO dto);

    List<CustomerDTO> getCustomers();
}
