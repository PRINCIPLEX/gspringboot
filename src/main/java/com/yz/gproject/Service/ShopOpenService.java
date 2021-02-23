package com.yz.gproject.Service;

import com.yz.gproject.Dao.ShopOpenDao;
import com.yz.gproject.Entity.ShopOpenEntity;
import com.yz.gproject.Result.ShopOpenResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShopOpenService {
    @Autowired
    ShopOpenDao shopOpenDao;

    public ShopOpenResult getStatus()
    {
        ShopOpenResult shopOpenResult = new ShopOpenResult();
        ShopOpenEntity shopOpenEntity = shopOpenDao.getOne((long)1);
        if(shopOpenEntity!=null)
        {
            shopOpenResult.setShopOpenEntity(shopOpenEntity);
            shopOpenResult.setStatus(200);
        }
        return shopOpenResult;
    }


    public int openShop()
    {
        shopOpenDao.openShop();
        return 201;
    }

    public int closeShop()
    {
        shopOpenDao.closeShop();
        return 200;
    }
}
