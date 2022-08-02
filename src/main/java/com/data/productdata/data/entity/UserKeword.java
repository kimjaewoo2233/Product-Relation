package com.data.productdata.data.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "user_table")
@Getter
@Setter
public class UserKeword {
    @Id
    @Basic
    @Setter(AccessLevel.NONE)
    private String email;

    private String name;

    @Basic
    private LocalDateTime createDate;

    @ElementCollection
    @CollectionTable(
            name = "user_keyword",
            joinColumns = @JoinColumn(name = "user_email")
    )
    @Column(name = "keword")
    @org.hibernate.annotations.OrderBy(clause = "user_keyword")
    private Set<String> keywords = new HashSet<>();

    protected UserKeword(){

    }
    public UserKeword(String email,String name,LocalDateTime createDate){
        this.email = email;
        this.name = name;
        this.createDate = createDate;
    }

}
