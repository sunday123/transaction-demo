package com.ij34.transaction.a;

import com.ij34.transaction.a.model.AInfo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Tag(name = "a Controller", description = "a管理相关API")
@RequestMapping("/a")
public class AController {
    @Autowired
    AInfoService aInfoService;


    @Operation(summary = "add")
    @PostMapping("/add")
    public Integer add(@RequestBody AInfo record) {

        return aInfoService.add(record);

    }
}