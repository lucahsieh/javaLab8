package com.model;

import java.io.Serializable;

public class Supplier implements Serializable{
    private static final long serialVersionUID = 1L;
    private int supplierID;
    private String supplierName;
    private String contactName;
    private String contactTitle;
    private String address;
    private String city;
    private String postalCode;
    private String country;
    private String phoneNumber;
    private String faxNumber;
    private String paymentTerms;
    private String emailAddress;
    private String notes;
    
    public Supplier(int supplierID, String supplierName, String contactName, String contactTitle, String address,
            String city, String postalCode, String country, String phoneNumber, String faxNumber, String paymentTerms,
            String emailAddress, String notes) {
        super();
        this.supplierID = supplierID;
        this.supplierName = supplierName;
        this.contactName = contactName;
        this.contactTitle = contactTitle;
        this.address = address;
        this.city = city;
        this.postalCode = postalCode;
        this.country = country;
        this.phoneNumber = phoneNumber;
        this.faxNumber = faxNumber;
        this.paymentTerms = paymentTerms;
        this.emailAddress = emailAddress;
        this.notes = notes;
    }

    public int getSupplierID() {
        return supplierID;
    }

    public void setSupplierID(int supplierID) {
        this.supplierID = supplierID;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getContactTitle() {
        return contactTitle;
    }

    public void setContactTitle(String contactTitle) {
        this.contactTitle = contactTitle;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getFaxNumber() {
        return faxNumber;
    }

    public void setFaxNumber(String faxNumber) {
        this.faxNumber = faxNumber;
    }

    public String getPaymentTerms() {
        return paymentTerms;
    }

    public void setPaymentTerms(String paymentTerms) {
        this.paymentTerms = paymentTerms;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }
    
    
    
}
