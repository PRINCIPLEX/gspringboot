package com.yz.gproject.Result;

import com.yz.gproject.Entity.CustomerEntity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EditCustomerResult {
    int status;
    CustomerEntity customerEntity;
}
