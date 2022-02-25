package com.example.client.repository;

import com.example.client.model.Address;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRopository extends MongoRepository<Address, String> {

    public Address save(Address address);

}
