package com.fh.shop_fhy.service;

import com.fh.shop_fhy.model.AttrValue;

public interface AttrValueService {
    Object queryAttrValue(Integer attrId);

    Object addAttrValue(AttrValue attrValue);

    Object huixian(Integer id);
}
