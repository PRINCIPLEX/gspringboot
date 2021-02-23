package com.yz.gproject.Entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GoodsAndCategoryEntity {
    private Long id;

    private String gname;

    private byte[] img;

    private Long sales;

    private Double price;

    private Long categoryId;

    private String name;

    private boolean issale;



    public GoodsAndCategoryEntity(Long id, String gname, byte[] img, Long sales, Double price, Long categoryId, String name,boolean issale) {
        this.id = id;
        this.gname = gname;
        this.img = img;
        this.sales = sales;
        this.price = price;
        this.categoryId = categoryId;
        this.name = name;
        this.issale = issale;
    }
}
