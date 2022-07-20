package com.data.productdata.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Configuration
public class QueryDslConfiguration {

        @PersistenceContext
        EntityManager entityManager;


}
