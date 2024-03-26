package com.ij34.transaction.b;

import com.ij34.transaction.b.model.BInfo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Tag(name = "b Controller", description = "b 管理相关API")
@RequestMapping("/b")
public class BController {
    @Autowired
    BInfoService bInfoService;

    @Operation(summary = "add")
    @PostMapping("/add")
    public Integer add(@RequestBody BInfo record) {
         return bInfoService.add(record);
    }
}