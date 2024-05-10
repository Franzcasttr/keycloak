package com.food.keycloak.product;

import com.food.keycloak.product.controller.ProductResponse;
import com.food.keycloak.product.dto.ProductDto;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class ProductMappers {
    public static ProductDto mapToProductDTO(String name, MultipartFile image, String tag, Integer price, String desc, Integer inventory, String category, String brand, boolean freeShipping) {
        ProductDto productDTO = new ProductDto();
        productDTO.setName(name);
        productDTO.setImage(image);
        productDTO.setTag(tag);
        productDTO.setPrice(price);
        productDTO.setDesc(desc);
        productDTO.setInventory(inventory);
        productDTO.setCategory(category);
        productDTO.setBrand(brand);
        productDTO.setFreeShipping(freeShipping);
        return productDTO;
    }

    public static ProductDto mapToProductDTO(String name, MultipartFile image, String tag, Integer price, String desc, Integer inventory, String category, String brand, boolean freeShipping, boolean exclusive, boolean bestOffer,String image_public_id) {
        ProductDto productDTO = new ProductDto();
        productDTO.setName(name);
        productDTO.setImage(image);
        productDTO.setTag(tag);
        productDTO.setPrice(price);
        productDTO.setDesc(desc);
        productDTO.setInventory(inventory);
        productDTO.setCategory(category);
        productDTO.setBrand(brand);
        productDTO.setFreeShipping(freeShipping);
        productDTO.setExclusive(exclusive);
        productDTO.setBestOffer(bestOffer);
        productDTO.setImage_public_id(image_public_id);
        return productDTO;
    }




    public ProductEntity toCreate(ProductDto request, String imageUrl, String image_public_id){
        return ProductEntity.builder()
                .name(request.getName())
                .image(imageUrl)
                .tag(request.getTag())
                .price(request.getPrice())
                .desc(request.getDesc())
                .inventory(request.getInventory())
                .category(request.getCategory())
                .brand(request.getBrand())
                .shippingFee(request.getShippingFee())
                .freeShipping(request.isFreeShipping())
                .exclusive(request.isExclusive())
                .bestOffer(request.isBestOffer())
                .image_public_id(image_public_id)
                .build();
    }


    public ProductResponse toProductResponse(ProductEntity product){
        return ProductResponse.builder()
                .id(product.getId())
                .name(product.getName())
                .image(product.getImage())
                .image_public_id(product.getImage_public_id())
                .tag(product.getTag())
                .price(product.getPrice())
                .desc(product.getDesc())
                .inventory(product.getInventory())
                .category(product.getCategory())
                .brand(product.getBrand())
                .shippingFee(product.getShippingFee())
                .freeShipping(product.isFreeShipping())
                .exclusive(product.isExclusive())
                .bestOffer(product.isBestOffer())
                .averageRating(product.getAverageRating())
                .numberOfReviews(product.getNumberOfReviews())
                .createdAt(product.getCreatedAt())
                .updatedAt(product.getUpdatedAt())
                .build();
    }

}
