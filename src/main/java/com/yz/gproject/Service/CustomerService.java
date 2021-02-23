package com.yz.gproject.Service;

import com.google.gson.Gson;
import com.yz.gproject.Dao.CustomerDao;
import com.yz.gproject.Entity.AdminUserEntity;
import com.yz.gproject.Entity.CustomerEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service

public class CustomerService {

    @Autowired
    public CustomerDao customerDao;


    public CustomerEntity customerLogin(String phone, String password) {
        return customerDao.findCustomerEntityByPhoneAndPassword(phone, password);
    }


    public int changeUserAvatar(String userPhone, byte[] avatar) {
        customerDao.changeUserAvatar(userPhone, avatar);
        return 200;
    }

    public int forgetUserPassword(String userPhone,String email,String password)
    {
        if(customerDao.findCustomerEntityByPhoneAndAndEmail(userPhone,email)!=null)
        {
            customerDao.changeUserPassword(userPhone,password);
            return 200;
        }
        else
        {
            return 501;
        }
    }


    public int changeUserPassword(String userPhone, String password) {
        customerDao.changeUserPassword(userPhone, password);
        return 200;
    }

    public int changeUserPhone(String userPhone, String newphone) {
        if (customerDao.findByPhone(newphone) != null) {
            return 501;
        } else {
            customerDao.changeUserPhone(userPhone, newphone);
            return 200;
        }

    }

    public int changeUserName(String userPhone, String userName) {
        customerDao.changeUserName(userPhone, userName);
        return 200;
    }


    public int add(CustomerEntity entity) {
        if (customerDao.findByPhone(entity.getPhone()) != null) {
            return 501;
        } else {
            customerDao.save(entity);
            return 201;
        }

    }


    public int delete(Long id) {
        customerDao.deleteById(id);
        return 200;
    }


    public CustomerEntity getById(Long id) {
        return customerDao.getById(id);
    }


    public Page<CustomerEntity> getCustomerByPage(String query, int pageNum, int pageSize) {
        Page<CustomerEntity> list;
        if (query.equals("")) {
            PageRequest of = PageRequest.of(pageNum, pageSize);
            list = customerDao.findAll(of);
        } else {
            Pageable of = PageRequest.of(pageNum, pageSize);
            list = customerDao.findByPhoneWithPage(query, of);
        }
        return list;
    }

    public int update(Long id, String phone, String password, String email) {
        if (customerDao.findById(id) != null) {
            if (customerDao.findByPhone(phone) != null) {
                return 501;
            } else {
                CustomerEntity customerentity = customerDao.getById(id);
                customerentity.setPhone(phone);
                customerentity.setPassword(password);
                customerentity.setEmail(email);
                customerDao.save(customerentity);
                return 200;
            }
        } else {
            return 500;
        }
    }

}
