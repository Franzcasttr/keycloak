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

    public static ProductDto mapToProductDTO(String name, MultipartFile image, String tag, Integer price, String desc, Integer inventory, String category, String brand, boolean freeShipping, boolean exclusive, boolean bestOffer) {
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

    public ProductEntity toUpdate(ProductEntity product, ProductDto request, String imageUrl, String image_public_id){
        if (request.getName() != null) {
            product.setName(request.getName());
        }
        if (imageUrl != null) {
            product.setImage(imageUrl);
        }
        if (request.getTag() != null) {
            product.setTag(request.getTag());
        }
        if (request.getPrice() != null) {
            product.setPrice(request.getPrice());
        }
        if (request.getDesc() != null) {
            product.setDesc(request.getDesc());
        }
        if (request.getInventory() != null) {
            product.setInventory(request.getInventory());
        }
        if (request.getCategory() != null) {
            product.setCategory(request.getCategory());
        }
        if (request.getBrand() != null) {
            product.setBrand(request.getBrand());
        }
        if (request.getShippingFee() != null) {
            product.setShippingFee(request.getShippingFee());
        }
        product.setFreeShipping(request.isFreeShipping());
        product.setExclusive(request.isExclusive());
        product.setBestOffer(request.isBestOffer());
        if (image_public_id != null) {
            product.setImage_public_id(image_public_id);
        }
        return product;

    }
    public ProductEntity toUpdate(ProductEntity product, ProductDto request){
        if (request.getName() != null) {
            product.setName(request.getName());
        }

        if (request.getTag() != null) {
            product.setTag(request.getTag());
        }
        if (request.getPrice() != null) {
            product.setPrice(request.getPrice());
        }
        if (request.getDesc() != null) {
            product.setDesc(request.getDesc());
        }
        if (request.getInventory() != null) {
            product.setInventory(request.getInventory());
        }
        if (request.getCategory() != null) {
            product.setCategory(request.getCategory());
        }
        if (request.getBrand() != null) {
            product.setBrand(request.getBrand());
        }
        if (request.getShippingFee() != null) {
            product.setShippingFee(request.getShippingFee());
        }
        product.setFreeShipping(request.isFreeShipping());
        product.setExclusive(request.isExclusive());
        product.setBestOffer(request.isBestOffer());

        return product;

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
