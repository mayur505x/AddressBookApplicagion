package com.bridgelabz.addressbookapplication.entity;

import com.bridgelabz.addressbookapplication.dto.AddressBookDTO;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "user_address_book")
public @Data class AddressBookData {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "personId")
    private int personId;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "gender")
    private String gender;
    @Column(name = "address")
    private String address;
    @Column(name = "city")
    private String city;
    @Column(name = "state")
    private String state;
    @Column(name = "zip_code")
    private String zipCode;
    @Column(name = "phone_number")
    private String phoneNumber;

    @ElementCollection
    @CollectionTable(name = "person_emailId", joinColumns = @JoinColumn(name = "id"))
    @Column(name = "emailId")
    private List<String> emailId = new ArrayList<>();

    public AddressBookData(){

    }

    public AddressBookData(AddressBookDTO addressBookDTO){
        this.updateAddressBookData(addressBookDTO);
    }
    public void updateAddressBookData(AddressBookDTO addressBookDTO){
        this.firstName = addressBookDTO.firstName;
        this.lastName = addressBookDTO.lastName;
        this.gender = addressBookDTO.gender;
        this.address = addressBookDTO.address;
        this.city = addressBookDTO.city;
        this.state = addressBookDTO.state;
        this.zipCode = addressBookDTO.zipCode;
        this.phoneNumber = addressBookDTO.phoneNumber;
        this.emailId = addressBookDTO.emailId;
    }
}

