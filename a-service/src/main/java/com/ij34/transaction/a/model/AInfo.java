package com.ij34.transaction.a.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;


@Data
public class AInfo {

    @TableId(type= IdType.AUTO)
    private Integer id;

    private String title;


    private Integer bId;


}
