package com.yz.gproject.Dao;

import com.yz.gproject.Entity.SuperAdminEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SuperAdminDao extends JpaRepository<SuperAdminEntity,Long> {

    SuperAdminEntity findByAccountAndPassword(String account,String password);
}
