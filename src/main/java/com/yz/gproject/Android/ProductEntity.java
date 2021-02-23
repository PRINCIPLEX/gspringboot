package com.yz.gproject.Android;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;


@Getter
@Setter
public class ProductEntity implements Serializable {
    private Long productId;
    private String productName;
    private byte[] productImg;
    private Long productMonth;
    private Double productMoney;
    private Long parentId;//父ID，用来更新左侧列表使用
    private long productCount;

    public ProductEntity(Long productId, String productName, byte[] productImg, long productMonth, Double productMoney, Long parentId) {
        this.productId = productId;
        this.productName = productName;
        this.productImg = productImg;
        this.productMonth = productMonth;
        this.productMoney = productMoney;
        this.parentId = parentId;
    }

    public ProductEntity(Long productId, String productName, byte[] productImg, Long productMonth, Double productMoney, Long parentId, long productCount) {
        this.productId = productId;
        this.productName = productName;
        this.productImg = productImg;
        this.productMonth = productMonth;
        this.productMoney = productMoney;
        this.parentId = parentId;
        this.productCount = productCount;
    }
}
