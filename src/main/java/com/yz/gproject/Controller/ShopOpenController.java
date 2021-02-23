package com.yz.gproject.Controller;

import com.yz.gproject.Result.ShopOpenResult;
import com.yz.gproject.Service.ShopOpenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@CrossOrigin
public class ShopOpenController {
    @Autowired
    ShopOpenService shopOpenService;


    @RequestMapping(value = "/android_get_shop_status")
    @ResponseBody
    public int androidGetStatus()
    {
        boolean status = shopOpenService.getStatus().getShopOpenEntity().getStatus();
        if(status)
        {
            return 1;
        }
        else
        {
            return 0;
        }
    }

    @RequestMapping(value = "/get_shop_status")
    @ResponseBody
    public ShopOpenResult getShopStatus()
    {
        return shopOpenService.getStatus();
    }



    @RequestMapping(value = "/open_shop")
    @ResponseBody
    public int openShop()
    {
        return shopOpenService.openShop();
    }

    @RequestMapping(value = "/close_shop")
    @ResponseBody
    public int closeShop()
    {
        return shopOpenService.closeShop();
    }

}
