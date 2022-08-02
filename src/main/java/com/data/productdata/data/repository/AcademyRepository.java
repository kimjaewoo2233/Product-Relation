package com.data.productdata.data.repository;

import com.data.productdata.data.entity.school.Academy;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
public interface AcademyRepository extends JpaRepository<Academy,Long> {

    @Query("select DISTINCT a from Academy a join fetch a.subjectList")
    List<Academy> findAllJoinFetch();
    //이 방법은 불필요한 쿼리문이 추가된다는 단점이 있다.
    //이 필드는 Eager 조회, 저 필드는 Lazy조회를 해야한다까지 쿼리에서 표현하는 것은
        //불 필요하다고 생각할 수 있다.

    @EntityGraph(attributePaths = "subjectList")
    @Query("select a from Academy a")
    List<Academy> findAllEntitiyGraph();

}
