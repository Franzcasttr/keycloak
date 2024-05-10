package com.food.keycloak.product;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;
import java.util.UUID;

@Entity
@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Products")
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String name;

    private  String image;

    private String image_public_id;

    private String tag;

    private Integer price;

    @Column(name = "description")
    private String desc;

    private Integer inventory;

    private String category;

    private String brand;

    @Column(name = "free_shipping")
    @Builder.Default
    private boolean freeShipping = false;

    @Builder.Default
    private boolean exclusive = false;

    @Builder.Default
    @Column(name = "best_offer")
    private boolean bestOffer = false;

    @Column(name = "shipping_fee")
    @Builder.Default
    private Integer shippingFee = 50;

    @Column(name = "average_rating")
    @Builder.Default
    private Double averageRating = 0.0;

    @Column(name = "number_of_reviews")
    @Builder.Default
    private Integer numberOfReviews = 0;

    @Column(updatable = false)
    @CreationTimestamp
    private Date createdAt;

    @UpdateTimestamp
    private Date updatedAt;

}
