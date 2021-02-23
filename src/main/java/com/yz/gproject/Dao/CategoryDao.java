package com.yz.gproject.Dao;

import com.yz.gproject.Entity.CategoryEntity;
import com.yz.gproject.Entity.CustomerEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface CategoryDao extends JpaRepository<CategoryEntity, Long> {
    CategoryEntity getById(Long id);

    CategoryEntity findByName(String name);

    @Query(
            value = "SELECT * FROM category WHERE name LIKE %:query%",
            nativeQuery = true
    )
    Page<CategoryEntity> findByName(@Param("query")String query, Pageable page);
}

