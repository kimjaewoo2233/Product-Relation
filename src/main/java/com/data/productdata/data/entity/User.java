package com.data.productdata.data.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.lang.reflect.Member;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "users")
@ToString
public class User {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        private String email;

        private String name;

        private LocalDateTime createdAt;

        @OneToOne(mappedBy = "user")
        private MemberShip memberShip;

         public void issue(MemberShip memberShip){      //setMemberShip 이미 있는 값인지 조회회
                memberShip.assignTo(this);
                 this.memberShip = memberShip;
         }

}
