package com.data.productdata.service.impl;


import com.data.productdata.data.dto.ProductDto;
import com.data.productdata.data.dto.ProductResponseDto;
import com.data.productdata.data.entity.Product;
import com.data.productdata.data.repository.ProductRepository;
import com.data.productdata.service.ProductService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
@Data
@Slf4j
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Override
    public ProductResponseDto getProduct(Long number) {
        Product product = productRepository.findById(number).get();
        log.info("[getProduct() Method === {}]",product);

        ProductResponseDto dto = new ProductResponseDto();
        dto.setNumber(product.getNumber());
        dto.setName(product.getName());
        dto.setPrice(product.getPrice());
        dto.setStock(product.getStock());
        return dto;
    }
    @Override
    public ProductResponseDto saveProduct(ProductDto dto) {

        log.info("[saveProduct] productDTO : {}",dto.toString());

        Product product = new Product();
        product.setName(dto.getName());
        product.setPrice(dto.getPrice());
        product.setStock(dto.getStock());
        product.setCreatedAt(LocalDateTime.now());
        product.setUpdatedAt(LocalDateTime.now());

        Product saveProduct = productRepository.save(product);

        log.info("[saveProduct] saveProduct : {}",saveProduct);

        ProductResponseDto responseDto =  ProductResponseDto.builder()
                .number(saveProduct.getNumber())
                .name(saveProduct.getName())
                .price(saveProduct.getPrice())
                .stock(saveProduct.getStock())
                .build();

        return responseDto;
    }

    @Override
    public ProductResponseDto changeProductName(Long number, String name) throws Exception {
        Product foudProduct = productRepository.findById(number).get();
        foudProduct.setName(name);
        Product changeName = productRepository.save(foudProduct);

        ProductResponseDto dto = ProductResponseDto.builder()
                .number(changeName.getNumber())
                .name(changeName.getName())
                .price(changeName.getPrice())
                .stock(changeName.getStock())
                .build();


        return dto;
    }

    @Override
    public void deleteProduct(Long number) throws Exception {
        productRepository.deleteById(number);
    }
}
