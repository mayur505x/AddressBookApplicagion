package com.bridgelabz.addressbookapp.controller;

import com.bridgelabz.addressbookapp.dto.AddressBookDto;
import com.bridgelabz.addressbookapp.dto.ResponseDto;
import com.bridgelabz.addressbookapp.entity.Person;
import com.bridgelabz.addressbookapp.service.AddressBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/addressbookservice")
public class AddressBookController {

    @Autowired
    private AddressBookService addressBookService;

    @RequestMapping(value = {"", "/", "/get"})
    public ResponseEntity<ResponseDto> getAddressBookDetails() {
        Person person = null;
        List<Person> personList = addressBookService.getAddressBookDetails();
        ResponseDto responseDto = new ResponseDto("Get Call Success", personList);
        return new ResponseEntity<ResponseDto>(responseDto, HttpStatus.OK);
    }

    @GetMapping("/get/{personId}")
    public ResponseEntity<ResponseDto> getAddressBookDetailsById(@PathVariable int personId) {
        Person person = null;
        person = addressBookService.getAddressDetailsById(personId);
        ResponseDto responseDto = new ResponseDto("Get call success for ID", person);
        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<ResponseDto> createAddressBookDetails(@Valid @RequestBody AddressBookDto addressBookDto) {
        Person person = null;
        person = addressBookService.createAdddressBookDetails(addressBookDto);
        ResponseDto responseDto = new ResponseDto("Post call success for Create", person);
        return new ResponseEntity<ResponseDto>(responseDto, HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ResponseDto> updateAddressBookDetails(@PathVariable("id") int personId,@Valid @RequestBody AddressBookDto addressBookDto) {
        Person person = null;
        person = addressBookService.updateAddressBookDetails(personId, addressBookDto);
        ResponseDto responseDto = new ResponseDto("Updates Address Book data successfully !", person);
        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteAddressBookDetails(@PathVariable("id") int personId) {
        addressBookService.deleteAddressDetails(personId);
        return new ResponseEntity<>("Deleted Address Book Data Succesfully !", HttpStatus.OK);
    }
}
