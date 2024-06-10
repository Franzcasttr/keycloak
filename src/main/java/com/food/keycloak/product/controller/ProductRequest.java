package com.food.keycloak.product.controller;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

public record ProductRequest(UUID id,
                             @NotNull()
                             @NotEmpty(message = "The above field must not be blank.")
                             String name,
                             MultipartFile image,
                             @NotNull()
                             @NotEmpty()
                             String tag,

                             @NotNull(message = "Price is required")
                             Integer price,
                             String desc,

                             @NotNull(message = "inventory is required")
                             Integer inventory,
                             String category,
                             String brand,

                             Integer shippingFee,
                             boolean freeShipping,
                             boolean exclusive,
                             boolean bestOffer) {



}
