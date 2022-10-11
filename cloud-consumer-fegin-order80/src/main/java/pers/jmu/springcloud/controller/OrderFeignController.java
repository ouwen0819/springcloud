package pers.jmu.springcloud.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import pers.jmu.springcloud.entities.Person;
import pers.jmu.springcloud.service.PaymentFeignService;

import javax.annotation.Resource;

@RestController
public class OrderFeignController {

    @Resource
    private PaymentFeignService paymentFeignService;

    @GetMapping(value = "/consumer/payment/getPerson/{classCn}")
    public Person getPaymentById(@PathVariable("classCn") String classCn) {
        System.out.println("-----------feign---consumer-----");
        return paymentFeignService.getPerson(classCn);
    }

    @GetMapping(value = "/consumer/payment/fegin/timeout")
    public String paymentFeignTimeout(){

        return paymentFeignService.paymentFeignTimeout();
    }

}
