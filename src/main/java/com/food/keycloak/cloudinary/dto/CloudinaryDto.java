package com.food.keycloak.cloudinary.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CloudinaryDto {
    private String secured_url;
    private String public_id;
}
