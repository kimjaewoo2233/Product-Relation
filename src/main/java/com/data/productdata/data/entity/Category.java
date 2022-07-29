package com.data.productdata.data.entity;


import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Table(name="category")
public class Category {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column(unique = true)
        private String code;

        private String name;

        @OneToMany(fetch = FetchType.EAGER,mappedBy = "category_id")//일대다 단방향 매핑이다 여기서 특이한 점은 category_id라는 Fk를 이 테이블이 아닌
        private List<Product> products =new ArrayList<>();      //Product가가진다 큰 단점이다
                //원래 이 테이블에 외래키가 있으면 엔티티의 저장과 연관관계 처리를 INSERT SQL 한번으로 끝낼 수 있지만
                //다른 테이블에 외래키가 있다면 연관관계를 처리를 위한 UPDATE 를 한번 더 일으켜야한다.

}
