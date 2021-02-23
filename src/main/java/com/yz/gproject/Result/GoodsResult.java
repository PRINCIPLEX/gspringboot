package com.yz.gproject.Result;


import com.yz.gproject.Entity.GoodsAndCategoryEntity;
import com.yz.gproject.Entity.GoodsEntity;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class GoodsResult {
    Long total;
    int pageNum;
    int Status;
    List<GoodsAndCategoryEntity> goodsEntity;

}
