package com.data.productdata.data.repository;

import com.data.productdata.data.entity.Hotel;
import com.data.productdata.data.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface HotelRepository extends JpaRepository<Hotel,Long> {

        @Query("select r from Review r where r.hotel=:hotel order by r.id desc")
        List<Review> findReviewAll(Hotel hotel);
}
