package com.yz.gproject.Dao;

import com.yz.gproject.Entity.AddressListEntity;
import com.yz.gproject.Entity.MessageEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface MessageDao extends JpaRepository<MessageEntity,Long> {

    @Query(
            value = "SELECT * FROM message WHERE owner LIKE %:query%",
            nativeQuery = true
    )
    Page<MessageEntity> findByName(@Param("query")String query, Pageable page);

}
