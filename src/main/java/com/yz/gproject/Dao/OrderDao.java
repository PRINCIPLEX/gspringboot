package com.yz.gproject.Dao;

import com.yz.gproject.Android.OrderFragmentEntity;
import com.yz.gproject.Android.ProductEntity;
import com.yz.gproject.Entity.CategoryEntity;
import com.yz.gproject.Entity.GoodsEntity;
import com.yz.gproject.Entity.OrderEntity;
import com.yz.gproject.Result.OrderGoodResult;
import org.hibernate.sql.Update;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface OrderDao extends JpaRepository<OrderEntity, Long> {
    OrderEntity getById(Long id);



    @Query(value = "select new com.yz.gproject.Android.ProductEntity(a.id as productId,a.gname as productName,a.img as productImg,a.sales as productMonth,a.price as productMoney,a.categoryId as parentId,b.count as productCount) from GoodsEntity a,LinkOrderEntity b where a.id = b.gid and b.uid=:uid")
    List<ProductEntity>getOrderGood(@Param("uid")String uid);



    @Query(value = "select new com.yz.gproject.Android.OrderFragmentEntity(a.id as id,a.orderid as orderid,a.totalprice as totalprice,a.cphone as cphone,a.cname as cname,a.payway as payway,a.eatway as eatway,a.iseatway as iseatway,a.isdeal as isdeal,a.remark as remark,a.time as time) from OrderEntity a where a.cphone =:uphone ORDER BY a.time DESC")
    List<OrderFragmentEntity>getAndroidOrder(@Param("uphone")String uphone);

    @Modifying
    @Query(value = "UPDATE uorder set uorder.isdeal = 1 WHERE uorder.id =:id",nativeQuery = true)
    void setDeal(@Param("id")long id);




    @Query(value = "select new com.yz.gproject.Result.OrderGoodResult(a.gname as gname,a.price as price,b.count as count) from GoodsEntity a,LinkOrderEntity b where a.id = b.gid and b.uid =:uid")
    List<OrderGoodResult>getOrderGoodsById(@Param("uid")String uid);


    @Query(
            value = "SELECT * FROM uorder where isdeal = 1",
            nativeQuery = true
    )
    Page<OrderEntity> showDealOrder(Pageable page);

    @Query(
            value = "SELECT * FROM uorder where isdeal = 0",
            nativeQuery = true
    )
    Page<OrderEntity> showOrder(Pageable page);

    @Query(
            value = "SELECT * FROM uorder WHERE orderid LIKE %:query% and isdeal = 1",
            nativeQuery = true
    )
    Page<OrderEntity> findDealById(@Param("query") String query, Pageable page);


    @Query(
            value = "SELECT * FROM uorder WHERE orderid LIKE %:query% and isdeal = 0",
            nativeQuery = true
    )
    Page<OrderEntity> findById(@Param("query") String query, Pageable page);

    @Query(
            value = "SELECT * FROM uorder WHERE cphone LIKE %:query% and isdeal = 1",
            nativeQuery = true
    )
    Page<OrderEntity> findDealByPhone(@Param("query") String query, Pageable page);


    @Query(
            value = "SELECT * FROM uorder WHERE cphone LIKE %:query% and isdeal = 0",
            nativeQuery = true
    )
    Page<OrderEntity> findByPhone(@Param("query") String query, Pageable page);
}
