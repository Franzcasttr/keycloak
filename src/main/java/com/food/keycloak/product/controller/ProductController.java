package com.food.keycloak.product.controller;

import com.food.keycloak.common.PageResponse;
import com.food.keycloak.exception.ApiRequestException;
import com.food.keycloak.product.ProductMappers;
import com.food.keycloak.product.dto.ProductDto;
import com.food.keycloak.product.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;
    private final ProductMappers mapper;

    @PostMapping(value = "/createProduct", consumes = {"*/*"})
    @PreAuthorize("hasRole('client_admin')")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<String> createProduct(
            @RequestParam("name") String name,
            @RequestParam(value = "image", required = true) MultipartFile image,
            @RequestParam("tag") String tag,
            @RequestParam("price") Integer price,
            @RequestParam("desc") String desc,
            @RequestParam("inventory") Integer inventory,
            @RequestParam("category") String category,
            @RequestParam("brand") String brand,
            @RequestParam("freeShipping") boolean freeShipping
            ){
        ProductDto productDto = ProductMappers.mapToProductDTO(name,image,tag,price,desc,inventory,category,brand,freeShipping);
        return new ResponseEntity<String>(productService.createProduct(productDto), HttpStatus.CREATED);
    }


    @GetMapping("/getAllProduct")
    public ResponseEntity<PageResponse<ProductResponse>> findAllProducts(@RequestParam(defaultValue = "0", required = false) int page,
                                                                         @RequestParam(defaultValue = "10", required = false) int size){
        return ResponseEntity.ok(productService.findAllProducts(page, size));
    }

    @DeleteMapping("{id}")
    @PreAuthorize("hasRole('client_admin')")
    public ResponseEntity<String> deleteProduct(@PathVariable("id") String id){
        String response = productService.delete(id);
        if (response == null){
            throw new ApiRequestException("Something went wrong");
        }
        return ResponseEntity.ok(response);
    }
}
