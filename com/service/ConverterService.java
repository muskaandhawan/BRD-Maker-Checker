package com.service;

import com.model.dto.CustomerDTO;
import com.model.entity.CustomerMaster;
import com.model.entity.CustomerTemp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConverterService {
    // converts CustomerDTO obj to CustomerTemp obj
    public CustomerTemp dtoToTemp(CustomerDTO customerDTO){
        CustomerTemp customerTemp = new CustomerTemp();
        customerTemp.setCustomerId(customerDTO.getCustomerId());
        customerTemp.setCustomerCode(customerDTO.getCustomerCode());
        customerTemp.setCustomerName(customerDTO.getCustomerName());
        customerTemp.setCustomerAddress1(customerDTO.getCustomerAddress1());
        customerTemp.setCustomerAddress2(customerDTO.getCustomerAddress2());
        customerTemp.setCustomerPinCode(customerDTO.getCustomerPinCode());
        customerTemp.setEmailAddress(customerDTO.getEmailAddress());
        customerTemp.setContactNumber(customerDTO.getContactNumber());
        customerTemp.setPrimaryContactPerson(customerDTO.getPrimaryContactPerson());
        customerTemp.setRecordStatus(customerDTO.getRecordStatus());
        customerTemp.setActiveInactiveFlag(customerDTO.getActiveInactiveFlag());
        customerTemp.setCreateDate(customerDTO.getCreateDate());
        customerTemp.setCreatedBy(customerDTO.getCreatedBy());
        customerTemp.setModifiedDate(customerDTO.getModifiedDate());
        customerTemp.setModifiedBy(customerDTO.getModifiedBy());
        customerTemp.setAuthorizedDate(customerDTO.getAuthorizedDate());
        customerTemp.setAuthorizedBy(customerDTO.getAuthorizedBy());
        return customerTemp;
    }

    // converts CustomerDTO obj to CustomerMaster obj
    public CustomerMaster dtoToMaster(CustomerDTO customerDTO){
        CustomerMaster customerMaster = new CustomerMaster();
        customerMaster.setCustomerId(customerDTO.getCustomerId());
        customerMaster.setCustomerCode(customerDTO.getCustomerCode());
        customerMaster.setCustomerName(customerDTO.getCustomerName());
        customerMaster.setCustomerAddress1(customerDTO.getCustomerAddress1());
        customerMaster.setCustomerAddress2(customerDTO.getCustomerAddress2());
        customerMaster.setCustomerPinCode(customerDTO.getCustomerPinCode());
        customerMaster.setEmailAddress(customerDTO.getEmailAddress());
        customerMaster.setContactNumber(customerDTO.getContactNumber());
        customerMaster.setPrimaryContactPerson(customerDTO.getPrimaryContactPerson());
        customerMaster.setRecordStatus(customerDTO.getRecordStatus());
        customerMaster.setActiveInactiveFlag(customerDTO.getActiveInactiveFlag());
        customerMaster.setCreateDate(customerDTO.getCreateDate());
        customerMaster.setCreatedBy(customerDTO.getCreatedBy());
        customerMaster.setModifiedDate(customerDTO.getModifiedDate());
        customerMaster.setModifiedBy(customerDTO.getModifiedBy());
        customerMaster.setAuthorizedDate(customerDTO.getAuthorizedDate());
        customerMaster.setAuthorizedBy(customerDTO.getAuthorizedBy());
        return customerMaster;
    }

    // converts CustomerTemp obj to CustomerMaster obj
    public CustomerMaster tempToMaster(CustomerTemp customerTemp){
        CustomerMaster customerMaster = new CustomerMaster();
        customerMaster.setCustomerId(customerTemp.getCustomerId());
        customerMaster.setCustomerCode(customerTemp.getCustomerCode());
        customerMaster.setCustomerName(customerTemp.getCustomerName());
        customerMaster.setCustomerAddress1(customerTemp.getCustomerAddress1());
        customerMaster.setCustomerAddress2(customerTemp.getCustomerAddress2());
        customerMaster.setCustomerPinCode(customerTemp.getCustomerPinCode());
        customerMaster.setEmailAddress(customerTemp.getEmailAddress());
        customerMaster.setContactNumber(customerTemp.getContactNumber());
        customerMaster.setPrimaryContactPerson(customerTemp.getPrimaryContactPerson());
        customerMaster.setRecordStatus(customerTemp.getRecordStatus());
        customerMaster.setActiveInactiveFlag(customerTemp.getActiveInactiveFlag());
        customerMaster.setCreateDate(customerTemp.getCreateDate());
        customerMaster.setCreatedBy(customerTemp.getCreatedBy());
        customerMaster.setModifiedDate(customerTemp.getModifiedDate());
        customerMaster.setModifiedBy(customerTemp.getModifiedBy());
        customerMaster.setAuthorizedDate(customerTemp.getAuthorizedDate());
        customerMaster.setAuthorizedBy(customerTemp.getAuthorizedBy());
        return customerMaster;
    }

    // converts CustomerTemp obj to CustomerDTO obj
    public CustomerDTO tempToDto(CustomerTemp customerTemp){
        if(customerTemp==null){
            return null;
        }
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setCustomerId(customerTemp.getCustomerId());
        customerDTO.setCustomerCode(customerTemp.getCustomerCode());
        customerDTO.setCustomerName(customerTemp.getCustomerName());
        customerDTO.setCustomerAddress1(customerTemp.getCustomerAddress1());
        customerDTO.setCustomerAddress2(customerTemp.getCustomerAddress2());
        customerDTO.setCustomerPinCode(customerTemp.getCustomerPinCode());
        customerDTO.setEmailAddress(customerTemp.getEmailAddress());
        customerDTO.setContactNumber(customerTemp.getContactNumber());
        customerDTO.setPrimaryContactPerson(customerTemp.getPrimaryContactPerson());
        customerDTO.setRecordStatus(customerTemp.getRecordStatus());
        customerDTO.setActiveInactiveFlag(customerTemp.getActiveInactiveFlag());
        customerDTO.setCreateDate(customerTemp.getCreateDate());
        customerDTO.setCreatedBy(customerTemp.getCreatedBy());
        customerDTO.setModifiedDate(customerTemp.getModifiedDate());
        customerDTO.setModifiedBy(customerTemp.getModifiedBy());
        customerDTO.setAuthorizedDate(customerTemp.getAuthorizedDate());
        customerDTO.setAuthorizedBy(customerTemp.getAuthorizedBy());
        return customerDTO;
    }

    // converts CustomerMaster obj to CustomerDTO obj
    public CustomerDTO masterToDto(CustomerMaster customerMaster){
        if(customerMaster==null){
            return null;
        }
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setCustomerId(customerMaster.getCustomerId());
        customerDTO.setCustomerCode(customerMaster.getCustomerCode());
        customerDTO.setCustomerName(customerMaster.getCustomerName());
        customerDTO.setCustomerAddress1(customerMaster.getCustomerAddress1());
        customerDTO.setCustomerAddress2(customerMaster.getCustomerAddress2());
        customerDTO.setCustomerPinCode(customerMaster.getCustomerPinCode());
        customerDTO.setEmailAddress(customerMaster.getEmailAddress());
        customerDTO.setContactNumber(customerMaster.getContactNumber());
        customerDTO.setPrimaryContactPerson(customerMaster.getPrimaryContactPerson());
        customerDTO.setRecordStatus(customerMaster.getRecordStatus());
        customerDTO.setActiveInactiveFlag(customerMaster.getActiveInactiveFlag());
        customerDTO.setCreateDate(customerMaster.getCreateDate());
        customerDTO.setCreatedBy(customerMaster.getCreatedBy());
        customerDTO.setModifiedDate(customerMaster.getModifiedDate());
        customerDTO.setModifiedBy(customerMaster.getModifiedBy());
        customerDTO.setAuthorizedDate(customerMaster.getAuthorizedDate());
        customerDTO.setAuthorizedBy(customerMaster.getAuthorizedBy());
        return customerDTO;
    }
}
