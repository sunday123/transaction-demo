package com.ij34.transaction.b.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;


@Data
public class BInfo {

    @TableId(type= IdType.AUTO)
    private Integer id;

    private String title;


    private Integer cId;


}
