package com.yz.gproject.Dao;

import com.yz.gproject.Entity.AdminUserEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;

public interface AdminUserDao extends JpaRepository<AdminUserEntity, Long> {



    AdminUserEntity findByAccount(String account);

    AdminUserEntity findByAccountAndPassword(String account,String password);
    AdminUserEntity getById(Long id);

    @Query(
            value = "SELECT * FROM admin_user WHERE account LIKE %:query%",
            nativeQuery = true
    )
    Page<AdminUserEntity>  findByAccount(@Param("query")String query, Pageable page);
}
