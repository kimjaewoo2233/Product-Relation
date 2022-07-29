package com.data.productdata.data.repository;

import com.data.productdata.data.entity.Hotel;
import com.data.productdata.data.entity.Review;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class HotelRepositoryTest {


    @Autowired
    ReviewRepository reviewRepository;
    @Autowired
    HotelRepository hotelRepository;

    @Test
    void test(){
        Hotel hotel = new Hotel();
        hotel.setName("완전 좋은 호텔");

        hotelRepository.save(hotel);

        Review review1 =new Review();
        review1.setComment("정말 좋군");
        review1.setHotel(hotel);
        Review review2 =new Review();
        review2.setComment("정말 좋군");
        review2.setHotel(hotel);

        reviewRepository.saveAll(Lists.newArrayList(review1,review2));

        hotelRepository.findReviewAll(hotel).forEach(System.out::println);


    }
}