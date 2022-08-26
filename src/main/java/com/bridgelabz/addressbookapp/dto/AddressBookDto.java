package com.bridgelabz.addressbookapp.dto;

public class AddressBookDto {
    public String firstName;
    public String lastName;
    public String gender;
    public String address;
    public String city;
    public String state;
    public String zipCode;
    public Long phoneNumber;
    public String emailId;

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
