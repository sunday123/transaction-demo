package com.ij34.transaction.tcc.a.service;

import com.ij34.transaction.tcc.b.model.BInfo;
import feign.Param;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(value = "tcc-b",path = "/b")
public interface BRemoteService {


    @PostMapping("/updateById")
    public boolean updateById(@RequestBody BInfo record);

    @GetMapping("/getBInfo/{bNo}")
    public BInfo getBInfo(@PathVariable("bNo") String bNo);
}
