package com.data.productdata.data.repository;

import com.data.productdata.data.entity.Grade;
import com.data.productdata.data.entity.MemberShip;
import com.data.productdata.data.entity.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserRepositoryTest {

    @Autowired
    UserRepository userRepository;

    @Autowired
    MemberShipRepository memberShipRepository;

    @DisplayName("OneToOne 단방향 테스트")
    @Test
    @Transactional
    void test(){
        System.out.println(memberShipRepository.findById(3L).get());
    }
}