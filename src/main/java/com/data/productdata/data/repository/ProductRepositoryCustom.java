package com.data.productdata.data.repository;

import com.data.productdata.data.entity.Product;
import java.util.List;

public interface ProductRepositoryCustom {
    List<Product> findPriceGt(int price);


}
