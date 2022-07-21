package com.data.productdata.data.entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Table(name="producer")
public class Producer extends BaseEntity {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        private String code;

        private String name;

        @ManyToMany
        @JoinTable(name = "product_join")   //JoinColumn을 지정하지 않으면 중간에 테이블이 하나 생기고 그 이름을 여기서 짖어
        private List<Product> products = new ArrayList<>();

        public void addProduct(Product product){
            products.add(product);
        }
}
