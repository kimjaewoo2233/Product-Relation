package com.data.productdata.data.entity.school;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.List;
@Entity
@Getter
@NoArgsConstructor
public class Academy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "academy_id")
    private List<Subject> subjectList =new ArrayList<>();

    @Builder
    public Academy(String name,List<Subject> subjects){
        this.name = name;
        if(subjects != null){
            this.subjectList = subjects;
        }   //null 체크
    }

    public void addSubject(Subject subject){
        this.subjectList.add(subject);
        subject.updateAcademy(this);
    }
}
