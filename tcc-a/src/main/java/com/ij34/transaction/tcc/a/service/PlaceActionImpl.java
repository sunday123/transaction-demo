package com.ij34.transaction.tcc.a.service;

/**
 * @Author: ij34
 * @Date: 2024-04-21
 */

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.lang.Assert;
import cn.hutool.core.thread.ThreadUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.ij34.transaction.tcc.a.model.AInfo;
import com.ij34.transaction.tcc.b.model.BInfo;
import io.seata.core.context.RootContext;
import io.seata.rm.tcc.api.BusinessActionContext;
import io.seata.rm.tcc.api.BusinessActionContextParameter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
@Slf4j
@Service
public class PlaceActionImpl implements PlaceAction{

    @Autowired
    private BRemoteService bRemoteService; // 注入BRemoteService
    @Autowired
    private AInfoService aInfoService;

//    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
    public boolean prepare(BusinessActionContext actionContext, @BusinessActionContextParameter(paramName = "bNo") String bNo,
                           @BusinessActionContextParameter(paramName = "orderNo") String orderNo)  {
        BInfo bInfoDto = bRemoteService.getBInfo(bNo); // 调用OpenFeign的get方法获取BInfoDto\

        Assert.notNull(bInfoDto,"BInfoDto is null");
        log.info("bInfoDto:"+bInfoDto);
        Assert.isTrue(bInfoDto.getStatus() == 1,"Invalid status, should be 1");


        //获取事务的id
//        String xid = RootContext.getXID();
//        log.info("事务ID："+xid);
        // 更新BInfoDto的status为2
        bInfoDto.setStatus(2);
        bRemoteService.updateById(bInfoDto);
        Assert.isTrue(aInfoService.count(new LambdaQueryWrapper<AInfo>().eq(AInfo::getBNo,bNo))<1,"存在了bNo");



        // 新增AInfo
        AInfo aInfo = new AInfo();
        aInfo.setBNo(bNo);
        aInfo.setOrderNo(orderNo);
        aInfo.setCreateDate(new Date());
        aInfo.setBNo(bNo);
        boolean isSuccess = aInfoService.save(aInfo); // 保存AInfo到本地数据库，返回操作是否成功


        Assert.isTrue(isSuccess,"Failed to save AInfo");
//        ThreadUtil.sleep(10000);
        return true; // 返回true表示prepare阶段成功

    }

    public boolean confirm(BusinessActionContext actionContext) {
        log.info("confirm"+ DateUtil.now());
//        ThreadUtil.sleep(9000);

        Assert.isFalse(flag-->0,"ex flag");


        // 在confirm阶段，通常不需要额外操作，因为prepare阶段已完成所有事务性工作
        return true;
    }
    static int flag =2;
    public boolean cancel(BusinessActionContext actionContext) {
        log.info("cancel"+ DateUtil.now());
        String bNo = (String) actionContext.getActionContext().get("bNo");
        String orderNo = (String) actionContext.getActionContext().get("orderNo");
        log.info("bNo:"+bNo);
        log.info("orderNo:"+orderNo);
        if (bNo==null){
            return true;
        }
        BInfo bInfoDto = bRemoteService.getBInfo(bNo);
        log.info("bInfoDto:"+bInfoDto);
        if (bInfoDto==null){
            return true;
        }

        if (bInfoDto!=null && bInfoDto.getStatus()==2){
            bInfoDto.setStatus(1);
            Assert.isTrue(bRemoteService.updateById(bInfoDto),"failllll");
        }

        // 在cancel阶段，根据bNo和orderNo回滚prepare阶段的操作，如将BInfoDto的status改回1，删除新增的AInfo
        AInfo aa=aInfoService.getById(orderNo);
        if (aa!=null&& StrUtil.equals(aa.getBNo(),bNo)){
            Assert.isTrue(aInfoService.removeById(orderNo),"orderNo del fail");
        }
        return true; // 返回true表示cancel阶段成功
    }


}