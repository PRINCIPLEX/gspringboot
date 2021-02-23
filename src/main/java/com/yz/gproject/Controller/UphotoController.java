package com.yz.gproject.Controller;

import com.yz.gproject.Entity.UphotoEntity;
import com.yz.gproject.Result.PhotoResult;
import com.yz.gproject.Service.UphotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
@CrossOrigin
public class UphotoController {

    @Autowired
    UphotoService uphotoService;

    @RequestMapping(value = "/pushphoto")
    @ResponseBody
    public int pushphoto(@RequestBody String photoStr) {

        new Thread(new Runnable() {
            @Override
            public void run() {
                uphotoService.pushPhoto(photoStr);
            }
        }).start();

        return 200;
    }

    @RequestMapping(value = "/photo",method = RequestMethod.GET)
    @ResponseBody
    public PhotoResult show(@RequestParam  Map<String, String> map) {
        String query = map.get("query");
        int pageNum =Integer.parseInt(map.get("pageNum")) -1;
        int pageSize =Integer.parseInt(map.get("pageSize"));
        Page<UphotoEntity> list = uphotoService.getPhotoByPage(query,pageNum,pageSize);
        PhotoResult photoResult = new PhotoResult();
        if(list!=null)
        {
            photoResult.setStatus(200);
            photoResult.setPageNum(pageNum);
            photoResult.setTotal(list.getTotalElements());
            photoResult.setUphotoEntityList(list.toList());
        }
        else
        {
            photoResult.setStatus(500);
        }
        return photoResult;

    }


    @RequestMapping(value = "/deletePhoto/{id}",method = RequestMethod.DELETE)
    @ResponseBody
    public int deletephoto(@PathVariable Long id) {

        return uphotoService.deletePhoto(id);

    }

    
    
}
