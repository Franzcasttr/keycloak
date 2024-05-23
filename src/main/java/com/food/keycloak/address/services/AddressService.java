package com.food.keycloak.address.services;

import com.food.keycloak.address.dto.AddressDto;
import org.springframework.security.core.Authentication;

public interface AddressService {
    String createAddress(String userID, AddressDto addressDto);

}
