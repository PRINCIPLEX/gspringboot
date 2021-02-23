package com.yz.gproject.Android;

import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Setter
@Getter
public class ProductListEntity {

    private Long typeId;
    private String typeName;
    private List<ProductEntity> productEntities;
    private int typeCount;


}
