package com.lyh.springcloud.service;

import com.lyh.springcloud.entities.CommonResult;
import com.lyh.springcloud.entities.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "CLOUD-PAYMENT-SERVICE")
public interface PaymentFeignService {

    @GetMapping(value = "/payment/get/{id}")
    public CommonResult<Payment> get(@PathVariable("id") Long id);

    @GetMapping(value = "/payment/timeout")
    public String paymentFeignTimeout();
}
