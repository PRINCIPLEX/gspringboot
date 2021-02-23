package com.yz.gproject.Service;


import com.yz.gproject.Android.ProductListEntity;
import com.yz.gproject.Dao.CategoryDao;
import com.yz.gproject.Dao.GoodsDao;
import com.yz.gproject.Entity.CategoryEntity;
import com.yz.gproject.Entity.GoodsAndCategoryEntity;
import com.yz.gproject.Entity.GoodsEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class GoodsService {

    @Autowired
    public GoodsDao goodsDao;

    @Autowired
    public CategoryDao categoryDao;

    public List<ProductListEntity> getAndroidGood(){


        List<ProductListEntity>productListEntities = new ArrayList<ProductListEntity>();
        List<CategoryEntity>categoryEntityList = categoryDao.findAll();
        CategoryEntity categoryEntityTemp = new CategoryEntity();
        for(int i=0;i<categoryEntityList.size();i++)
        {
            ProductListEntity productListEntityTemp = new ProductListEntity();

            //得到当前category,将名称、id输入
            categoryEntityTemp =categoryEntityList.get(i);
            productListEntityTemp.setTypeName(categoryEntityTemp.getName());
            long pid = categoryEntityTemp.getId();
            productListEntityTemp.setTypeId(pid);

            //将对应类型所有商品录入
            productListEntityTemp.setProductEntities(goodsDao.getAndroidGoodById(pid));

            //放入需要返回的整个list中

            productListEntities.add(productListEntityTemp);

        }

        return productListEntities;
    }


    public GoodsEntity getById(long id)
    {
        return goodsDao.getById(id);
    }


    public int deleteById(long id)
    {
        goodsDao.deleteById(id);
        return 200;
    }

    public Page<GoodsAndCategoryEntity> getGoodsByPage(String categoryId,String query, int pageNum, int pageSize)
    {

        Pageable of = PageRequest.of(pageNum, pageSize);

        if(query.equals("")&&categoryId.equals(""))
        {
            return  goodsDao.showAll(of);
        }
        else if(query.equals("")&&!categoryId.equals(""))
        {
            long categoryValue =Long.parseLong(categoryId);
            return  goodsDao.showByCategory(categoryValue,of);
        }
        else if(!query.equals("")&&categoryId.equals(""))
        {
            return goodsDao.showByName(query,of);
        }
        else
        {
            long categoryValue =Long.parseLong(categoryId);
            return goodsDao.showByNameAndCategory(query,categoryValue,of);

        }

    }

    public int add(GoodsEntity entity)
    {
        goodsDao.save(entity);
        return 201;
    }


}
