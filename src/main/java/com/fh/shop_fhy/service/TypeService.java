package com.fh.shop_fhy.service;

import com.fh.shop_fhy.model.Type;

public interface TypeService {
    Object getData();

    Object getDataByPid(Integer pid);

    Object add(Type type);

    Object update(Type type);
}
