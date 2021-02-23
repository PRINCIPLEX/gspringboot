package com.yz.gproject.Result;

import com.yz.gproject.Entity.AddressListEntity;
import com.yz.gproject.Entity.CategoryEntity;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class AddressListResult {
    Long total;
    int pageNum;
    int Status;
    List<AddressListEntity> addressListEntityList;
}
