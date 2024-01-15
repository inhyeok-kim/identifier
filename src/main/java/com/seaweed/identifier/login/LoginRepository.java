package com.seaweed.identifier.login;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginRepository extends JpaRepository<LoginVO,Long> {

    @Query(value="""
        SELECT seq, id, name, password
        FROM USER
        WHERE id = :id
    """, nativeQuery = true)
    @Nullable
    LoginVO findOneByUserId(@Param("id") String id);

}