package com.fh.shop_fhy.controller;

import com.fh.shop_fhy.model.Attribute;
import com.fh.shop_fhy.service.AttributeService;
import com.fh.shop_fhy.vo.AttributeParams;
import com.fh.shop_fhy.vo.ReponseData;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@CrossOrigin
@RequestMapping("api/attribute")
public class AttributeController {
    @Resource
    private AttributeService attributeService;

    //查询
    @GetMapping("queryAttribute")
    public ReponseData queryAttribute(AttributeParams params){
        if (params.getPage() == null){
            return ReponseData.error("page和limit不能为空");
        }
        if (params.getLimit() == null){
            return ReponseData.error("page和limit不能为空");
        }
        return ReponseData.success(attributeService.queryAttribute(params));
    }

    //新增
    @PostMapping("addAttribute")
    public ReponseData addAttribute(Attribute attribute){
        if (attribute == null){
            return ReponseData.error("数据不能为空");
        }
        return ReponseData.success(attributeService.addAttribute(attribute));
    }

    //回显
    @PostMapping("huixian")
    public ReponseData huixian(Integer id){
        if (id == null){
            return ReponseData.error("id不能为空");
        }
        return ReponseData.success(attributeService.huixian(id));
    }

    //修改
    @PostMapping("updateAttribute")
    public ReponseData updateAttribute(Attribute attribute){
        if (attribute == null){
            return ReponseData.error("数据不能为空");
        }
        return ReponseData.success(attributeService.updateAttribute(attribute));
    }

    //删除
    @PostMapping("deleteAttribute")
    public ReponseData deleteAttribute(Integer id){
        if (id == null){
            return ReponseData.error("id不能为空");
        }
        return ReponseData.success(attributeService.deleteAttribute(id));
    }

    //根据typeId查询所有数据
    @PostMapping("queryAttrByTypeId")
    public ReponseData queryAttrByTypeId(Integer typeId){
        if (typeId == null){
            return ReponseData.error("typeId不能为空");
        }
        return ReponseData.success(attributeService.queryAttrByTypeId(typeId));
    }
}
