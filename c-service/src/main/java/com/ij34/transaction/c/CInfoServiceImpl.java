package com.ij34.transaction.c;


import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ij34.transaction.c.mapper.CInfoMapper;
import com.ij34.transaction.c.model.CInfo;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
@Slf4j
@Service
public class CInfoServiceImpl extends ServiceImpl<CInfoMapper, CInfo> implements CInfoService {
    @Override
//    @GlobalTransactional
    public Integer add(CInfo record) {
        log.info("c:"+record);
        if (StrUtil.isBlank(record.getTitle())){
            return -1;
        }
        record.setId(null);
        return save(record)?0:-1; // 模拟异常
//        return save(record)?record.getId():-1;
    }
}