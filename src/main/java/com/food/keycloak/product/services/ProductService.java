package com.food.keycloak.product.services;

import com.food.keycloak.common.PageResponse;
import com.food.keycloak.product.controller.ProductRequest;
import com.food.keycloak.product.controller.ProductResponse;
import com.food.keycloak.product.dto.ProductDto;
import org.springframework.security.core.Authentication;
import org.springframework.web.multipart.MultipartFile;


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
