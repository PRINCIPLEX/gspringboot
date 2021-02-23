package com.yz.gproject.Controller;

import com.google.gson.Gson;
import com.yz.gproject.Android.ProductListEntity;
import com.yz.gproject.Entity.CategoryEntity;
import com.yz.gproject.Entity.GoodsAndCategoryEntity;
import com.yz.gproject.Entity.GoodsEntity;
import com.yz.gproject.Entity.OrderEntity;
import com.yz.gproject.Result.GoodsResult;
import com.yz.gproject.Service.GoodsService;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.AbstractMap;
import java.util.List;
import java.util.Map;

@Controller
@CrossOrigin
public class GoodsController {
    
    @Autowired
    GoodsService goodsService;





    @RequestMapping("agoods")
    @ResponseBody
    public String AndroidGoods()
    {
        List<ProductListEntity> goods = goodsService.getAndroidGood();
        Gson gson = new Gson();
        return gson.toJson(goods);
    }

    @RequestMapping(value = "/goods",method = RequestMethod.GET)
    @ResponseBody
    public GoodsResult show(@RequestParam Map<String, String> map) {
        String query = map.get("query");
        String categoryValue = map.get("categoryValue");
        int pageNum =Integer.parseInt(map.get("pageNum")) -1;
        int pageSize =Integer.parseInt(map.get("pageSize"));
        Page<GoodsAndCategoryEntity> list = goodsService.getGoodsByPage(categoryValue,query,pageNum,pageSize);
        GoodsResult goodsResult = new GoodsResult();
        if(list!=null)
        {
            goodsResult.setStatus(200);
            goodsResult.setPageNum(pageNum);
            goodsResult.setTotal(list.getTotalElements());
            goodsResult.setGoodsEntity(list.toList());
        }
        else
        {
            goodsResult.setStatus(500);
        }
        return goodsResult;
    }

    @RequestMapping(value = "/addGoods",method = RequestMethod.POST)
    @ResponseBody
    public int addGoods(@RequestParam(name="file",required=false) MultipartFile file,GoodsEntity entity) throws IOException {
        entity.setImg(file.getBytes());
        goodsService.add(entity);
        return 200;
    }

    @RequestMapping(value = "/editGoods/{id}",method = RequestMethod.GET)
    @ResponseBody
    public GoodsEntity editgoods(@PathVariable Long id) {
        return goodsService.getById(id);
    }

    @RequestMapping(value = "/editgood",method = RequestMethod.POST)
    @ResponseBody
    public int editgood(@RequestBody GoodsEntity entity) {
        return goodsService.add(entity);
    }

    @RequestMapping(value = "/delete/{id}",method = RequestMethod.DELETE)
    @ResponseBody
    public int deletecategory(@PathVariable Long id) {

        return goodsService.deleteById(id);

    }





}
