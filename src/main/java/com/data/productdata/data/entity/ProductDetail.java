package com.data.productdata.data.entity;


import lombok.*;

import javax.persistence.*;

@Entity
@Table(name="product_detail")
@Getter
@Setter
@NoArgsConstructor
@ToString(callSuper = true)
public class ProductDetail extends BaseEntity{
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Setter(AccessLevel.NONE)
        private Long id;

        private String description;

        @OneToOne
        @JoinColumn(name="product_number")
        private Product product;
}
