package com.yz.gproject.Controller;


import com.google.gson.Gson;
import com.yz.gproject.Entity.AdminUserEntity;
import com.yz.gproject.Entity.CustomerEntity;
import com.yz.gproject.Result.CustomerResult;

import com.yz.gproject.Result.EditCustomerResult;
import com.yz.gproject.Result.LoginResult;
import com.yz.gproject.Service.CustomerService;
import com.yz.gproject.utils.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
@CrossOrigin

public class CustomerController {

    @Autowired
    public CustomerService customerService;




    @RequestMapping(value = "/login/{account}/{password}", method = RequestMethod.GET)
    @ResponseBody
    public String login(@PathVariable String account,@PathVariable String password) {

        String customer;
        CustomerEntity customerEntity = customerService.customerLogin(account, password);
        //登录失败
        if (customerEntity == null) {
            return "500";
        }
        else {
           Gson gson = new Gson();
           customer = gson.toJson(customerEntity);
        }
        return customer;
    }



    @RequestMapping(value = "/change_user_avatar/{userPhone}")
    @ResponseBody
    public int changeUseAvatar(@PathVariable String userPhone,@RequestBody  byte[] userAvatar) {
        int status = customerService.changeUserAvatar(userPhone,userAvatar);
        return status;
    }




    @RequestMapping(value = "/forget_password/{userPhone}/{email}/{password}", method = RequestMethod.GET)
    @ResponseBody
    public int forgetUserPassword(@PathVariable String userPhone,@PathVariable String email,@PathVariable String password) {

        int status = customerService.forgetUserPassword(userPhone,email,password);
        return status;
    }


    @RequestMapping(value = "/change_user_password/{userPhone}/{password}", method = RequestMethod.GET)
    @ResponseBody
    public int changeUserPassword(@PathVariable String userPhone,@PathVariable String password) {
        int status = customerService.changeUserPassword(userPhone,password);
        return status;
    }


    @RequestMapping(value = "/change_user_phone/{userPhone}/{newPhone}", method = RequestMethod.GET)
    @ResponseBody
    public int changeUserPhone(@PathVariable String userPhone,@PathVariable String newPhone) {
        int status = customerService.changeUserPhone(userPhone,newPhone);
        return status;
    }


    @RequestMapping(value = "/change_user_name/{userPhone}/{userName}", method = RequestMethod.GET)
    @ResponseBody
    public int changeUserName(@PathVariable String userPhone,@PathVariable String userName) {
        int status = customerService.changeUserName(userPhone,userName);
        return status;
    }



    @RequestMapping(value = "/android_register",method = RequestMethod.POST)
    @ResponseBody
    public int androidAddCustomer(@RequestParam Map<String, String> map){
        String customerEntity = map.get("customerEntity");
        Gson gson = new Gson();
        CustomerEntity entity = gson.fromJson(customerEntity,CustomerEntity.class);
        return  customerService.add(entity);
    }


    @RequestMapping(value = "/addCustomer",method = RequestMethod.POST)
    @ResponseBody
    public int addCustomer(@RequestBody CustomerEntity entity){
        return  customerService.add(entity);
    }

    @RequestMapping(value = "/customer", method = RequestMethod.GET)
    @ResponseBody
    public CustomerResult show(@RequestParam Map<String, String> map) {
        String query = map.get("query");
        int pageNum = Integer.parseInt(map.get("pageNum")) - 1;
        int pageSize = Integer.parseInt(map.get("pageSize"));
        Page<CustomerEntity> list = customerService.getCustomerByPage(query, pageNum, pageSize);
        CustomerResult customerResult = new CustomerResult();
        if (list != null) {

            customerResult.setStatus(200);
            customerResult.setPageNum(pageNum);
            customerResult.setTotal(list.getTotalElements());
            customerResult.setCustomerEntity(list.toList());
        } else {
            customerResult.setStatus(500);
        }
        return customerResult;
    }

    @RequestMapping(value = "/editCustomer/{id}", method = RequestMethod.GET)
    @ResponseBody
    public EditCustomerResult editCustomer(@PathVariable Long id) {
        EditCustomerResult editCustomerResult = new EditCustomerResult();
        editCustomerResult.setCustomerEntity(customerService.getById(id));
        editCustomerResult.setStatus(200);
        return editCustomerResult;
    }

    @RequestMapping(value = "/editCustomer/{id}/{phone}/{password}/{email}", method = RequestMethod.GET)
    @ResponseBody
    public int editCustomer(@PathVariable Long id, @PathVariable String phone, @PathVariable String password, @PathVariable String email) {
        int status = customerService.update(id, phone, password, email);
        return status;
    }

    @RequestMapping(value = "/editCustomer/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public int deleteCustomer(@PathVariable Long id) {

        return customerService.delete(id);

    }
}