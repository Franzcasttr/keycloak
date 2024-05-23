package com.food.keycloak.address.services.Imp;

import com.food.keycloak.address.AddressEntity;
import com.food.keycloak.address.AddressRepository;
import com.food.keycloak.address.dto.AddressDto;
import com.food.keycloak.address.services.AddressService;
import com.food.keycloak.exception.ApiRequestException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AddressImpl implements AddressService {

    private final AddressRepository addressRepository;

    @Override
    public String createAddress(String userID, AddressDto addressDto) {
      try{
          AddressEntity address = new AddressEntity();
          address.setUser_id(userID);
          address.setName(addressDto.getName());
          address.setMobilenumber(addressDto.getMobilenumber());
          address.setStreet(addressDto.getStreet());
          address.setProvince(addressDto.getProvince());
          address.setCity(addressDto.getCity());
          address.setBarangay(addressDto.getBarangay());
          address.setPostalcode(addressDto.getPostalcode());
          address.setAddresstype(addressDto.getAddresstype());
          addressRepository.save(address);
          return "success";
      }catch (Exception e){
          e.printStackTrace();
          throw  new ApiRequestException(e.getMessage());
      }

    }
}
