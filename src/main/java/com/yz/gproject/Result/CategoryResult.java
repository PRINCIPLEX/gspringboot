package com.yz.gproject.Result;


import com.yz.gproject.Entity.CategoryEntity;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class CategoryResult {
    Long total;
    int pageNum;
    int Status;
    List<CategoryEntity> categoryEntity;

}
