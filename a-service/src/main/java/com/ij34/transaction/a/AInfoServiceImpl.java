package com.ij34.transaction.a;

import cn.hutool.core.lang.Assert;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ij34.transaction.a.mapper.AInfoMapper;
import com.ij34.transaction.a.model.AInfo;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Slf4j
@Service
public class AInfoServiceImpl extends ServiceImpl<AInfoMapper, AInfo> implements AInfoService {

    @Autowired
    BRemoteService bRemoteService;

    @Override
    @GlobalTransactional
    public Integer add(AInfo record) {
        log.info("a:"+record);
        if (StrUtil.isBlank(record.getTitle())){
            return -1;
        }
        record.setId(null);

        int bId = bRemoteService.add(record);
        Assert.isTrue(bId>0,"b add error");
        record.setBId(bId);
        return save(record)?0:-1;
    }
}