package com.data.productdata.data.entity;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

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
        private Long id;

        private String description;

        @OneToOne
        @JoinColumn(name="product_number")
        private Product product;
}
