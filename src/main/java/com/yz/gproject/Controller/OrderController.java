package com.yz.gproject.Controller;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.yz.gproject.Entity.CategoryEntity;
import com.yz.gproject.Entity.LinkOrderEntity;
import com.yz.gproject.Entity.OrderEntity;
import com.yz.gproject.Result.CategoryResult;
import com.yz.gproject.Result.OrderGoodResult;
import com.yz.gproject.Result.OrderResult;
import com.yz.gproject.Service.CategoryService;
import com.yz.gproject.Service.OrderService;
import com.yz.gproject.Service.ShopOpenService;
import com.yz.gproject.utils.WebSocketServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.text.DateFormat;
import java.util.List;
import java.util.Locale;
import java.util.Map;

@Controller
@CrossOrigin
public class OrderController {
    @Autowired
    public OrderService orderService;

    @Autowired
    public ShopOpenService shopOpenService;


    @RequestMapping(value = "/getaorder/{uphone}")
    @ResponseBody
    public String getaorder(@PathVariable String uphone) {
        return orderService.getAndroidOrder(uphone);
    }




    @RequestMapping("submitorder")
    @ResponseBody
    public int AndroidSubmitOrders(@RequestParam Map<String, String> map) throws IOException {

        if(shopOpenService.getStatus().getShopOpenEntity().getStatus()==false)
        {
            return 0;
        }
        else
        {
            String order = map.get("order");
            String link = map.get("link");
            Gson gson = new Gson();
            OrderEntity orderEntity = gson.fromJson(order,OrderEntity.class);
            List<LinkOrderEntity> linkOrderEntityList = gson.fromJson(link, new TypeToken<List<LinkOrderEntity>>() {}.getType());
            orderService.addOrder(orderEntity);
            orderService.addLinkOrder(linkOrderEntityList);
            WebSocketServer.sendInfo("audio","business");
            WebSocketServer.sendInfo("newOrder","order");
            return  200;

        }

    }


    @RequestMapping(value = "/setdeal/{id}",method = RequestMethod.GET)
    @ResponseBody
    public int setDeal(@PathVariable Long id) {
        return orderService.setDeal(id);
    }



    @RequestMapping(value = "/getOrderGood/{id}",method = RequestMethod.GET)
    @ResponseBody
    public List<OrderGoodResult> getOrderGood(@PathVariable String id) {
        return orderService.getOrderGoodsById(id);
    }


    @RequestMapping(value = "/order",method = RequestMethod.GET)
    @ResponseBody
    public OrderResult showorder(@RequestParam Map<String, String> map) {
        String flag = map.get("flag");
        String query = map.get("query");
        int pageNum =Integer.parseInt(map.get("pageNum")) -1;
        int pageSize =Integer.parseInt(map.get("pageSize"));
        Page<OrderEntity> list = orderService.getOrderByPage(flag,query,pageNum,pageSize);
        OrderResult orderResult = new OrderResult();
        if(list!=null)
        {
            orderResult.setStatus(200);
            orderResult.setPageNum(pageNum);
            orderResult.setTotal(list.getTotalElements());
            orderResult.setOrderEntity(list.toList());

        }
        else
        {
            orderResult.setStatus(500);
        }
        return orderResult;
    }

    @RequestMapping(value = "/dealorder",method = RequestMethod.GET)
    @ResponseBody
    public OrderResult showdealorder(@RequestParam Map<String, String> map) {
        String flag = map.get("flag");
        String query = map.get("query");
        int pageNum =Integer.parseInt(map.get("pageNum")) -1;
        int pageSize =Integer.parseInt(map.get("pageSize"));
        Page<OrderEntity> list = orderService.getDealOrderByPage(flag,query,pageNum,pageSize);
        OrderResult orderResult = new OrderResult();
        if(list!=null)
        {
            orderResult.setStatus(200);
            orderResult.setPageNum(pageNum);
            orderResult.setTotal(list.getTotalElements());
            orderResult.setOrderEntity(list.toList());

        }
        else
        {
            orderResult.setStatus(500);
        }
        return orderResult;
    }


}
