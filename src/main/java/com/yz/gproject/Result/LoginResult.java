package com.yz.gproject.Result;

import com.yz.gproject.Entity.AdminUserEntity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginResult {
    int status;
    AdminUserEntity adminUserEntity;
    String token;
}
