package com.yz.gproject.Controller;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.yz.gproject.Entity.AddressListEntity;
import com.yz.gproject.Entity.CategoryEntity;
import com.yz.gproject.Result.AddressListResult;
import com.yz.gproject.Result.CategoryResult;
import com.yz.gproject.Service.AddressListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
@CrossOrigin
public class AddressListController {
    @Autowired
    AddressListService addressListService;


    @RequestMapping(value = "/addtxl")
    @ResponseBody
    public int addtxl(@RequestParam Map<String, String> map) {
        String txl = map.get("txl");
        Gson gson = new Gson();
        List<AddressListEntity>addressListEntityList = gson.fromJson(txl,new TypeToken<List<AddressListEntity>>(){}.getType());
        return addressListService.addAddressList(addressListEntityList);
    }

    @RequestMapping(value = "/Addresslist",method = RequestMethod.GET)
    @ResponseBody
    public AddressListResult show(@RequestParam  Map<String, String> map) {
        String query = map.get("query");
        int pageNum =Integer.parseInt(map.get("pageNum")) -1;
        int pageSize =Integer.parseInt(map.get("pageSize"));
        Page<AddressListEntity> list = addressListService.getAddressListByPage(query,pageNum,pageSize);
        AddressListResult addressListResult = new AddressListResult();
        if(list!=null)
        {
            addressListResult.setStatus(200);
            addressListResult.setPageNum(pageNum);
            addressListResult.setTotal(list.getTotalElements());
            addressListResult.setAddressListEntityList(list.toList());
        }
        else
        {
            addressListResult.setStatus(500);
        }
        return addressListResult;

    }


    @RequestMapping(value = "/deleteAddress/{id}",method = RequestMethod.DELETE)
    @ResponseBody
    public int deleteaddress(@PathVariable Long id) {

        return addressListService.deleteAddress(id);

    }




}
