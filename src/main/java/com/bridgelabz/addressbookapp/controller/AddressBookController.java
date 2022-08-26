package com.bridgelabz.addressbookapp.controller;

import com.bridgelabz.addressbookapp.dto.AddressBookDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/addressbookservice")
public class AddressBookController {

    @RequestMapping(value = {"", "/", "/get"})
    public ResponseEntity<String> getAddressBookDetails() {
        return new ResponseEntity<>("Get Call success", HttpStatus.OK);
    }
    @GetMapping("/get/{personId}")
    public ResponseEntity<String> getAddressBookDetailsById(@RequestParam int personId) {
        return new ResponseEntity<>("Get Call success for ID", HttpStatus.OK);
    }
    @PostMapping("/create")
    public ResponseEntity<String> createAddressBookDetails(@RequestBody AddressBookDto addressBookDto) {
        return new ResponseEntity<>("Created Address Book data successfully ! \n" + addressBookDto, HttpStatus.OK);
    }
    @PutMapping("/update")
    public ResponseEntity<String> updateAddressBookDetails(@RequestParam int personId, @RequestBody AddressBookDto addressBookDto) {
        return new ResponseEntity<>("Updates Address Book data successfully ! \n" + addressBookDto, HttpStatus.OK);
    }
    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteAddressBookDetails() {
        return new ResponseEntity<>("Deleted Address Book Data Succesfully !", HttpStatus.OK);
    }
}
