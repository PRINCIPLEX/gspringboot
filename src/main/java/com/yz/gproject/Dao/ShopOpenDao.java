package com.yz.gproject.Dao;

import com.yz.gproject.Entity.ShopOpenEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

@Transactional
public interface ShopOpenDao extends JpaRepository<ShopOpenEntity,Long> {

    @Modifying
    @Query(value = "UPDATE shop_open set shop_open.status = 1 WHERE shop_open.id =1",nativeQuery = true)
    void openShop();


    @Modifying
    @Query(value = "UPDATE shop_open set shop_open.status = 0 WHERE shop_open.id =1",nativeQuery = true)
    void closeShop();


}
