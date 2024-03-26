package com.ij34.transaction.a;

import com.ij34.transaction.a.model.AInfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(value = "b-service",path = "/b")
public interface BRemoteService {
    @PostMapping("/add")
    public Integer add(@RequestBody AInfo record);
}
