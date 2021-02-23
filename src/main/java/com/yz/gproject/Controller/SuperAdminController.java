package com.yz.gproject.Controller;

import com.yz.gproject.Entity.SuperAdminEntity;
import com.yz.gproject.Result.SuperAdminResult;
import com.yz.gproject.Service.SuperAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@CrossOrigin
public class SuperAdminController {
    @Autowired
    SuperAdminService superAdminService;

    @RequestMapping(value = "/super_login")
    @ResponseBody
    public SuperAdminResult login(@RequestBody SuperAdminEntity superAdminEntity) {

        String account = superAdminEntity.getAccount();
        String password = superAdminEntity.getPassword();
        return superAdminService.login(account,password);

    }

}
