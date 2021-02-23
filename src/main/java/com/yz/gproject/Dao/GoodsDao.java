package com.yz.gproject.Dao;

import com.yz.gproject.Android.ProductEntity;
import com.yz.gproject.Entity.GoodsAndCategoryEntity;
import com.yz.gproject.Entity.GoodsEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface GoodsDao extends JpaRepository <GoodsEntity,Long> {

    GoodsEntity getById(long id);


   @Query(value = "select new com.yz.gproject.Android.ProductEntity(a.id as productId,a.gname as productName,a.img as productImg,a.sales as productMonth,a.price as productMoney,a.categoryId as parentId) from GoodsEntity a where a.categoryId = :pid and a.issale=1")
    List<ProductEntity>getAndroidGoodById(@Param("pid")long pid);


    @Query(value = "select new  com.yz.gproject.Entity.GoodsAndCategoryEntity(a.id as id,a.gname as gname,a.img as img,a.sales as sales,a.price as price,b.id as categoryId,b.name as name,a.issale as issale) from GoodsEntity a LEFT JOIN CategoryEntity b on a.categoryId = b.id")
    Page<GoodsAndCategoryEntity> showAll(Pageable page);

    @Query(value = "select new  com.yz.gproject.Entity.GoodsAndCategoryEntity(a.id as id,a.gname as gname,a.img as img,a.sales as sales,a.price as price,b.id as categoryId,b.name as name,a.issale as issale) from GoodsEntity a,CategoryEntity b where a.categoryId = b.id and a.categoryId= :categoryValue")
    Page<GoodsAndCategoryEntity> showByCategory(@Param("categoryValue")long categoryValue, Pageable page);


    @Query(value = "select new  com.yz.gproject.Entity.GoodsAndCategoryEntity(a.id as id,a.gname as gname,a.img as img,a.sales as sales,a.price as price,b.id as categoryId,b.name as name,a.issale as issale) from GoodsEntity a,CategoryEntity b where a.categoryId = b.id and a.gname like %:query%")
    Page<GoodsAndCategoryEntity> showByName(@Param("query")String query, Pageable page);

    @Query(value = "select new  com.yz.gproject.Entity.GoodsAndCategoryEntity(a.id as id,a.gname as gname,a.img as img,a.sales as sales,a.price as price,b.id as categoryId,b.name as name,a.issale as issale) from GoodsEntity a,CategoryEntity b where a.categoryId = b.id and a.gname like %:query% and a.categoryId= :categoryValue")
    Page<GoodsAndCategoryEntity> showByNameAndCategory(@Param("query")String query,@Param("categoryValue")long categoryValue, Pageable page);


}
