package com.data.productdata.data.repository;

import com.data.productdata.data.entity.Itinerary;
import com.data.productdata.data.entity.embeddable.SiteInfo;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.AttributeOverride;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;

import java.lang.reflect.Array;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ItineraryRepositoryTest {

        @Autowired
        ItineraryRepository itineraryRepository;

        @PersistenceContext
        EntityManager entityManager;
        @Test
        void test(){
           List<String> sitess = Arrays.asList("경북궁","청계천","명동","인사동");

           Itinerary savedItinerary = itineraryRepository.findById(1L).get();
           //여기서 select * from itinerary; 가 일어난다.
            // select * from itinerary_site; 가 일어난다. LAZY이므로 그렇다 - 영속성 컨텍스트가 종료된 상태에서 연결시도이므로 에러

        }
        @DisplayName("List 변경")
        @Test
        @Transactional
        void test2(){
            List<String> sitess = Arrays.asList("경북궁","청계천","명동","인사동");

            Itinerary savedItinerary = itineraryRepository.findById(1L).get();
            List<String> changeList = Arrays.asList("궁구웅","구궁궁","하남시티","춘천시티");
            Itinerary chageItinerary = itineraryRepository.findById(1L).get();
            System.out.println(chageItinerary.getSites().get(0));
            System.out.println(chageItinerary);


        }
//        @BeforeEach
        @Transactional(propagation = Propagation.REQUIRES_NEW)
        void saved(){

//            SiteInfo siteInfo = new SiteInfo("네이버사이트2", LocalDateTime.now());
//            SiteInfo siteInfo2 = new SiteInfo("다음사이트2", LocalDateTime.now());
//            List<SiteInfo> sitess = Arrays.asList(siteInfo,siteInfo2);


            itineraryRepository.save(new Itinerary("이름","tjfaud"));


        }
        @DisplayName("List 변경 - EntitiyManager")
        @Test
        @Transactional
        void test3(){
            Itinerary savedItinerary = entityManager.find(Itinerary.class,1L);
            List<String> changeList = Arrays.asList("궁구웅","구궁궁","하남시티","춘천시티");
            entityManager.persist(savedItinerary);
        }
        @DisplayName("임베디드 타입 사용한걸 불러오기")
        @Test
        void test4(){
            System.out.println(itineraryRepository.findById(1L).get());
        }

        @DisplayName("null 대입해서 delete 값 조회하기")
        @Test
        void test5(){


        }
}