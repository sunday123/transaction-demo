package com.ij34.transaction.c;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ij34.transaction.c.model.CInfo;

public interface CInfoService extends IService<CInfo> {
    Integer add(CInfo record);
}