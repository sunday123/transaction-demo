package com.ij34.transaction.c.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.experimental.Accessors;


@Data
@Accessors(chain = true)
public class CInfo {

    @TableId(type= IdType.AUTO)
    private Integer id;

    private String title;


}
