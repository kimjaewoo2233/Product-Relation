package com.data.productdata.data.repository;

import com.data.productdata.data.entity.Product;
import com.data.productdata.data.entity.Provider;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class ProviderRepositoryTest {

    @Autowired
    ProviderRepository providerRepository;

    @Autowired
    ProductRepository productRepository;

    @DisplayName("Provider data Test")
    @Test
    void test(){

            Provider provider = new Provider();
            provider.setName("떙떙물산");

            Provider saveProvider = providerRepository.save(provider);

            Product product = new Product();
            product.setName("가위");
            product.setPrice(5000);
            product.setStock(500);
            product.setProvider(saveProvider);

            Product product2 = new Product();
            product2.setName("풀");
            product2.setPrice(5000);
            product2.setStock(500);
            product2.setProvider(saveProvider);

            productRepository.saveAll(Lists.newArrayList(product,product2));
            productRepository.flush();

            productRepository.flush();
            providerRepository.findById(1L).get().getProducts().forEach(System.out::println);




    }
}