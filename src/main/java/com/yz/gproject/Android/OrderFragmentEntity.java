package com.yz.gproject.Android;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter

public class OrderFragmentEntity {

    long id;
    String orderid;
    double totalprice;
    String cphone;
    String cname;

    String payway;
    String eatway;
    boolean iseatway;
    boolean isdeal = false;
    String remark;
    List<ProductEntity> productEntities;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    Date time;

    public OrderFragmentEntity(long id, String orderid, double totalprice, String cphone, String cname, String payway, String eatway, boolean iseatway, boolean isdeal, String remark, Date time) {
        this.id = id;
        this.orderid = orderid;
        this.totalprice = totalprice;
        this.cphone = cphone;
        this.cname = cname;
        this.payway = payway;
        this.eatway = eatway;
        this.iseatway = iseatway;
        this.isdeal = isdeal;
        this.remark = remark;
        this.time = time;
    }
}
