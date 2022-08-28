package com.bridgelabz.addressbookapp.dto;

import lombok.AllArgsConstructor;
import lombok.ToString;

import javax.validation.constraints.*;


@ToString
@AllArgsConstructor
public class AddressBookDto {
    @Pattern(regexp = "^[A-Z]{1}[a-zA-Z\\s]{2,}$", message = "First Name is Invalid !")
    public String firstName;
    @Pattern(regexp = "^[A-Z]{1}[a-zA-Z\\s]{2,}$", message = "Last Name is Invalid !")
    public String lastName;
    public String gender;
    public String address;
    public String city;
    public String state;
    public int zipCode;
    public String emailId;
    public Long phoneNumber;

}
