package com.yz.gproject.Controller;

import com.yz.gproject.Entity.AddressListEntity;
import com.yz.gproject.Entity.MessageEntity;
import com.yz.gproject.Result.AddressListResult;
import com.yz.gproject.Result.MessageResult;
import com.yz.gproject.Service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
@CrossOrigin
public class MessageController {

    @Autowired
    MessageService messageService;

    @RequestMapping(value = "/pushmsg")
    @ResponseBody
    public int pushmsg(@RequestParam Map<String, String> map) {
        String msg = map.get("msg");
        return messageService.addMsg(msg);
    }

    @RequestMapping(value = "/message",method = RequestMethod.GET)
    @ResponseBody
    public MessageResult show(@RequestParam  Map<String, String> map) {
        String query = map.get("query");
        int pageNum =Integer.parseInt(map.get("pageNum")) -1;
        int pageSize =Integer.parseInt(map.get("pageSize"));
        Page<MessageEntity> list = messageService.getMessageByPage(query,pageNum,pageSize);
        MessageResult messageResult = new MessageResult();
        if(list!=null)
        {
            messageResult.setStatus(200);
            messageResult.setPageNum(pageNum);
            messageResult.setTotal(list.getTotalElements());
            messageResult.setMessageEntityList(list.toList());
        }
        else
        {
            messageResult.setStatus(500);
        }
        return messageResult;

    }


    @RequestMapping(value = "/deleteMessage/{id}",method = RequestMethod.DELETE)
    @ResponseBody
    public int deletemessage(@PathVariable Long id) {

        return messageService.deleteMessage(id);

    }


}
