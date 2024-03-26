package com.ij34.transaction.a;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ij34.transaction.a.model.AInfo;

public interface AInfoService extends IService<AInfo> {
    Integer add(AInfo record);
}