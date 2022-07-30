package com.data.productdata.data.repository;

import com.data.productdata.data.entity.Itinerary;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.AttributeOverride;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;

import java.lang.reflect.Array;
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
           Itinerary itinerary =new Itinerary("광화문 종로 인근","설명",sitess);
           itineraryRepository.save(itinerary);

           Itinerary savedItinerary = itineraryRepository.findById(1L).get();
           //여기서 select * from itinerary; 가 일어난다.
            String str = savedItinerary.getSites().get(0);
            // select * from itinerary_site; 가 일어난다. LAZY이므로 그렇다 - 영속성 컨텍스트가 종료된 상태에서 연결시도이므로 에러
            System.out.println(str);

        }
        @DisplayName("List 변경")
        @Test
        @Transactional
        void test2(){
            List<String> sitess = Arrays.asList("경북궁","청계천","명동","인사동");
            Itinerary itinerary =new Itinerary("광화문 종로 인근","설명",sitess);
            itineraryRepository.save(itinerary);

            Itinerary savedItinerary = itineraryRepository.findById(1L).get();
            List<String> changeList = Arrays.asList("궁구웅","구궁궁","하남시티","춘천시티");
            savedItinerary.setSites(changeList);
            Itinerary chageItinerary = itineraryRepository.findById(1L).get();
            System.out.println(chageItinerary.getSites().get(0));
            System.out.println(chageItinerary);


        }
        @BeforeEach
        void saved(){
            List<String> sitess = Arrays.asList("경북궁","청계천","명동","인사동");
            Itinerary itinerary =new Itinerary("광화문 종로 인근","설명",sitess);
            itineraryRepository.save(itinerary);
        }
        @DisplayName("List 변경 - EntitiyManager")
        @Test
        @Transactional
        void test3(){


            Itinerary savedItinerary = entityManager.find(Itinerary.class,1L);
            List<String> changeList = Arrays.asList("궁구웅","구궁궁","하남시티","춘천시티");
            savedItinerary.setSites(changeList);
            entityManager.persist(savedItinerary);


        }
}