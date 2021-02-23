package com.yz.gproject.Service;

import com.yz.gproject.Dao.CategoryDao;
import com.yz.gproject.Entity.CategoryEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service


public class CategoryService {

    @Autowired
    public CategoryDao categoryDao;

    public int add(CategoryEntity entity)
    {
        if(categoryDao.findByName(entity.getName())!=null)
        {
            return 501;
        }

        categoryDao.save(entity);
        return 201;
    }


    public int update(Long id ,String name)
    {
        if(categoryDao.findById(id)!=null)
        {
            if(categoryDao.findByName(name)!=null)
            {
                return 501;
            }

            CategoryEntity categoryEntity = new CategoryEntity();
            categoryEntity.setId(id);
            categoryEntity.setName(name);
            categoryDao.save(categoryEntity);
            return 200;
        }
        else
        {
            return 500;
        }
    }

    public int delete(Long id)
    {
        categoryDao.deleteById(id);
        return 200;
    }


    public CategoryEntity getById(Long id)
    {
        return categoryDao.getById(id);
    }

    public Page<CategoryEntity> getCategoryByPage(String query, int pageNum, int pageSize)
    {
        Page <CategoryEntity>list;
        if(query.equals(""))
        {
            PageRequest of = PageRequest.of(pageNum, pageSize);
            list = categoryDao.findAll(of);
        }
        else {
            Pageable of = PageRequest.of(pageNum, pageSize);
            list = categoryDao.findByName(query,of);
        }


        return list;
    }


}
