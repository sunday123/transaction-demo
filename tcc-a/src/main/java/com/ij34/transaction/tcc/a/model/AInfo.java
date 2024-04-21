package com.ij34.transaction.tcc.a.model;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.util.Date;


@Data
public class AInfo {

    @TableId
    private String orderNo;

    private Date createDate;


    private String bNo;


}
