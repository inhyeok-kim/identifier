package com.seaweed.identifier.user

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.lang.Nullable
import org.springframework.stereotype.Repository

@Repository
interface UserRepository : JpaRepository<User,Long> {

    @Query(value="""
        UPDATE USER 
        SET name = :name
        WHERE id = :id
    """, nativeQuery = true)
    fun updateNameById(id : String, name : String)

    @Query(value="""
        SELECT seq, id, name, password
        FROM USER
        WHERE id = :id
    """, nativeQuery = true)
    @Nullable
    fun findOneByUserId(id : String) : User

}