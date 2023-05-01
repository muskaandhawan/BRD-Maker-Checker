package com.model.dto;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.sql.Date;

@Component
public class CustomerDTO {
    int customerId;
    @NotNull
    @Pattern(regexp = "^[a-zA-Z0-9]*$", message = "Spaces and special characters are not allowed")
    String customerCode;
    @NotEmpty(message = "Customer name cannot be null and must have size greater than 0")
    @Pattern(regexp = "^[A-Za-z ]+$", message = "Customer name must include only alphabets")
    String customerName;
    @NotBlank
    @Pattern(regexp = "^[a-zA-Z0-9 ,./-]*$", message = "Special characters are not allowed")
    String customerAddress1;
    @Pattern(regexp = "^[a-zA-Z0-9 ,./-]*$", message = "Special characters are not allowed")
    String customerAddress2;
    @NotNull
    @Size(min = 6, max = 6, message = "Pin code must contain exactly 6 digits")
    @Pattern(regexp = "^[1-9][0-9]*$", message = "Pin code must contain only numbers")
    String customerPinCode;
    @NotNull
    @Email(message = "Not a valid Email!")
    String emailAddress;
//    @NotNull
    @Size(min = 10, max = 10, message = "Contact number must contain exactly 10 digits")
    @Pattern(regexp = "^[1-9][0-9]*$", message = "Contact number must contain only numbers")
    String contactNumber;
    @NotNull
    @Pattern(regexp = "^[A-Za-z ]+$", message = "Contact person name must include only alphabets")
    String primaryContactPerson;
    String recordStatus;
    @NotNull
    char activeInactiveFlag;
    Date createDate;
    String createdBy;
    Date modifiedDate;
    String modifiedBy;
    Date authorizedDate;
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
//        return "CustomerDTO{" +
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
        return "CustomerDTO{" +
                "customerId=" + customerId +
                ", customerCode='" + customerCode + '\'' +
                ", customerName='" + customerName + '\'' +
                ", recordStatus=" + recordStatus +
                '}';
    }
}
