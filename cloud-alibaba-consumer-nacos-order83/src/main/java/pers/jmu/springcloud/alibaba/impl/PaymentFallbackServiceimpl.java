package pers.jmu.springcloud.alibaba.impl;

import org.springframework.stereotype.Component;
import pers.jmu.springcloud.alibaba.service.PaymentService;

/**
 * @author mzq
 * @time 16:35
 * @date 2022-10-20-0020
 */
@Component
public class PaymentFallbackServiceimpl implements PaymentService {
    @Override
    public String paymentSQL(String id) {

        System.out.println("--------PaymentFallbackServiceimpl-----------");
        return "44444444-----服务降级---PaymentFallbackServiceimpl----id:" + id;
    }
}
