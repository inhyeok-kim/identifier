package com.seaweed.identifier.user;

import com.seaweed.identifier.user.vo.UserVO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserVO,Long> {

    Page<UserVO> findAll(Pageable pageable);

    @Query(value="""
        UPDATE USER 
        SET name = :name
        WHERE id = :id
    """, nativeQuery = true)
    void updateNameById(@Param("id") String id, @Param("name") String name);

    @Query(value="""
        SELECT seq, id, name, password
        FROM USER
        WHERE id = :id
    """, nativeQuery = true)
    @Nullable
    UserVO findOneByUserId(@Param("id") String id);

}