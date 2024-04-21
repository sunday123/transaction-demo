package com.ij34.transaction.tcc.a;

import com.ij34.transaction.tcc.a.api.Response;
import com.ij34.transaction.tcc.a.service.AAInfoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Tag(name = "a Controller", description = "a管理相关API")
@RequestMapping("/a")
public class AController {
    @Autowired
    AAInfoService aaInfoService;

    @Operation(summary = "setBNo")
    @GetMapping("/addB")
    public Response addB(String bNo) {
        return aaInfoService.addB(bNo);

    }
}