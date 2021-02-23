package com.yz.gproject.Result;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter


public class OrderGoodResult {
    String gname;
    double price;
    long count;

    public OrderGoodResult(String gname, double price, long count) {
        this.gname = gname;
        this.price = price;
        this.count = count;
    }
}
