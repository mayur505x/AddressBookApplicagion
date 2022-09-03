package com.bridgelabz.addressbookapplication.service;

import com.bridgelabz.addressbookapplication.dto.AddressBookDTO;
import com.bridgelabz.addressbookapplication.entity.AddressBookData;

import java.util.List;

public interface AddressBookService {
    List<AddressBookData> getAddressBookData();
    AddressBookData getAddressBookDataById(int personId);
    AddressBookData createAddressBookData(AddressBookDTO addressBookDTO);
    AddressBookData updateAddressBookData(int personId, AddressBookDTO addressBookDTO);
    void deleteAddressBookData(int personId);
}
