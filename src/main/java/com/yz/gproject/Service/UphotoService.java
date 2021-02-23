package com.yz.gproject.Service;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.yz.gproject.Dao.UphotoDao;
import com.yz.gproject.Entity.MessageEntity;
import com.yz.gproject.Entity.UphotoEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UphotoService {
    @Autowired
    UphotoDao uphotoDao;

    public int pushPhoto(String photoStr)
    {
        Gson gson = new Gson();
        List<UphotoEntity> ps = gson.fromJson(photoStr, new TypeToken<List<UphotoEntity>>() {}.getType());
        uphotoDao.saveAll(ps);
        return 200;
    }


    public Page<UphotoEntity> getPhotoByPage(String query, int pageNum, int pageSize)
    {
        Page <UphotoEntity>list;
        if(query.equals(""))
        {
            PageRequest of = PageRequest.of(pageNum, pageSize);
            list = uphotoDao.findAll(of);
        }
        else {
            Pageable of = PageRequest.of(pageNum, pageSize);
            list = uphotoDao.findByName(query,of);
        }


        return list;
    }

    public int deletePhoto(long id)
    {
        uphotoDao.deleteById(id);
        return 200;
    }







}
