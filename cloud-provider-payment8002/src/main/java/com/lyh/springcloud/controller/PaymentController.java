package com.lyh.springcloud.controller;

import com.lyh.springcloud.entities.CommonResult;
import com.lyh.springcloud.entities.Payment;
import com.lyh.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@Slf4j
@RequestMapping(value = "/payment")
public class PaymentController {
    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @PostMapping(value = "/create")
    public CommonResult create(@RequestBody Payment payment) {
        int result = paymentService.create(payment);
        log.info("***结果" + result);
        if (result > 0) {
            return new CommonResult(200, "插入数据成功,serverPort=" + serverPort, result);
        }
        return new CommonResult(444, "失败", null);

    }

    @GetMapping(value = "/get/{id}")
    public CommonResult get(@PathVariable("id") Long id) {
        Payment payment = paymentService.getPaymentById(id);
        log.info("***结果" + payment);
        if (payment != null) {
            return new CommonResult(200, "查询成功,serverPort:" + serverPort, payment);
        }
        return new CommonResult(444, "没有记录ID:" + id, null);
    }

    @GetMapping(value = "/lb")
    public String getPaymentLB(){
        return serverPort;
    }
}
