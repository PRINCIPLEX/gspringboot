package com.yz.gproject.Result;

import com.yz.gproject.Entity.AdminUserEntity;
import com.yz.gproject.Entity.CustomerEntity;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class CustomerResult {
    Long total;
    int pageNum;
    int Status;
    List<CustomerEntity> customerEntity;

}
