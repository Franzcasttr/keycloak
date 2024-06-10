package com.food.keycloak.product.services.Impl;

import com.food.keycloak.cloudinary.CloudinaryService;
import com.food.keycloak.cloudinary.dto.CloudinaryDto;
import com.food.keycloak.common.PageResponse;
import com.food.keycloak.exception.ApiRequestException;
import com.food.keycloak.product.ProductEntity;
import com.food.keycloak.product.ProductMappers;
import com.food.keycloak.product.ProductRepository;
import com.food.keycloak.product.controller.ProductResponse;
import com.food.keycloak.product.dto.ProductDto;
import com.food.keycloak.product.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProductImp implements ProductService {

    private final ProductMappers productMapper;
    private final ProductRepository productRepository;
    private final CloudinaryService cloudinaryService;

    @Override
    public String createProduct(ProductDto productDto) {
        try{
            CloudinaryDto fileUploader = cloudinaryService.uploadFile(productDto.getImage(), "Product Images");
            ProductEntity product = productMapper.toCreate(productDto, fileUploader.getSecured_url(), fileUploader.getPublic_id());
            productRepository.save(product);
            return "Success";
        }catch (Exception e){
            e.printStackTrace();
            throw new ApiRequestException(e.getMessage());
        }



    }

    @Override
    public PageResponse<ProductResponse> findAllProducts(int page, int size, String sortDirection, String searchItem, String category) {
        Sort primarySort = sortDirection.equalsIgnoreCase("price-highest")
                ? Sort.by(Sort.Direction.DESC, "price")
                : Sort.by(Sort.Direction.ASC, "price");
        Sort sort = primarySort.and(Sort.by("createdAt").descending());
        Pageable pageable = PageRequest.of(page, size, sort);

        Page<ProductEntity> product;
        if (searchItem != null && !searchItem.isEmpty()){
            product = productRepository.findByNameContainingIgnoreCaseAndCategory(searchItem, category, pageable);
        }else{


        product = productRepository.findAll(pageable);
        }
        List<ProductResponse> productResponse = product.stream().map(productMapper::toProductResponse).toList();
        return new PageResponse<>(
                productResponse,
                product.getNumber(),
                product.getSize(),
                product.getTotalElements(),
                product.getTotalPages(),
                product.isFirst(),
                product.isLast()
                );
    }

    @Override
    public ProductResponse findSingleProduct(String id) {
        try{

            ProductEntity product = productRepository.findById(UUID.fromString(id)).orElseThrow(()-> new ApiRequestException("Product with " + id + " not found"));

         return productMapper.toProductResponse(product);
        }catch (Exception e){
            e.printStackTrace();
            throw new ApiRequestException(e.getMessage());
        }
    }

    @Override
    public ProductResponse updateProduct(String id, ProductDto productDto) {
          try{
              CloudinaryDto fileUploader = null;
              ProductEntity updatedProduct;

              ProductEntity findProduct = productRepository.findById(UUID.fromString(id)).orElseThrow(()-> new ApiRequestException("Product with " + id + " not found"));
              if (productDto.getImage() != null){

              fileUploader = cloudinaryService.uploadFile(productDto.getImage(), "Product Images");
              updatedProduct = productMapper.toUpdate(findProduct,productDto, fileUploader.getSecured_url(), fileUploader.getPublic_id());
              }else{
              updatedProduct = productMapper.toUpdate(findProduct,productDto);
              }
            productRepository.save(updatedProduct);
            return productMapper.toProductResponse(updatedProduct);
        }catch (Exception e){
            e.printStackTrace();
              throw new ApiRequestException(e.getMessage());
        }
    }

    @Override
    public String delete(String id) {
        try {
        ProductEntity product = productRepository.findById(UUID.fromString(id)).orElseThrow(()-> new ApiRequestException("product could not delete"));

        productRepository.delete(product);
        cloudinaryService.deleteFile(product.getImage_public_id());
        return "Product successfully deleted";
        }catch (Exception e){
            e.printStackTrace();
            throw new ApiRequestException(e.getMessage());
        }
    }
}
