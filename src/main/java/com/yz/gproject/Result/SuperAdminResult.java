package com.yz.gproject.Result;

import com.yz.gproject.Entity.AdminUserEntity;
import com.yz.gproject.Entity.SuperAdminEntity;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class SuperAdminResult {
    int status;
    SuperAdminEntity superAdminEntity;
    String token;
}
