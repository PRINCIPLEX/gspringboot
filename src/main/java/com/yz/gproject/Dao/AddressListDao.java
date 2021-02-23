package com.yz.gproject.Dao;

import com.yz.gproject.Entity.AddressListEntity;
import com.yz.gproject.Entity.CategoryEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AddressListDao extends JpaRepository<AddressListEntity,Long> {

    @Query(
            value = "SELECT * FROM address_list WHERE owner LIKE %:query%",
            nativeQuery = true
    )
    Page<AddressListEntity> findByName(@Param("query")String query, Pageable page);


}
