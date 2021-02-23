package com.yz.gproject.Service;

import com.yz.gproject.Dao.SuperAdminDao;
import com.yz.gproject.Entity.SuperAdminEntity;
import com.yz.gproject.Result.SuperAdminResult;
import com.yz.gproject.utils.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SuperAdminService {
    @Autowired
    SuperAdminDao superAdminDao;

    public SuperAdminResult login(String account,String password)
    {
        SuperAdminResult superAdminResult = new SuperAdminResult();
        SuperAdminEntity superAdminEntity = new SuperAdminEntity();
        superAdminEntity = superAdminDao.findByAccountAndPassword(account,password);
        if(superAdminEntity!=null)
        {
            superAdminResult.setSuperAdminEntity(superAdminEntity);
            String id = superAdminEntity.getId().toString();
            String token = new JwtUtils().createToken(id,account);
            superAdminResult.setToken(token);
            superAdminResult.setStatus(200);
        }
        else
        {
            superAdminResult.setStatus(500);
        }

        return superAdminResult;
    }
}
