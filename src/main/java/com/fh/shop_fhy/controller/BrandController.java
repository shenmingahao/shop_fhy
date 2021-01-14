package com.fh.shop_fhy.controller;

import com.fh.shop_fhy.model.Brand;
import com.fh.shop_fhy.service.BrandService;
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
    /*
    *
    * 123
    *
    * */
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
        Map<String , Object> map = new HashMap<String , Object>();
        //将文件保存到 服务器的指定目录下
        //获取项目的绝对路径
        String realPath = request.getServletContext().getRealPath("/");
        //java里面 file是操作文件或者文件夹的
        String imgPath = realPath+"imgs/";
        //先操作文件或者文件夹的操作对象
        File f = new File(imgPath);
        //判断文件夹是否存在
        boolean exists = f.exists();
        //如果不存在
        if (exists == false) {
            //创建文件夹  mkdirs是创建多层文件夹
            //mkdir是创建单层文件夹  相比使用mkdirs 比 mkdir 好点
            f.mkdirs();
        }
        //获取文件的名称
        String fileName = img.getOriginalFilename();

        //文件的后缀
        String fileLast = fileName.substring(fileName.lastIndexOf("."));
        //生成新的名称
        String fileNewName = UUID.randomUUID().toString()+fileLast;
        //拷贝文件
        //创建输出流
        FileOutputStream os = new FileOutputStream(new File(imgPath+"/"+fileNewName));
        //获取文件的输入流
        FileInputStream is = (FileInputStream) img.getInputStream();
        //设置一次读取的大小
        byte[] bts = new byte[1024*2];
        //通过while循环读取 直到读完
        while (is.read(bts) != -1) {
            os.write(bts);
        }
        //释放资源 由内到外 关流
        is.close();
        os.close();
        //返回
        map.put("filePath", "http://localhost:8080/imgs/"+fileNewName);
        return map;
    }
}
