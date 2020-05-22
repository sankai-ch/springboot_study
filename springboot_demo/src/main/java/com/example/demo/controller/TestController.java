package com.example.demo.controller;

import com.example.demo.entity.SaleGoods;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;

/**
 * @author SanKai
 * @since 2019-10-25
 */
@RestController
@Api(value = "API - 测试Swagger")
public class TestController {

    @RequestMapping(value = "/get/httpmessageconverter", method = RequestMethod.GET)
    public SaleGoods httpMessageConverterTest() {
        SaleGoods saleGoods = new SaleGoods();
        saleGoods.setGoodsName("华为手机");
        saleGoods.setId(1);
        saleGoods.setOnSale(true);
        saleGoods.setType(1);
        saleGoods.setWeight(300);
        return saleGoods;
    }

    @RequestMapping(value = "/test/httpmessageconverter", method = RequestMethod.POST)
    @ResponseBody
    public SaleGoods httpMessageConverterTest2(@RequestBody SaleGoods saleGoods) {
        System.out.println(saleGoods.toString());
        saleGoods.setType(saleGoods.getType() + 1);
        saleGoods.setGoodsName("商品名：" + saleGoods.getGoodsName());
        return saleGoods;
    }
}
