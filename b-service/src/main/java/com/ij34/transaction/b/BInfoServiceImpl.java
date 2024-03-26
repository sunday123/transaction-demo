package com.ij34.transaction.b;

import cn.hutool.core.lang.Assert;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ij34.transaction.b.mapper.BInfoMapper;
import com.ij34.transaction.b.model.BInfo;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Slf4j
@Service
public class BInfoServiceImpl extends ServiceImpl<BInfoMapper, BInfo> implements BInfoService {
    @Autowired
    CRemoteService cRemoteService;


    @Override
//    @GlobalTransactional
    public Integer add(BInfo record) {
        log.info("b:"+record);
        if (StrUtil.isBlank(record.getTitle())){
            return -1;
        }



        record.setId(null);
        int cId = cRemoteService.add(record);
        record.setCId(cId);
//        cId=0;
        Assert.isTrue(cId>0, "cId<0");
        return save(record)?record.getId():-1;
    }
}