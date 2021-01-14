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
}
