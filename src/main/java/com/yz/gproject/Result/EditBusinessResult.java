package com.yz.gproject.Result;

import com.yz.gproject.Entity.AdminUserEntity;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class EditBusinessResult {
    int status;
    AdminUserEntity adminUserEntity;
}
