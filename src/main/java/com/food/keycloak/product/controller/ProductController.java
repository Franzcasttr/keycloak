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
                                                                         @RequestParam(defaultValue = "10", required = false) int size,
                                                                         @RequestParam(name = "sort", required = false, defaultValue = "price-lowest") String sort,
                                                                         @RequestParam(name = "search", required = false) String search,
                                                                         @RequestParam(name = "category", required = false) String category){
        return ResponseEntity.ok(productService.findAllProducts(page, size, sort, search, category));
    }

    @GetMapping("{id}")
    public ResponseEntity<ProductResponse> findSingleProduct(@PathVariable("id") String id){
        ProductResponse response = productService.findSingleProduct(id);
        return ResponseEntity.ok(response);
    }

    @PutMapping(value = "/update/{id}", consumes = {"*/*"})
    @PreAuthorize("hasRole('client_admin')")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<ProductResponse> updateProduct(
            @PathVariable("id") String id,
            @RequestParam(value = "name", required = false) String name,
            @RequestParam(value = "image", required = false) MultipartFile image,
            @RequestParam(value = "tag", required = false) String tag,
            @RequestParam(value = "price" , required = false) Integer price,
            @RequestParam(value = "desc" , required = false) String desc,
            @RequestParam(value = "inventory" , required = false) Integer inventory,
            @RequestParam(value = "category" , required = false) String category,
            @RequestParam(value = "brand" , required = false) String brand,
            @RequestParam(value = "freeShipping" , required = false) boolean freeShipping,
            @RequestParam(value = "exclusive" , required = false) boolean exclusive,
            @RequestParam(value = "bestOffer" , required = false) boolean bestOffer
    ){
        ProductDto productDto = ProductMappers.mapToProductDTO(name,image,tag,price,desc,inventory,category,brand,freeShipping, exclusive, bestOffer);
        return new ResponseEntity<ProductResponse>(productService.updateProduct(id, productDto), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    @PreAuthorize("hasRole('client_admin')")
    public ResponseEntity<String> deleteProduct(@PathVariable("id") String id){
        String response = productService.delete(id);
        return ResponseEntity.ok(response);
    }
}
