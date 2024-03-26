package com.ij34.transaction.c;

import com.ij34.transaction.c.model.CInfo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Tag(name = "c Controller", description = "c管理相关API")
@RequestMapping("/c")
@Slf4j
public class CController {
    @Autowired
    CInfoService cInfoService;
    @Operation(summary = "add")
    @PostMapping("/add")
    public Integer add(@RequestBody CInfo record) {
        return cInfoService.add(record);
    }
}