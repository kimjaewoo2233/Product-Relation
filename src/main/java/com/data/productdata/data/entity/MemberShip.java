package com.data.productdata.data.entity;

import lombok.Generated;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Setter
@Getter
@ToString
public class MemberShip {   //MemberShipCard 테이블인데 길어서 줄여씀
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @Enumerated(EnumType.STRING)
    private Grade grade;

    public void assignTo(User user){
        if(this.user != null) throw new RuntimeException();
        this.user = user;
    }
    //MemberShip 엔티티를 구한 뒤 새로 생성한 User 객체를 assignTo메서드에 전달
    //이미 있는 user가 멤버십이 있다면 에러를 일으키고 카드가 없다면 할당
}
