package com.bridgelabz.addressbookapp.entity;

import com.bridgelabz.addressbookapp.dto.AddressBookDto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
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
}
