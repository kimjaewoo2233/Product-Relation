package com.data.productdata.data.dto;


import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class ProductDto {
        private String name;
        private int price;
        private int stock;
}
