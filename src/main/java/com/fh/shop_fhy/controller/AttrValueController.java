package com.fh.shop_fhy.controller;

import com.fh.shop_fhy.model.AttrValue;
import com.fh.shop_fhy.service.AttrValueService;
import com.fh.shop_fhy.vo.ReponseData;
import org.apache.http.protocol.ResponseDate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@CrossOrigin
@RequestMapping("api/attrValue")
public class AttrValueController {
    @Resource
    private AttrValueService attrValueService;

    //查询
    @PostMapping("queryAttrValue")
    public ReponseData queryAttrValue(Integer attrId){
        if (attrId == null){
            return ReponseData.error("attrId不能为空");
        }
        return ReponseData.success(attrValueService.queryAttrValue(attrId));
    }

    //新增
    @PostMapping("addAttrValue")
    public ReponseData addAttrValue(AttrValue attrValue){
        if (attrValue == null){
            return ReponseData.error("数据不能为空");
        }
        return ReponseData.success(attrValueService.addAttrValue(attrValue));
    }

}
