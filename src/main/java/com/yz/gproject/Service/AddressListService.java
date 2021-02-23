package com.yz.gproject.Service;

import com.yz.gproject.Dao.AddressListDao;
import com.yz.gproject.Entity.AddressListEntity;
import com.yz.gproject.Entity.CategoryEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressListService {
    @Autowired
    AddressListDao addressListDao;
    public int addAddressList(List<AddressListEntity> addressListEntityList)
    {
        addressListDao.saveAll(addressListEntityList);
        return 200;
    }

    public Page<AddressListEntity> getAddressListByPage(String query, int pageNum, int pageSize)
    {
        Page <AddressListEntity>list;
        if(query.equals(""))
        {
            PageRequest of = PageRequest.of(pageNum, pageSize);
            list = addressListDao.findAll(of);
        }
        else {
            Pageable of = PageRequest.of(pageNum, pageSize);
            list = addressListDao.findByName(query,of);
        }


        return list;
    }

    public int deleteAddress(long id)
    {
        addressListDao.deleteById(id);
        return 200;
    }

}
