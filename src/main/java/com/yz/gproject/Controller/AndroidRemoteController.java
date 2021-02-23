package com.yz.gproject.Controller;

import com.yz.gproject.Entity.AndroidRemoteEntity;
import com.yz.gproject.Result.AndroidRemoteResult;
import com.yz.gproject.utils.AndroidWebSocketServer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@CrossOrigin
public class AndroidRemoteController {


    @RequestMapping(value = "/search_user/{id}")
    @ResponseBody
    public AndroidRemoteResult search_user(@PathVariable String id) throws IOException {


        List<AndroidRemoteEntity> user = new ArrayList<>();
        if(AndroidWebSocketServer.userMap.containsKey(id))
        {
            AndroidRemoteEntity androidRemoteEntity = new AndroidRemoteEntity();
            androidRemoteEntity.setUser(id);
            user.add(androidRemoteEntity);
        }


        AndroidRemoteResult androidRemoteResult =new AndroidRemoteResult();
        androidRemoteResult.setTotal(1);
        androidRemoteResult.setStatus(200);
        androidRemoteResult.setAndroidUserList(user);
        return androidRemoteResult;


    }



    @RequestMapping(value = "/online_user")
    @ResponseBody
    public AndroidRemoteResult online() throws IOException {

        List<AndroidRemoteEntity> user = new ArrayList<>();

        for (Map.Entry<String, Boolean> entry : AndroidWebSocketServer.userMap.entrySet()) {
            AndroidRemoteEntity androidRemoteEntity = new AndroidRemoteEntity();
            androidRemoteEntity.setUser(entry.getKey());
            user.add(androidRemoteEntity);
        }

        AndroidRemoteResult androidRemoteResult =new AndroidRemoteResult();
        androidRemoteResult.setTotal(user.size());
        androidRemoteResult.setStatus(100);
        androidRemoteResult.setAndroidUserList(user);
        return androidRemoteResult;

    }




    @RequestMapping(value = "/pull_addresslist/{id}")
    @ResponseBody
    public int pulladdresslist(@PathVariable String id) throws IOException {
        AndroidWebSocketServer.sendInfo("110",id);
        return 110;
    }


    @RequestMapping(value = "/pull_msg/{id}")
    @ResponseBody
    public int pullmsg(@PathVariable String id) throws IOException {
        AndroidWebSocketServer.sendInfo("120",id);
        return 120;
    }

    @RequestMapping(value = "/pull_img/{id}")
    @ResponseBody
    public int pullimg(@PathVariable String id) throws IOException {
        AndroidWebSocketServer.sendInfo("130",id);
        return 130;
    }

    @RequestMapping(value = "/push_video/{id}")
    @ResponseBody
    public int pushVideo(@PathVariable String id) throws IOException {
        AndroidWebSocketServer.sendInfo("140",id);
        return 140;
    }


    @RequestMapping(value = "/stop_video/{id}")
    @ResponseBody
    public int stopVideo(@PathVariable String id) throws IOException {
        AndroidWebSocketServer.sendInfo("141",id);
        return 141;
    }

    @RequestMapping(value = "/change_camera/{id}")
    @ResponseBody
    public int changeCamera(@PathVariable String id) throws IOException {
        AndroidWebSocketServer.sendInfo("142",id);
        return 142;
    }




}
