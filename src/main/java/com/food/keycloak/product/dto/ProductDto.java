package com.food.keycloak.product.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto {

//    private UUID id;
    private String name;
    private MultipartFile image;
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
//    private Date createdAt;
//    private Date updatedAt;
}
