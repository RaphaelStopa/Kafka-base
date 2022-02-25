package com.example.client.service;

import com.example.client.model.Address;
import com.example.client.repository.AddressRopository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressService {

    @Autowired
    private AddressRopository addressRepository;

    public Address save(Address address){
        addressRepository.save(address);
        return address;
    }

    public List<Address> getListAddress(){
        return addressRepository.findAll();
    }

}
