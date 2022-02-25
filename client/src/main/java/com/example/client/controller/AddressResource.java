package com.example.client.controller;

import com.example.client.model.Address;
import com.example.client.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/address")
public class AddressResource {

    @Autowired
    private AddressService addressService;

    @PostMapping
    public ResponseEntity<Address> saveEndereco(@RequestBody Address address){
        addressService.save(address);
        return ResponseEntity.ok(address);
    }

    @GetMapping
    public ResponseEntity<List<Address>> getListaEndereco(){
        List<Address> listaEndereco = addressService.getListAddress();
        return ResponseEntity.ok(listaEndereco);
    }
}
