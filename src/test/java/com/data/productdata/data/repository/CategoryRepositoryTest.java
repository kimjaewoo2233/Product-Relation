package com.data.productdata.data.repository;

import com.data.productdata.data.entity.Category;
import com.data.productdata.data.entity.Product;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CategoryRepositoryTest {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    CategoryRepository categoryRepository;

    @DisplayName("일대다 양방향 테스트")
    @Test
    void test(){
        Product product = new Product();
        product.setName("펜");
        product.setPrice(2000);
        product.setStock(100);

        productRepository.save(product);

        Category category = new Category();
        category.setCode("S1");
        category.setName("도서");
        category.getProducts().add(product);

        categoryRepository.save(category);

        categoryRepository.findById(1L).get().getProducts().forEach(System.out::println);

    }

    @Test
    void test2(){
        Category category = new Category();
        category.setName("필기구");
        category.setCode("str");

        Category saveCategoty = categoryRepository.save(category);
        Product product = Product.of("연필",100,10);
        product.setCategory_id(saveCategoty);
        Product product2 = Product.of("연필",100,10);
        product2.setCategory_id(saveCategoty);

        productRepository.save(product);
        productRepository.save(product2);

        System.out.println(productRepository.findById(1L).get().getCategory_id());


    }
}