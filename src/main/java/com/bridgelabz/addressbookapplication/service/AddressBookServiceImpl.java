package com.bridgelabz.addressbookapplication.service;

import com.bridgelabz.addressbookapplication.dto.AddressBookDTO;
import com.bridgelabz.addressbookapplication.dto.ResponseDTO;
import com.bridgelabz.addressbookapplication.entity.AddressBookData;
import com.bridgelabz.addressbookapplication.exception.AddressBookException;
import com.bridgelabz.addressbookapplication.repository.AddressBookRepository;
import com.bridgelabz.addressbookapplication.util.JwtUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
@Slf4j
public class AddressBookServiceImpl implements AddressBookService{

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    private MailService mailService;
    @Autowired
    private JwtUtil jwtUtil;
    @Autowired
    private AddressBookRepository addressBookRepository;
    private List<AddressBookData> list = new ArrayList<>();
    public List<AddressBookData> getAddressBookData(String token) {
        Long userId = jwtUtil.decodeToken(token);
        Optional<AddressBookData> isUserPresent = addressBookRepository.findById(userId);
        if (isUserPresent.isPresent()) {
            return addressBookRepository.findAll();
        }
        throw new AddressBookException("User not present");

    }

    public AddressBookData getAddressBookDataById(long personId){
        return addressBookRepository.findById(personId)
                .orElseThrow(() -> new AddressBookException("User Not Found"));
    }

    public List<AddressBookData> getPersonByFirstName(String firstName) {
        return addressBookRepository.findByFirstName(firstName);
    }

    public List<AddressBookData> getPersonByLastName(String lastName) {
        return addressBookRepository.findByLastName(lastName);
    }

    public List<AddressBookData> getPersonByGender(String gender) {
        return addressBookRepository.findByGender(gender);
    }

    public List<AddressBookData> getPersonByAddress(String address) {
        return addressBookRepository.findByAddress(address);
    }

    public List<AddressBookData> getPersonByCity(String city) {
        return addressBookRepository.findByCity(city);
    }

    public List<AddressBookData> getPersonByState(String state) {
        return addressBookRepository.findByState(state);
    }

    public List<AddressBookData> getPersonByZipCode(String zipCode) {
        return addressBookRepository.findByZipCode(zipCode);
    }

    public List<AddressBookData> getPersonByPhoneNumber(String phoneNumber) {
        return addressBookRepository.findByPhoneNumber(phoneNumber);
    }

    public Optional<AddressBookData> getPersonByEmailId(String emailId) {
        return addressBookRepository.findByEmailId(emailId);
    }
    public AddressBookData createAddressBookData(AddressBookDTO addressBookDTO){
        AddressBookData addressBookData = null;
        String encodedPassword = bCryptPasswordEncoder.encode(addressBookDTO.getPassword());
        addressBookDTO.setPassword(encodedPassword);
        addressBookData = new AddressBookData(addressBookDTO);
        log.debug("User Data: " +addressBookData.toString());
        String body = "Contact added successfully with Id is " + addressBookData.getPersonId();
        String subject = "Contact registration successfull";
        mailService.send(addressBookData.getEmailId(),body,subject);
        return addressBookRepository.save(addressBookData);
    }

    public AddressBookData updateAddressBookData(int personId ,AddressBookDTO addressBookDTO){
        AddressBookData addressBookData = this.getAddressBookDataById(personId);
        addressBookData.updateAddressBookData(addressBookDTO);
        return addressBookRepository.save(addressBookData);
    }

    public void deleteAddressBookData(int personId){
        AddressBookData addressBookData = this.getAddressBookDataById(personId);
        addressBookRepository.delete(addressBookData);
    }

    @Override
    public ResponseDTO login(String emailId, String password) {
        Optional<AddressBookData> isEmailPresent = addressBookRepository.findByEmailId(emailId);
        if (isEmailPresent.isPresent()) {
            if (bCryptPasswordEncoder.matches(password, isEmailPresent.get().getPassword())) {
                String token = jwtUtil.createToken(isEmailPresent.get().getPersonId());
                return new ResponseDTO("User has logged In", 200, token);
            } else {
                throw new AddressBookException("Password wrong");
            }
        }
        throw new AddressBookException("No Contact Found");
    }
}
