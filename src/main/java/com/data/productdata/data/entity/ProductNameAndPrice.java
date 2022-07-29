package com.data.productdata.data.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ProductNameAndPrice {

        private String name;
        private Integer price;

        public ProductNameAndPrice(String name,Integer price){
                this.name = name;
                this.price = price;
        }
}
