package com.data.productdata.data.repository;


import com.data.productdata.data.entity.Product;
import com.data.productdata.data.entity.ProductDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface ProductDetailRepository extends JpaRepository<ProductDetail,Long> {
}
