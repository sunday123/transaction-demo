package com.ij34.transaction.tcc.b.model;

import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;


@Data
public class BInfo {
    @JsonProperty("bNo")
    @TableId
    private String bNo;

    private String title;


    private Integer status;


}
