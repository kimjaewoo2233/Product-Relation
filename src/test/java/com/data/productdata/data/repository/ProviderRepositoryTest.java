package com.data.productdata.data.repository;

import com.data.productdata.config.JpaAuditingConfiguration;
import com.data.productdata.data.entity.Product;
import com.data.productdata.data.entity.Provider;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
@Import(JpaAuditingConfiguration.class)
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

    @DisplayName("Cascade Test")
    @Test
    void cascadeTest(){
        Provider provider = new Provider();
        provider.setName("이름");


        Product product1 = Product.of("연필",100,10);
        Product product2 = Product.of("지우개",100,10);
        Product product3 = Product.of("볼펜",100,10);

        productRepository.saveAll(Lists.newArrayList(product1,product2,product3));

        provider.getProducts().addAll(Lists.newArrayList(product1,product2,product3));


    }
}