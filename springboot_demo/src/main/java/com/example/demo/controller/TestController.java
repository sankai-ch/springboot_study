package com.example.demo.controller;

import com.example.demo.common.core.RestCommonResult;
import com.example.demo.dataobject.TestDO;
import com.example.demo.manager.TestManager;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @author SanKai
 * @since 2019-10-25
 */
@RestController
@Api(value = "API - 测试Swagger")
@RequestMapping("/api")
public class TestController {

    @Autowired
    private TestManager testManager;

    @GetMapping("/find")
    @ApiOperation(value = "查看所有测试类", notes = "可以记录测试类中需要记录的内容")
    public List<TestDO> findAll() {
        return testManager.findAll();
    }

    @PostMapping("/upload")
    @ApiOperation(value = "测试", notes = "可以记录测试类中需要记录的内容")
    public Boolean upload(@RequestParam(required = false) MultipartFile file, @RequestParam("id") Long id) {
        return testManager.upload(id, file);
    }

    @GetMapping("/ddd")
    public RestCommonResult<Boolean> ddd() {
        return new RestCommonResult<>(testManager.ddd());
    }
}
