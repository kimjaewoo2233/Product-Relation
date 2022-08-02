package com.data.productdata.service.impl;

import com.data.productdata.data.entity.school.Academy;
import com.data.productdata.data.entity.school.Subject;
import com.data.productdata.data.repository.AcademyRepository;
import com.data.productdata.service.AcademyService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


@SpringBootTest
class AcademyServiceImplTest {

        @Autowired
        private AcademyRepository academyRepository;

        @Autowired
        private AcademyService academyService;

//        @AfterEach
        public void cleanAll(){
            academyRepository.deleteAll();
        }
        @BeforeEach
        public void setup(){
            List<Academy> academyList = new ArrayList<>();
            for(int i=0;i<10;i++){
                Academy academy = Academy.builder()
                        .name("강남스쿨"+i)
                        .build();
                academy.addSubject(Subject.builder()
                        .name("자바웹개발"+i)
                        .build());

                academyList.add(academy);
            }
            academyRepository.saveAll(academyList);
        }

        @Test
        void NplusOne(){
            List<String> subjectNames = academyService.findAllSubjectNames();

            System.out.println(subjectNames.size());
            //n+1문제발생
        }
}