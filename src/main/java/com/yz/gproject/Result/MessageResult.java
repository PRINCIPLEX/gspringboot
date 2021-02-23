package com.yz.gproject.Result;

import com.yz.gproject.Entity.AddressListEntity;
import com.yz.gproject.Entity.MessageEntity;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class MessageResult {

    Long total;
    int pageNum;
    int Status;
    List<MessageEntity> messageEntityList;
}
