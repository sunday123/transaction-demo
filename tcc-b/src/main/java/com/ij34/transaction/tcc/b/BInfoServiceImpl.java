package com.ij34.transaction.tcc.b;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ij34.transaction.tcc.b.mapper.BInfoMapper;
import com.ij34.transaction.tcc.b.model.BInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
@Slf4j
@Service
public class BInfoServiceImpl extends ServiceImpl<BInfoMapper, BInfo> implements BInfoService {

}