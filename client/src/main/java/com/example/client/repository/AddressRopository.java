package com.example.client.repository;

import com.example.client.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRopository extends JpaRepository<Address, String> {

    Address save(Address address);

}
