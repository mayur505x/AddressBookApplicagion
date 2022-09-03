package com.bridgelabz.addressbookapplication.repository;

import com.bridgelabz.addressbookapplication.entity.AddressBookData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressBookRepository extends JpaRepository<AddressBookData, Integer> {

}

