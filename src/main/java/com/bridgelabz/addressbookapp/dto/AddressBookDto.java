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
    @Pattern(regexp = "male|female", message = "Gender needs to be male or female !")
    public String gender;
    @NotBlank(message = "Address cannot be empty")
    public String address;
    @NotBlank(message = "City cannot be empty")
    public String city;
    @NotBlank(message = "State cannot be empty")
    public String state;
    @Pattern(regexp = "^[1-9]{1}[0-9]{2}\\s{0,1}[0-9]{3}$", message = "Zip Code is Invalid !")
    public int zipCode;
    @Pattern(regexp = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$", message = "Email ID is Invalid !")
    public String emailId;
    @Pattern(regexp = "^[7-9]{1}[0-9]{9}", message = "Mobile Number is Invalid !")
    public Long phoneNumber;

}
