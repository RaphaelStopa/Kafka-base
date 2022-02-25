package com.example.client.listener;

import com.example.client.model.Address;
import com.example.client.service.AddressService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Log4j2
@Service
public class AddressClient {

    @Autowired
    private AddressService addressService;

    @KafkaListener(topics = "${topic.address-client}", groupId = "${spring.kafka.consumer.group-id}")
    public void getAddressClient(String addressString) throws JsonProcessingException {


        log.info("Message AddressRopository {}", addressString);

        ObjectMapper objectMapper = new ObjectMapper();
        Address address = objectMapper.readValue(addressString, Address.class);

        addressService.save(address);
        log.info("AddressRopository saved in base successfully: {}", address);

    }
}
