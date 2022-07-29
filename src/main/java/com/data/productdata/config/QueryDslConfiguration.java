package com.data.productdata.config;


import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Configuration
public class QueryDslConfiguration {

        @PersistenceContext
        EntityManager entityManager;

        @Bean
        public JPAQueryFactory jpaQueryFactory(){
                return new JPAQueryFactory(entityManager);
        }       //JPAQueryFactory를 Bean으로 등록하여 프로젝트 전역에서 QueryDSL 을 사용하게함

}
