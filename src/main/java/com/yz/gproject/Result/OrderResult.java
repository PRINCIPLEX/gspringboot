package com.yz.gproject.Result;

import com.yz.gproject.Entity.GoodsAndCategoryEntity;
import com.yz.gproject.Entity.OrderEntity;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class OrderResult {
    Long total;
    int pageNum;
    int Status;
    List<OrderEntity> orderEntity;

}
