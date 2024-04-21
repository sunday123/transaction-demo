package com.ij34.transaction.tcc.b;

import cn.hutool.json.JSONUtil;
import com.ij34.transaction.tcc.b.model.BInfo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Tag(name = "b Controller", description = "b 管理相关API")
@RequestMapping("/b")
public class BController {
    @Autowired
    BInfoService bInfoService;

    @Operation(summary = "updateById")
    @PostMapping("/updateById")
    public boolean updateById(@RequestBody BInfo record) {
         System.out.println("updateById:"+ JSONUtil.toJsonStr(record));
         return bInfoService.updateById(record);
    }

    @Operation(summary = "getBInfo")
    @GetMapping("/getBInfo/{bNo}")
    public BInfo getBInfo(@PathVariable("bNo") String bNo) {
        System.out.println("getBInfo:"+bNo);
        return bInfoService.getById(bNo);
    }
}