package com.yz.gproject.Service;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.yz.gproject.Dao.MessageDao;
import com.yz.gproject.Entity.AddressListEntity;
import com.yz.gproject.Entity.MessageEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService {
    @Autowired
    MessageDao messageDao;
    public int addMsg(String msg)
    {
        Gson gson = new Gson();
        List<MessageEntity>messageEntityList =gson.fromJson(msg, new TypeToken<List<MessageEntity>>() {}.getType());
        messageDao.saveAll(messageEntityList);
        return 200;
    }

    public Page<MessageEntity> getMessageByPage(String query, int pageNum, int pageSize)
    {
        Page <MessageEntity>list;
        if(query.equals(""))
        {
            PageRequest of = PageRequest.of(pageNum, pageSize);
            list = messageDao.findAll(of);
        }
        else {
            Pageable of = PageRequest.of(pageNum, pageSize);
            list = messageDao.findByName(query,of);
        }


        return list;
    }

    public int deleteMessage(long id)
    {
        messageDao.deleteById(id);
        return 200;
    }


}
