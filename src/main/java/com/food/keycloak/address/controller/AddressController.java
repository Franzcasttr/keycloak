package com.food.keycloak.address.controller;

import com.food.keycloak.address.dto.AddressDto;
import com.food.keycloak.address.services.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/address")
@RequiredArgsConstructor
public class AddressController {
    private final AddressService addressService;
    @PostMapping("/create-Address")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<String> createAddress(Authentication authentication, @RequestBody AddressDto addressDto){
//     return new ResponseEntity<String>("Hello",HttpStatus.CREATED);
     return new ResponseEntity<String>(
             addressService.createAddress(authentication.getName(),
                     addressDto),
             HttpStatus.CREATED);
    }
}
