package com.yz.gproject.Result;

import com.yz.gproject.Entity.AdminUserEntity;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class BusinessResult {
    Long total;
    int pageNum;
    int Status;
    List<AdminUserEntity> adminUserEntity;

}
