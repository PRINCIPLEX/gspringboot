package com.yz.gproject.Result;

import com.yz.gproject.Entity.AndroidRemoteEntity;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class AndroidRemoteResult {
    int total;
    int Status;
    List<AndroidRemoteEntity> androidUserList;

}
