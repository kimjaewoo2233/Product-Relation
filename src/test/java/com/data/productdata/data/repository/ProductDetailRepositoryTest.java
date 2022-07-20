package com.data.productdata.data.repository;

import com.data.productdata.data.entity.Product;
import com.data.productdata.data.entity.ProductDetail;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class ProductDetailRepositoryTest {

    @Autowired
    private ProductDetailRepository detailRepository;

    @Autowired
    private ProductRepository productRepository;

    @DisplayName("OneToOne 테스트 - 단방향")
    @Test
    void oneTone(){
        Product product = new Product();
        product.setName("테스트상품");
        product.setPrice(5000);
        product.setStock(500);

        Product saveProduct = productRepository.save(product);

        ProductDetail detail = new ProductDetail();
        detail.setDescription("이 상품은 테스트 상품입니다");
        detail.setProduct(saveProduct);

        ProductDetail saveDetail = detailRepository.save(detail);

        detailRepository.findAll().forEach(System.out::println);

    }



}