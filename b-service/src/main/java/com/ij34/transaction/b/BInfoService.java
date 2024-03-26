package com.ij34.transaction.b;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ij34.transaction.b.model.BInfo;

public interface BInfoService extends IService<BInfo> {
    Integer add(BInfo record);
}