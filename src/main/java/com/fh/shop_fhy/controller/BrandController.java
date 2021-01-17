package com.fh.shop_fhy.controller;

import com.fh.shop_fhy.model.Brand;
import com.fh.shop_fhy.service.BrandService;
import com.fh.shop_fhy.utils.OssFile;
import com.fh.shop_fhy.vo.BrandParams;
import com.fh.shop_fhy.vo.PageResult;
import com.fh.shop_fhy.vo.ReponseData;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
@CrossOrigin
@RequestMapping("api/brand")
public class BrandController {
    @Resource
    private BrandService brandService;
    @Resource
    private HttpServletRequest request;

    //查询
    @PostMapping("queryBrand")
    public ReponseData queryBrand(BrandParams params){
        if (params.getPage() == null){
            return ReponseData.error("page或limit不能为空");
        }
        if (params.getLimit() == null){
            return ReponseData.error("page或limit不能为空");
        }
        return brandService.queryBrand(params);
    }

    //新增
    @PostMapping("addBrand")
    public ReponseData addBrand(Brand brand){
        if (brand == null){
            return ReponseData.error("数据不能为空");
        }
        return ReponseData.success(brandService.addBrand(brand));
    }

    //回显
    @PostMapping("huixian")
    public ReponseData huixian(Integer id){
        if (id == null){
            return ReponseData.error("id不能为空");
        }
        return ReponseData.success(brandService.huixian(id));
    }

    //修改
    @PostMapping("updateBrand")
    public ReponseData updateBrand(Brand brand){
        if (brand == null){
            return ReponseData.error("数据不能为空");
        }
        return ReponseData.success(brandService.updateBrand(brand));
    }

    //删除
    @PostMapping("deleteBrand")
    public ReponseData deleteBrand(Integer id){
        if (id == null){
            return ReponseData.error("id不能为空");
        }
        return ReponseData.success(brandService.deleteBrand(id));
    }

    //上传照片
    @PostMapping("uploadFile")
    public Map<String , Object> upload(MultipartFile img) throws IOException {
        //处理新名称
        String originalFilename = img.getOriginalFilename();
        //防止中文引起的错误
        String newName= UUID.randomUUID().toString()+originalFilename.substring(originalFilename.lastIndexOf("."));
        //存储路径
        newName="images/"+newName;
        Map map = new HashMap();
        map.put("filePath" , OssFile.uploadFile(img.getInputStream(),newName));
        return map;
    }
}
