package com.lyh.springcloud.controller;

import com.lyh.springcloud.entities.CommonResult;
import com.lyh.springcloud.entities.Payment;
import com.lyh.springcloud.service.PaymentFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Slf4j
public class OrderFeignController {
    @Resource
    private PaymentFeignService paymentFeignService;

    @GetMapping(value = "/consumer/payment/get/{id}")
    public CommonResult<Payment> getPayment(@PathVariable("id") Long id){
        return paymentFeignService.get(id);
    }

    @GetMapping(value = "/consumer/payment/timeout")
    public String paymentFeignTimeout(){
        //openfeign-ribbon 客户端默认等待1s 过时报错
        return paymentFeignService.paymentFeignTimeout();
    }
}
