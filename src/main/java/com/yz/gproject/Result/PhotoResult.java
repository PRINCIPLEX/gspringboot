package com.yz.gproject.Result;

import com.yz.gproject.Entity.MessageEntity;
import com.yz.gproject.Entity.UphotoEntity;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PhotoResult {

    Long total;
    int pageNum;
    int Status;
    List<UphotoEntity> uphotoEntityList ;


}
