package com.bridgelabz.addressbookapp.entity;

import com.bridgelabz.addressbookapp.dto.AddressBookDto;

public class Person {
    private int personId;
    private String firstName;
    private String lastName;
    private String gender;
    private String address;
    private String city;
    private String state;
    private int zipCode;
    private Long phoneNumber;
    private String emailId;

    public Person(int personId, AddressBookDto addressBookDto) {
        this.personId = personId;
        this.firstName = addressBookDto.firstName;
        this.lastName = addressBookDto.lastName;
        this.gender = addressBookDto.gender;
        this.address = addressBookDto.address;
        this.city = addressBookDto.city;
        this.state = addressBookDto.state;
        this.zipCode = addressBookDto.zipCode;
        this.phoneNumber = addressBookDto.phoneNumber;
        this.emailId = addressBookDto.emailId;
    }

    public int getPersonId() {
        return personId;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
    }

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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
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

    public int getZipCode() {
        return zipCode;
    }

    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }

    public Long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }
}
