package com.model.entity;

import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@Component
@Entity
@Table(name = "Customer_Master_Muskaan")
public class CustomerMaster implements Serializable {
    private static final long serialVersionUID = 86334166715L;

    @Column(name = "CUSTOMER_ID")
    int customerId;
    @Id
    @Column(name = "CUSTOMER_CODE")
    String customerCode;
    @Column(name = "CUSTOMER_NAME")
    String customerName;
    @Column(name = "CUSTOMER_ADDRESS1")
    String customerAddress1;
    @Column(name = "CUSTOMER_ADDRESS2")
    String customerAddress2;
    @Column(name = "CUSTOMER_PINCODE")
    String customerPinCode;
    @Column(name = "EMAIL_ADDRESS")
    String emailAddress;
    @Column(name = "CONTACT_NUMBER")
    String contactNumber;
    @Column(name = "PRIMARY_CONTACT_PERSON")
    String primaryContactPerson;
    @Column(name = "RECORD_STATUS")
    String recordStatus;
    @Column(name = "ACTIVE_INACTIVE_FLAG")
    char activeInactiveFlag;
    @Column(name = "CREATED_DATE")
    Date createDate;
    @Column(name = "CREATED_BY")
    String createdBy;
    @Column(name = "MODIFIED_DATE")
    Date modifiedDate;
    @Column(name = "MODIFIED_BY")
    String modifiedBy;
    @Column(name = "AUTHORIZED_DATE")
    Date authorizedDate;
    @Column(name = "AUTHORIZED_BY")
    String authorizedBy;

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getCustomerCode() {
        return customerCode;
    }

    public void setCustomerCode(String customerCode) {
        this.customerCode = customerCode;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerAddress1() {
        return customerAddress1;
    }

    public void setCustomerAddress1(String customerAddress1) {
        this.customerAddress1 = customerAddress1;
    }

    public String getCustomerAddress2() {
        return customerAddress2;
    }

    public void setCustomerAddress2(String customerAddress2) {
        this.customerAddress2 = customerAddress2;
    }

    public String getCustomerPinCode() {
        return customerPinCode;
    }

    public void setCustomerPinCode(String customerPinCode) {
        this.customerPinCode = customerPinCode;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getPrimaryContactPerson() {
        return primaryContactPerson;
    }

    public void setPrimaryContactPerson(String primaryContactPerson) {
        this.primaryContactPerson = primaryContactPerson;
    }

    public String getRecordStatus() {
        return recordStatus;
    }

    public void setRecordStatus(String recordStatus) {
        this.recordStatus = recordStatus;
    }

    public char getActiveInactiveFlag() {
        return activeInactiveFlag;
    }

    public void setActiveInactiveFlag(char activeInactiveFlag) {
        this.activeInactiveFlag = activeInactiveFlag;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Date getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public String getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public Date getAuthorizedDate() {
        return authorizedDate;
    }

    public void setAuthorizedDate(Date authorizedDate) {
        this.authorizedDate = authorizedDate;
    }

    public String getAuthorizedBy() {
        return authorizedBy;
    }

    public void setAuthorizedBy(String authorizedBy) {
        this.authorizedBy = authorizedBy;
    }

//    @Override
//    public String toString() {
//        return "CustomerMaster{" +
//                "customerId=" + customerId +
//                ", customerCode='" + customerCode + '\'' +
//                ", customerName='" + customerName + '\'' +
//                ", customerAddress1='" + customerAddress1 + '\'' +
//                ", customerAddress2='" + customerAddress2 + '\'' +
//                ", customerPinCode='" + customerPinCode + '\'' +
//                ", emailAddress='" + emailAddress + '\'' +
//                ", contactNumber='" + contactNumber + '\'' +
//                ", primaryContactPerson='" + primaryContactPerson + '\'' +
//                ", recordStatus=" + recordStatus +
//                ", activeInactiveFlag=" + activeInactiveFlag +
//                ", createDate=" + createDate +
//                ", createdBy='" + createdBy + '\'' +
//                ", modifiedDate=" + modifiedDate +
//                ", modifiedBy='" + modifiedBy + '\'' +
//                ", authorizedDate=" + authorizedDate +
//                ", authorizedBy='" + authorizedBy + '\'' +
//                '}';
//    }

    @Override
    public String toString() {
        return "CustomerMaster{" +
                "customerId=" + customerId +
                ", customerCode='" + customerCode + '\'' +
                ", customerName='" + customerName + '\'' +
                ", recordStatus=" + recordStatus +
                '}';
    }
}


