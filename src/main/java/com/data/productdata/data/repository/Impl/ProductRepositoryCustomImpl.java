package com.data.productdata.data.repository.Impl;

import com.data.productdata.data.entity.Product;
import com.data.productdata.data.entity.QProduct;
import com.data.productdata.data.repository.ProductRepositoryCustom;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("support")
public class ProductRepositoryCustomImpl extends QuerydslRepositorySupport implements ProductRepositoryCustom {

        public ProductRepositoryCustomImpl(){
            super(Product.class);
        }

    @Override
    public List<Product> findPriceGt(int price) {

            List<Product> productList = from(QProduct.product)
                    .where(QProduct.product.price.gt(price))
                    .select(QProduct.product)
                    .fetch();

            return productList;
    }
}
