package com.data.productdata.service.impl;

import com.data.productdata.data.entity.school.Academy;
import com.data.productdata.data.repository.AcademyRepository;
import com.data.productdata.service.AcademyService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class AcademyServiceImpl implements AcademyService {
        private final AcademyRepository academyRepository;

        @Transactional
        public List<String> findAllSubjectNames(){
            return extractSubject(academyRepository.findAllJoinFetch());
        }

    private List<String> extractSubject(List<Academy> academies) {
        log.info(">>>>>>>>[모든 과목을 추출한다]<<<<<<<<<");
        log.info("Academy Size : {}", academies.size());
        //Academy 객체 중에 첫번째 값에 Subject를 List타입으로 바꿔서 준다
        return academies.stream().map(
                a -> a.getSubjectList().get(0).getName())
                .collect(Collectors.toList());
    }

}
