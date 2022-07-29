package com.data.productdata.data.repository;

import com.data.productdata.config.JpaAuditingConfiguration;
import com.data.productdata.data.dto.ProductStatus;
import com.data.productdata.data.entity.Producer;
import com.data.productdata.data.entity.Product;
import com.data.productdata.data.entity.Provider;
import com.data.productdata.data.entity.QProduct;
import com.querydsl.core.types.Predicate;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;


import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@Import(JpaAuditingConfiguration.class)
class ProducerRepositoryTest {

    @Autowired
    ProducerRepository producerRepository;

    @Autowired
    ProviderRepository providerRepository;
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

    @DisplayName("Cascade Test")
    @Test
    void test2(){



        Provider provider = new Provider();
        provider.setName("연피주식회사");

        provider.addProduct(Product.of("연",500,1000));
        provider.addProduct(Product.of("필",1000,10000));
        //product가 자동으로 insert된다 영속성 전이 때문에 그렇다
        providerRepository.save(provider);
    }
    @DisplayName("QueryDSL 테스트하기")
    @Test
    void tewst(){
        Predicate predicate = QProduct.product.price.eq(50);

        Product product1 = Product.of("연필",50,10);
        Product product2 = Product.of("지우개",100,10);
        Product product3 = Product.of("볼펜",100,10);

        productRepository.saveAll(Lists.newArrayList(product1,product2,product3));
    }

    @Test
    void test5(){
        Product product1 = Product.of("연필",50,10);
        Product product2 = Product.of("지우개",100,10);
        Product product3 = Product.of("볼펜",100,10);

        productRepository.saveAll(Lists.newArrayList(product1,product2,product3));
        productRepository.findPriceGt(90).forEach(System.out::println);
    }
    @DisplayName("@Query 테스트")
    @Test
    void test6(){
        Product product1 = Product.of("연필",50,10);
        Product product2 = Product.of("지우개",100,10);
        Product product3 = Product.of("볼펜",100,10);

        productRepository.saveAll(Lists.newArrayList(product1,product2,product3));
        productRepository.findAll().forEach(System.out::println);
        productRepository.findByRecently("연필", LocalDateTime.now().plusDays(1L)).forEach(System.out::println);

    }
    @Test
    void test7(){
        Product product1 = Product.of("연필",50,10);
        Product product2 = Product.of("지우개",100,10);
        Product product3 = Product.of("볼펜",100,10);

        productRepository.saveAll(Lists.newArrayList(product1,product2,product3));
        productRepository.findNameAndPrice("연필").forEach(productNameAndPrice -> {
            System.out.println("상품이름은"+ productNameAndPrice.getName()+
                    "상품 가격은 "+productNameAndPrice.getPrice());
        });
    }

    @Test
    void test8(){



            Product product =new Product();
            product.setName("연필");
            product.setPrice(2000);
            product.setStock(20);

            productRepository.save(product);


            System.out.println(productRepository.findById(1L).get());
    }

}