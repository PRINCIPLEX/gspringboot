package com.yz.gproject.Dao;

import com.yz.gproject.Entity.MessageEntity;
import com.yz.gproject.Entity.UphotoEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UphotoDao extends JpaRepository<UphotoEntity,Long> {


    @Query(
            value = "SELECT * FROM uphoto WHERE owner LIKE %:query%",
            nativeQuery = true
    )
    Page<UphotoEntity> findByName(@Param("query")String query, Pageable page);



}
