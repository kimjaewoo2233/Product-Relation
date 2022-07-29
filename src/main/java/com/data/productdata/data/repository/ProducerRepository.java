package com.data.productdata.data.repository;

import com.data.productdata.data.entity.Producer;
import com.data.productdata.data.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface ProducerRepository extends JpaRepository<Producer,Long> {
}
