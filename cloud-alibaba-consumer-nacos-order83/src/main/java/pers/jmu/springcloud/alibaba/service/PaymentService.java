package pers.jmu.springcloud.alibaba.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import pers.jmu.springcloud.alibaba.impl.PaymentFallbackServiceimpl;

/**
 * @author mzq
 * @time 16:29
 * @date 2022-10-20-0020
 */
@FeignClient(value = "nacos-payment-provider", fallback = PaymentFallbackServiceimpl.class)
public interface PaymentService {

    @GetMapping("/paymentRibbon/{id}")
    public String paymentSQL(@PathVariable("id") String id);
}
