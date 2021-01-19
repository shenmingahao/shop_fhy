package com.fh.shop_fhy.service;

import com.fh.shop_fhy.model.Attribute;
import com.fh.shop_fhy.vo.AttributeParams;

public interface AttributeService {
    Object queryAttribute(AttributeParams params);

    Object addAttribute(Attribute attribute);

    Object huixian(Integer id);

    Object updateAttribute(Attribute attribute);

    Object deleteAttribute(Integer id);

    Object queryAttrByTypeId(Integer typeId);
}
