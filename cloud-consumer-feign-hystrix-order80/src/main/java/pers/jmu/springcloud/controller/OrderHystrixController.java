package pers.jmu.springcloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import pers.jmu.springcloud.service.PaymentHystrixService;

@RestController
@DefaultProperties(defaultFallback = "payment_Global_FallbackMethod")
public class OrderHystrixController {
    @Autowired
    private PaymentHystrixService paymentHystrixService;

    @GetMapping("/consumer/payment/hystrix/ok/{id}")
    public String paymentInfo_OK(@PathVariable("id") Integer id) {
        String paymentInfo_ok = paymentHystrixService.paymentInfo_OK(id);
        return paymentInfo_ok;
    }

    @GetMapping("/consumer/payment/hystrix/timeout/{id}")
//    @HystrixCommand(fallbackMethod = "paymentInfo_TimeOutFallback", commandProperties = {
//            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1500")
//    })
    @HystrixCommand
    public String paymentInfo_TimeOut(@PathVariable("id") Integer id) {

        int age = 10/0;
        String paymentInfo_timeOut = paymentHystrixService.paymentInfo_TimeOut(id);

        return paymentInfo_timeOut;
    }

    public String paymentInfo_TimeOutFallback(@PathVariable("id") Integer id) {
        return "我是消费者80，对方支付系统繁忙请稍后或者检查自己错误QAQ";
    }

    //全局fallback方法
    public String payment_Global_FallbackMethod(){
        return "Global异常处理，请稍后再试！";
    }


}
