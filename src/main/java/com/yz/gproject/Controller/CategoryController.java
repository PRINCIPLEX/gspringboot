package com.yz.gproject.Controller;
import com.yz.gproject.Entity.CategoryEntity;
import com.yz.gproject.Result.CategoryResult;
import com.yz.gproject.Service.CategoryService;
import com.yz.gproject.utils.JwtUtils;
import com.yz.gproject.Result.LoginResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


@Controller
@CrossOrigin

public class CategoryController {

    @Autowired
    public CategoryService categoryService;

    @RequestMapping(value = "/addCategory",method = RequestMethod.POST)
    @ResponseBody
    public int addcategory(@RequestBody CategoryEntity entity){
        return  categoryService.add(entity);
    }

    @RequestMapping(value = "/editCategory/{id}/{name}",method = RequestMethod.GET)
    @ResponseBody
    public int editcategory(@PathVariable Long id,@PathVariable String name){
        int status = categoryService.update(id,name);
        return status;
    }



    @RequestMapping(value = "/editCategory/{id}",method = RequestMethod.DELETE)
    @ResponseBody
    public int deletecategory(@PathVariable Long id) {

        return categoryService.delete(id);

    }


    @RequestMapping(value = "/editCategory/{id}",method = RequestMethod.GET)
    @ResponseBody
    public CategoryEntity editcategory(@PathVariable Long id) {
        return categoryService.getById(id);
    }


    @RequestMapping(value = "/category",method = RequestMethod.GET)
    @ResponseBody
    public CategoryResult show(@RequestParam  Map<String, String> map) {
        String query = map.get("query");
        int pageNum =Integer.parseInt(map.get("pageNum")) -1;
        int pageSize =Integer.parseInt(map.get("pageSize"));
        Page<CategoryEntity> list = categoryService.getCategoryByPage(query,pageNum,pageSize);
        CategoryResult categoryResult = new CategoryResult();
        if(list!=null)
        {
            categoryResult.setStatus(200);
            categoryResult.setPageNum(pageNum);
            categoryResult.setTotal(list.getTotalElements());
            categoryResult.setCategoryEntity(list.toList());
        }
        else
        {
            categoryResult.setStatus(500);
        }
        return categoryResult;
    }

    @RequestMapping(value = "/getcategory",method = RequestMethod.GET)
    @ResponseBody
    public List<CategoryEntity> show() {
        return categoryService.categoryDao.findAll();
    }



}


