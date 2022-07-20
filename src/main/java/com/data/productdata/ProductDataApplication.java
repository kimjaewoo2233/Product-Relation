package com.data.productdata;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
public class ProductDataApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProductDataApplication.class, args);
    }

}
