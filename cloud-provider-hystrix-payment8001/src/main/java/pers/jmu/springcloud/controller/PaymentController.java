package pers.jmu.springcloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import pers.jmu.springcloud.service.PaymentService;

@RestController
public class PaymentController {
    @Autowired
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/payment/hystrix/ok/{id}")
    public String paymentInfo_OK(@PathVariable("id") Integer id) {
        String paymentInfo_ok = paymentService.paymentInfo_OK(id);
        System.out.println("result OK:" + paymentInfo_ok);
        return paymentInfo_ok;
    }

    @GetMapping("/payment/hystrix/timeout/{id}")
    public String paymentInfo_TimeOut(@PathVariable("id") Integer id) {
        String paymentInfo_timeOut = paymentService.paymentInfo_TimeOut(id);
        System.out.println("result timeOut:" + paymentInfo_timeOut);
        return paymentInfo_timeOut;
    }

}
