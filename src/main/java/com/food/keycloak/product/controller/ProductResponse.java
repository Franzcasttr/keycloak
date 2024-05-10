package com.food.keycloak.product.controller;



import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductResponse {

    private UUID id;
    private String name;
    private String image;
    private String image_public_id;
    private String tag;
    private Integer price;
    private String desc;
    private Integer inventory;
    private String category;
    private String brand;
    private Integer shippingFee;
    private boolean freeShipping;
    private boolean exclusive;
    private boolean bestOffer;
    private Double averageRating;
    private Integer numberOfReviews;
    private Date createdAt;
    private Date updatedAt;

}
