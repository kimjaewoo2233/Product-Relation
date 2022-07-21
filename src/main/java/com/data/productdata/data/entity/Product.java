package com.data.productdata.data.entity;


import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Table(name = "product")
public class Product extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long number;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Integer price;

    @Column(nullable = false)
    private Integer stock;

    @OneToOne(mappedBy="product")
    @ToString.Exclude
    ProductDetail productDetail;

    @ManyToOne
    @JoinColumn(name="provider_id")
    @ToString.Exclude
    private Provider provider;

    @ManyToMany
    @ToString.Exclude
    List<Producer> producers = new ArrayList<>();

    public void addProducer(Producer producer){
        producers.add(producer);
    }

    Product(String name,int price,int stock){
        this.name = name;
        this.price = price;
        this.stock = stock;
    }
    public static Product of(String name,int price,int stock){
        return new Product(name,price,stock);
    }
}
