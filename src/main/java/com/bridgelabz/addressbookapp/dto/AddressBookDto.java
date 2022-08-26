package com.bridgelabz.addressbookapp.dto;

public class AddressBookDto {
    public String firstName;
    public String lastName;
    public String gender;
    public String address;
    public String city;
    public String state;
    public int zipCode;
    public String emailId;
    public Long phoneNumber;

    public AddressBookDto(String firstName, String lastName, String gender, String address, String city, String state, int zipCode, String emailId, Long phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
        this.emailId = emailId;
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "AddressBookDto{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", gender='" + gender + '\'' +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", zipCode='" + zipCode + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", emailId='" + emailId + '\'' +
                '}';
    }
}
