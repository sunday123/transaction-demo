package com.ij34.transaction.b;

import com.ij34.transaction.b.model.BInfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(value = "c-service",path = "/c")
public interface CRemoteService {
    @PostMapping("/add")
    public Integer add(@RequestBody BInfo record) ;
}
