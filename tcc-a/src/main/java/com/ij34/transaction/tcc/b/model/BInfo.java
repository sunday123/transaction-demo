package com.ij34.transaction.tcc.b.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Date;


@Data
public class BInfo {
    @JsonProperty("bNo")
    private String bNo;

    private String title;


    private Integer status;


}