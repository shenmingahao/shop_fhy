package com.fh.shop_fhy.controller;

import com.fh.shop_fhy.model.Type;
import com.fh.shop_fhy.service.TypeService;
import com.fh.shop_fhy.vo.ReponseData;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@CrossOrigin
@RequestMapping("api/type")
public class TypeController {
    @Resource
    private TypeService typeService;

    //查询
    @GetMapping("getData")
    public ReponseData getData(){
        return ReponseData.success(typeService.getData());
    }

    //根据pid查询
    @GetMapping("getDataByPid")
    public ReponseData getDataByPid(Integer pid){
        if (pid == null){
            return ReponseData.error("必须传pid");
        }
        return ReponseData.success(typeService.getDataByPid(pid));
    }

    //新增
    @PostMapping("add")
    public ReponseData add(Type type){
        if (type.getName() == null || type.getPid() == null){
            return ReponseData.error("数据不能为空");
        }
        return ReponseData.success(typeService.add(type));
    }

    //修改
    @PostMapping("update")
    public ReponseData update(Type type){
        if (type.getId() == null){
            return ReponseData.error("id不能为空");
        }
        return ReponseData.success(typeService.update(type));
    }
}
