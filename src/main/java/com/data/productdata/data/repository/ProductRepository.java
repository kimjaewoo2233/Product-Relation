package com.data.productdata.data.repository;


import com.data.productdata.data.entity.Product;
import com.data.productdata.data.entity.ProductNameAndPrice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.time.LocalDateTime;

public interface ProductRepository extends JpaRepository<Product,Long>,ProductRepositoryCustom{

    @Query(value="select p from Product as p where p.name = ?1 and p.createdAt <= ?2")
    List<Product> findByRecently(String name, LocalDateTime time);

    @Query("select new com.data.productdata.data.entity.ProductNameAndPrice(p.name,p.price) " +
            "from Product p where p.name = :name")
    List<ProductNameAndPrice> findNameAndPrice(@Param("name") String name);
}
