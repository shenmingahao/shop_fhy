package com.fh.shop_fhy.service;

import com.fh.shop_fhy.model.Brand;
import com.fh.shop_fhy.vo.BrandParams;
import com.fh.shop_fhy.vo.PageResult;
import com.fh.shop_fhy.vo.ReponseData;

public interface BrandService {
    ReponseData queryBrand(BrandParams params);

    Object addBrand(Brand brand);

    Object huixian(Integer id);

    Object updateBrand(Brand brand);

    Object deleteBrand(Integer id);
}
