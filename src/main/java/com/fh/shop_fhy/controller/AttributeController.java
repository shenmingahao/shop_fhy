package com.fh.shop_fhy.controller;

import com.fh.shop_fhy.service.AttributeService;
import com.fh.shop_fhy.vo.AttributeParams;
import com.fh.shop_fhy.vo.ReponseData;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
