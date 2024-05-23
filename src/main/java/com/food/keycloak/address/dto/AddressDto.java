package com.food.keycloak.address.dto;

import com.food.keycloak.address.utils.AddressType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddressDto {
    private String name;
    private String mobilenumber;
    private String street;
    private String province;
    private String city;
    private String barangay;
    private Integer postalcode;
    private AddressType addresstype;
}
