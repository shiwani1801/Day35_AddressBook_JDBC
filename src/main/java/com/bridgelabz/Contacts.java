package com.bridgelabz;

import java.time.LocalDate;

public class Contacts {
    private String firstName;
    private String lastName;
    private String address;
    private String city;
    private String state;
    private int zip;
    private String phoneNo;
    private String emailId;
    private String Type;
    private String Name;
    private LocalDate date;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getZip() {
        return zip;
    }

    public void setZip(int zip) {
        this.zip = zip;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getType() {
        return Type;
    }

    public void setType(String contactType) {
        this.Type = Type;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
       this.Name = Name;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
    @Override
    public String toString() {
        return "Contacts{" +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", zip=" + zip +
                ", phoneNumber=" + phoneNo +
                ", emailId='" + emailId + '\'' +
                ", Type='" + Type + '\'' +
                ", Name='" + Name + '\'' +
                '}';
    }


}