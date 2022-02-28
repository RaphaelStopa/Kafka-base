package com.example.Address.resource;

import com.example.Address.http.AddressJson;
import com.example.Address.response.AddressResponse;
import com.example.Address.service.AddressService;
import com.example.Address.service.ViaCepService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Log4j2
@RestController
@RequiredArgsConstructor
@RequestMapping("zipcode")
public class AddressResource {

    private final ViaCepService viaCepService;

    @Autowired
    private AddressService addressService;

    @GetMapping("/{cep}")
    public ResponseEntity<AddressResponse> getCep(@PathVariable("cep") String cep) {
        AddressResponse addressResponse = viaCepService.getCep(cep);
        return ResponseEntity.ok(addressResponse);
    }

    @PostMapping
    public ResponseEntity<AddressResponse> sendAddress(@RequestBody AddressJson addressJson) throws JsonProcessingException {

        log.info("## Dados envidos pelo cliente: {}", addressJson);

        AddressResponse addressResponse = viaCepService.getCep(addressJson.getCep());

        addressResponse.setComplemento(addressJson.getComplemento());
        addressResponse.setNumero(addressJson.getNumero());

        ObjectMapper objectMapper = new ObjectMapper();
        String mensagem = objectMapper.writeValueAsString(addressResponse);

        addressService.sendMessage(mensagem);
        log.info("## Address returned by the CEP API: {}", addressResponse);

        return ResponseEntity.ok(addressResponse);
    }
}
