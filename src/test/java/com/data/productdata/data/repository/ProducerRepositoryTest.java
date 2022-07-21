package com.data.productdata.data.repository;

import com.data.productdata.config.JpaAuditingConfiguration;
import com.data.productdata.data.entity.Producer;
import com.data.productdata.data.entity.Product;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@Import(JpaAuditingConfiguration.class)
class ProducerRepositoryTest {

    @Autowired
    ProducerRepository producerRepository;

    @Autowired
    ProductRepository productRepository;

    @DisplayName("다대다 테스트")
    @Test
    void test(){
            Product product1 = Product.of("연필",100,10);
            Product product2 = Product.of("지우개",100,10);
            Product product3 = Product.of("볼펜",100,10);

            productRepository.saveAll(Lists.newArrayList(product1,product2,product3));
            Producer producer = new Producer();
            producer.addProduct(product1);
            producer.addProduct(product2);
            producer.addProduct(product3);

            producerRepository.save(producer);

            producerRepository.findById(1L).get().getProducts().forEach(System.out::println);

    }

}