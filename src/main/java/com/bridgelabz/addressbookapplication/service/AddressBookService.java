package com.bridgelabz.addressbookapplication.service;

import com.bridgelabz.addressbookapplication.dto.AddressBookDTO;
import com.bridgelabz.addressbookapplication.dto.ResponseDTO;
import com.bridgelabz.addressbookapplication.entity.AddressBookData;

import java.util.List;
import java.util.Optional;

public interface AddressBookService {
    List<AddressBookData> getAddressBookData(String token);
    AddressBookData getAddressBookDataById(long personId);
    List<AddressBookData> getPersonByFirstName(String firstName);
    List<AddressBookData> getPersonByLastName(String lastName);
    List<AddressBookData> getPersonByGender(String gender);
    List<AddressBookData> getPersonByAddress(String address);
    List<AddressBookData> getPersonByCity(String city);
    List<AddressBookData> getPersonByState(String state);
    List<AddressBookData> getPersonByZipCode(String zipCode);
    List<AddressBookData> getPersonByPhoneNumber(String phoneNumber);
    Optional<AddressBookData> getPersonByEmailId(String emailId);
    AddressBookData createAddressBookData(AddressBookDTO addressBookDTO);
    AddressBookData updateAddressBookData(int personId, AddressBookDTO addressBookDTO);
    void deleteAddressBookData(int personId);

    ResponseDTO login(String emailId, String password);
}
