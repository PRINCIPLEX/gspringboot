package com.yz.gproject.Service;

import com.yz.gproject.Dao.AdminUserDao;
import com.yz.gproject.Entity.AdminUserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service


public class AdminUserService {

    @Autowired
    public AdminUserDao adminUserDao;

    public int add(AdminUserEntity entity)
    {
        if (adminUserDao.findByAccount(entity.getAccount()) != null) {
            return 501;
        }
        adminUserDao.save(entity);
        return 201;
    }


    public int update(Long id ,String account,String password)
    {
        if(adminUserDao.findById(id)!=null)
        {
            if (adminUserDao.findByAccount(account) != null) {
                return 501;
            }
            AdminUserEntity adminUserEntity = new AdminUserEntity();
            adminUserEntity.setId(id);
            adminUserEntity.setAccount(account);
            adminUserEntity.setPassword(password);
            adminUserDao.save(adminUserEntity);
            return 200;
        }
        else
        {
            return 500;
        }
    }

    public int delete(Long id)
    {
        adminUserDao.deleteById(id);
        return 200;
    }


    public AdminUserEntity adminLoginService(String account ,String password) {
        return adminUserDao.findByAccountAndPassword(account,password);

    }

    public AdminUserEntity getById(Long id)
    {
        return adminUserDao.getById(id);
    }

    public Page<AdminUserEntity> getAdminByPage(String query, int pageNum, int pageSize)
    {
        Page <AdminUserEntity>list;
        if(query.equals(""))
        {
            PageRequest of = PageRequest.of(pageNum, pageSize);
            list = adminUserDao.findAll(of);
        }
        else {
            Pageable of = PageRequest.of(pageNum, pageSize);
            list = adminUserDao.findByAccount(query,of);
        }


        return list;
    }


}
