package com.bridgelabz.addressbookapp.service;

import com.bridgelabz.addressbookapp.dto.AddressBookDto;
import com.bridgelabz.addressbookapp.entity.Person;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AddressBookServiceImpl implements AddressBookService{

    private List<Person> personList = new ArrayList<>();

    @Override
    public List<Person> getAddressBookDetails() {
        return personList;
    }

    @Override
    public Person getAddressDetailsById(int personId) {
        for (Person person : personList) {
            if (person.getPersonId() == personId) {
                return person;
            }
        }
        return null;
    }

    @Override
    public Person createAdddressBookDetails(AddressBookDto addressBookDto) {
        Person person = null;
        person = new Person(personList.size() + 1, addressBookDto);
        personList.add(person);
        return person;
    }

    @Override
    public Person updateAddressBookDetails(int personId, AddressBookDto addressBookDto) {
        Person personDetails = this.getAddressDetailsById(personId);
        personDetails.setFirstName(addressBookDto.firstName);
        personDetails.setLastName(addressBookDto.lastName);
        personDetails.setGender(addressBookDto.gender);
        personDetails.setAddress(addressBookDto.address);
        personDetails.setCity(addressBookDto.city);
        personDetails.setState(addressBookDto.state);
        personDetails.setZipCode(addressBookDto.zipCode);
        personDetails.setEmailId(addressBookDto.emailId);
        personDetails.setPhoneNumber(addressBookDto.phoneNumber);
        return personDetails;
    }

    @Override
    public void deleteAddressDetails(int personId) {
        Person personDetails = this.getAddressDetailsById(personId);
        personList.remove(personDetails);
    }
}
