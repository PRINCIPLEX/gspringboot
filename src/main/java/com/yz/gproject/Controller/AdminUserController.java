package com.yz.gproject.Controller;

import com.yz.gproject.Entity.AdminUserEntity;
import com.yz.gproject.Result.BusinessResult;
import com.yz.gproject.Result.EditBusinessResult;
import com.yz.gproject.Service.AdminUserService;
import com.yz.gproject.utils.JwtUtils;
import com.yz.gproject.Result.LoginResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


@Controller
@CrossOrigin

public class AdminUserController {

    @Autowired
    public AdminUserService adminUserService;

    @RequestMapping(value = "/addBusiness",method = RequestMethod.POST)
    @ResponseBody
    public int addBusiness(@RequestBody AdminUserEntity entity){
        return  adminUserService.add(entity);
    }

    @RequestMapping(value = "/editBusiness/{id}/{account}/{password}",method = RequestMethod.GET)
    @ResponseBody
    public int editBusiness(@PathVariable Long id,@PathVariable String account,@PathVariable String password){
        int status = adminUserService.update(id,account,password);
        return status;
    }



    @RequestMapping(value = "/editBusiness/{id}",method = RequestMethod.DELETE)
    @ResponseBody
    public int deleteBusiness(@PathVariable Long id) {

        return adminUserService.delete(id);

    }


    @RequestMapping(value = "/editBusiness/{id}",method = RequestMethod.GET)
    @ResponseBody
    public EditBusinessResult editBusiness(@PathVariable Long id) {
        EditBusinessResult editBusinessResult = new EditBusinessResult();
        editBusinessResult.setAdminUserEntity(adminUserService.getById(id));
        editBusinessResult.setStatus(200);
        return editBusinessResult;
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public LoginResult login(@RequestBody AdminUserEntity adminUserEntity) {
        String account = adminUserEntity.getAccount();
        String password = adminUserEntity.getPassword();


        AdminUserEntity user = adminUserService.adminLoginService(account, password);
        LoginResult loginResult = new LoginResult();
        //登录失败
        if (user == null) {
            loginResult.setStatus(500);
        }
        else {
            String id = user.getId().toString();
            String token = new JwtUtils().createToken(id,account);
            loginResult.setAdminUserEntity(adminUserEntity);
            loginResult.setToken(token);
            loginResult.setStatus(200);
        }
        return loginResult;
    }

    @RequestMapping(value = "/business",method = RequestMethod.GET)
    @ResponseBody
    public BusinessResult show(@RequestParam  Map<String, String> map) {
       String query = map.get("query");
        int pageNum =Integer.parseInt(map.get("pageNum")) -1;
        int pageSize =Integer.parseInt(map.get("pageSize"));
       Page<AdminUserEntity> list = adminUserService.getAdminByPage(query,pageNum,pageSize);
       BusinessResult businessResult = new BusinessResult();
       if(list!=null)
       {
           businessResult.setStatus(200);
           businessResult.setPageNum(pageNum);
           businessResult.setTotal(list.getTotalElements());
           businessResult.setAdminUserEntity(list.toList());
       }
       else
       {
           businessResult.setStatus(500);
       }
        return businessResult;
    }


}


