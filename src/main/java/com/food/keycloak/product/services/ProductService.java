package com.food.keycloak.product.services;

import com.food.keycloak.common.PageResponse;
import com.food.keycloak.product.controller.ProductResponse;
import com.food.keycloak.product.dto.ProductDto;


public interface ProductService {
    String createProduct(ProductDto productDto);
    PageResponse<ProductResponse> findAllProducts(int page,
                                                  int size,
                                                  String sortDirection,
                                                  String search,
                                                  String category);
    ProductResponse findSingleProduct(String id);
    ProductResponse updateProduct(String id, ProductDto productDto);
    String delete(String id);
}
