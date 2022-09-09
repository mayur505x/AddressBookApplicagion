package com.bridgelabz.addressbookapplication.repository;

import com.bridgelabz.addressbookapplication.entity.AddressBookData;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AddressBookRepository extends JpaRepository<AddressBookData, Long> {

    List<AddressBookData> findByFirstName(String firstName);
    List<AddressBookData> findByLastName(String lastName);
    List<AddressBookData> findByGender(String gender);
    List<AddressBookData> findByAddress(String address);
    List<AddressBookData> findByCity(String city);
    List<AddressBookData> findByState(String state);
    List<AddressBookData> findByZipCode(String zipCode);
    List<AddressBookData> findByPhoneNumber(String phoneNumber);
    Optional<AddressBookData> findByEmailId(String emailId);

}
