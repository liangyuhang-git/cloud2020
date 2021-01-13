package com.lyh.springcloud.service;

import org.springframework.stereotype.Component;

@Component
public class PaymentFallbackService  implements PaymentHystrixService {
    @Override
    public String paymentInfo_TimeOut(Integer id) {
        return "------PaymentFallbackService fall back-paymentInfo_TimeOut , 0(-_-)0!";
    }

    @Override
    public String paymentInfo_OK(Integer id) {
        return "------PaymentFallbackService fall back-paymentInfo_OK , 0(-_-)0!";
    }

}
