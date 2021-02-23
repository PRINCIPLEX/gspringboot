package com.yz.gproject.Service;

import com.google.gson.Gson;
import com.yz.gproject.Android.OrderFragmentEntity;
import com.yz.gproject.Android.ProductEntity;
import com.yz.gproject.Dao.LinkOrderDao;
import com.yz.gproject.Dao.OrderDao;
import com.yz.gproject.Entity.LinkOrderEntity;
import com.yz.gproject.Entity.OrderEntity;
import com.yz.gproject.Result.OrderGoodResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class OrderService {

    @Autowired
    public OrderDao orderDao;

    @Autowired
    public LinkOrderDao linkOrderDao;


    public String getAndroidOrder(String uphone) {
        List<OrderFragmentEntity> orderFragmentEntityList = orderDao.getAndroidOrder(uphone);
        for (int i = 0; i < orderFragmentEntityList.size(); i++) {
            String orderId = orderFragmentEntityList.get(i).getOrderid();
            List<ProductEntity>productEntityList = orderDao.getOrderGood(orderId);
            orderFragmentEntityList.get(i).setProductEntities(productEntityList);
        }
        Gson gson = new Gson();
        return gson.toJson(orderFragmentEntityList);
    }

    public void addOrder(OrderEntity entity) {

        orderDao.save(entity);
    }

    public void addLinkOrder(List<LinkOrderEntity> linkOrderEntityList) {
        linkOrderDao.saveAll(linkOrderEntityList);
    }

    public List<OrderGoodResult> getOrderGoodsById(String uid) {
        return orderDao.getOrderGoodsById(uid);
    }

    public int setDeal(long id) {
        orderDao.setDeal(id);
        return 200;
    }


    public Page<OrderEntity> getOrderByPage(String flag, String query, int pageNum, int pageSize) {
        Page<OrderEntity> list;
        if (flag.equals("")) {
            Pageable of = PageRequest.of(pageNum, pageSize);
            list = orderDao.showOrder(of);

        } else if (flag.equals("id")) {
            Pageable of = PageRequest.of(pageNum, pageSize);
            list = orderDao.findById(query, of);

        } else {
            Pageable of = PageRequest.of(pageNum, pageSize);
            list = orderDao.findByPhone(query, of);
        }

        return list;
    }


    public Page<OrderEntity> getDealOrderByPage(String flag, String query, int pageNum, int pageSize) {
        Page<OrderEntity> list;
        if (flag.equals("")) {
            Pageable of = PageRequest.of(pageNum, pageSize);
            list = orderDao.showDealOrder(of);

        } else if (flag.equals("id")) {
            Pageable of = PageRequest.of(pageNum, pageSize);
            list = orderDao.findDealById(query, of);
        } else {
            Pageable of = PageRequest.of(pageNum, pageSize);
            list = orderDao.findDealByPhone(query, of);
        }

        return list;
    }


}
