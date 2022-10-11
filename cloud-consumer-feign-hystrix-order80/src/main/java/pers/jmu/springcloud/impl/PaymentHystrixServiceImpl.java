package pers.jmu.springcloud.impl;

import pers.jmu.springcloud.service.PaymentHystrixService;

public class PaymentHystrixServiceImpl implements PaymentHystrixService {
    @Override
    public String paymentInfo_OK(Integer id) {
        return null;
    }

    @Override
    public String paymentInfo_TimeOut(Integer id) {
        return null;
    }
}
