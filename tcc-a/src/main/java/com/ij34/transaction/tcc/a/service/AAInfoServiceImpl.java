package com.ij34.transaction.tcc.a.service;

import cn.hutool.core.lang.Assert;
import cn.hutool.core.map.MapUtil;
import cn.hutool.core.util.RandomUtil;
import com.ij34.transaction.tcc.a.api.Response;
import io.seata.core.context.RootContext;
import io.seata.rm.tcc.api.BusinessActionContext;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: ij34
 * @Date: 2024-04-21
 */
@Slf4j
@Service
public class AAInfoServiceImpl implements AAInfoService{
    @Autowired
    PlaceAction placeAction;

    @Override
    @GlobalTransactional(timeoutMills = 8000)
    public Response addB(String bNo) {
        Assert.notBlank(bNo,"bNo empty");
        String orderNo = RandomUtil.randomStringUpper(32);
        log.info("bNo:{}|orderNo:{}",bNo,orderNo);

        placeAction.prepare(null,bNo,orderNo);
        return Response.success(true);
    }

}
