package com.bridgelabz.addressbookapplication.controller;

import com.bridgelabz.addressbookapplication.dto.AddressBookDTO;
import com.bridgelabz.addressbookapplication.dto.ResponseDTO;
import com.bridgelabz.addressbookapplication.entity.AddressBookData;
import com.bridgelabz.addressbookapplication.service.AddressBookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/addressbookservice")
@Slf4j
public class AddressBookController {

    @Autowired
    private AddressBookService addressBookService;

    @RequestMapping(value = {"","/","/get"})
    public ResponseEntity<ResponseDTO> getAddressBookData(@RequestHeader String token){
        List<AddressBookData> addressBookDataList = null;
        addressBookDataList = addressBookService.getAddressBookData(token);
        ResponseDTO responseDTO = new ResponseDTO("Get Call Success", 200,addressBookDataList);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }
    @GetMapping("/get/{personId}")
    public ResponseEntity<ResponseDTO> getAddressBookData(@RequestHeader String token, @PathVariable("personId")long personId){
        AddressBookData addressBookData = null;
        addressBookData = addressBookService.getAddressBookDataById(personId);
        ResponseDTO responseDTO = new ResponseDTO("Get Call For Id Successful!!", 200,addressBookData);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);    }

    @RequestMapping("/firstName")
    public ResponseEntity<ResponseDTO> getPersonByFirstName(@RequestHeader String token, @RequestParam String firstName) {
        List<AddressBookData> addressBookDataList = null;
        addressBookDataList = addressBookService.getPersonByFirstName(firstName);
        ResponseDTO responseDTO = new ResponseDTO("Request Call For First Name Successfully", 200,addressBookDataList);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    @RequestMapping("/lastName")
    public ResponseEntity<ResponseDTO> getPersonByLastName(@RequestHeader String token,@RequestParam String lastName) {
        List<AddressBookData> addressBookDataList = null;
        addressBookDataList = addressBookService.getPersonByLastName(lastName);
        ResponseDTO responseDTO = new ResponseDTO("Request Call For Last Name Successfully", 200,addressBookDataList);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    @RequestMapping("/gender")
    public ResponseEntity<ResponseDTO> getPersonByGender(@RequestHeader String token, @RequestParam String gender) {
        List<AddressBookData> addressBookDataList = null;
        addressBookDataList = addressBookService.getPersonByGender(gender);
        ResponseDTO responseDTO = new ResponseDTO("Request Call For Gender Successfully", 200,addressBookDataList);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }
    @RequestMapping("/address")
    public ResponseEntity<ResponseDTO> getPersonByAddress(@RequestHeader String token,@RequestParam String address) {
        List<AddressBookData> addressBookDataList = null;
        addressBookDataList = addressBookService.getPersonByAddress(address);
        ResponseDTO responseDTO = new ResponseDTO("Request Call For Address Successfully",200, addressBookDataList);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }
    @RequestMapping("/city")
    public ResponseEntity<ResponseDTO> getPersonByCity(@RequestHeader String token,@RequestParam String city) {
        List<AddressBookData> addressBookDataList = null;
        addressBookDataList = addressBookService.getPersonByCity(city);
        ResponseDTO responseDTO = new ResponseDTO("Request Call For City Successfully", 200,addressBookDataList);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    @RequestMapping("/state")
    public ResponseEntity<ResponseDTO> getPersonByState(@RequestHeader String token,@RequestParam String state) {
        List<AddressBookData> addressBookDataList = null;
        addressBookDataList = addressBookService.getPersonByState(state);
        ResponseDTO responseDTO = new ResponseDTO("Request Call For State Successfully", 200,addressBookDataList);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    @RequestMapping("/zipCode")
    public ResponseEntity<ResponseDTO> getPersonByZipCode(@RequestParam String zipCode) {
        List<AddressBookData> addressBookDataList = null;
        addressBookDataList = addressBookService.getPersonByZipCode(zipCode);
        ResponseDTO responseDTO = new ResponseDTO("Request Call For ZipCode Successfully", 200,addressBookDataList);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    @RequestMapping("/phoneNumber")
    public ResponseEntity<ResponseDTO> getPersonByPhoneNumber(@RequestParam String phoneNumber) {
        List<AddressBookData> addressBookDataList = null;
        addressBookDataList = addressBookService.getPersonByPhoneNumber(phoneNumber);
        ResponseDTO responseDTO = new ResponseDTO("Request Call For Phone Number Successfully", 200,addressBookDataList);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    @RequestMapping("/emailId")
    public ResponseEntity<ResponseDTO> getPersonByEmailId(@RequestParam String emailId) {
        Optional<AddressBookData> addressBookDataList = null;
        addressBookDataList = addressBookService.getPersonByEmailId(emailId);
        ResponseDTO responseDTO = new ResponseDTO("Request Call For EmailId Successfully", 200,addressBookDataList);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }
    @PostMapping("/create")
    public ResponseEntity<ResponseDTO> addAddressBookData(@Valid @RequestBody AddressBookDTO addressBookDTO){
        log.debug("User Dto: " +addressBookDTO.toString());
        AddressBookData addressBookData = null;
        addressBookData = addressBookService.createAddressBookData(addressBookDTO);
        ResponseDTO responseDTO = new ResponseDTO("Created Address Book Data Successfully: ", 200,addressBookData);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);    }

    @PutMapping("/update/{personId}")
    public ResponseEntity<ResponseDTO> updateAddressBookData(@PathVariable("personId") int personId, @Valid @RequestBody AddressBookDTO addressBookDTO){
        AddressBookData addressBookData = null;
        addressBookData = addressBookService.updateAddressBookData(personId, addressBookDTO);
        ResponseDTO responseDTO = new ResponseDTO("Updated Address Book Data Successfully:", 200,addressBookData);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);    }

    @DeleteMapping("/delete/{personId}")
    public ResponseEntity<ResponseDTO> deleteAddressBookData(@PathVariable("personId")int personId){
        addressBookService.deleteAddressBookData(personId);
        ResponseDTO responseDTO = new ResponseDTO("Address Book Data Deleted Successfully: ",200, "Delete Id:" +personId);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseDTO loginAddressBook(@RequestParam String emailId, @RequestParam String password){
        return addressBookService.login(emailId,password);
    }
}

