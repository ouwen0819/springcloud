package pers.jmu.springcloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import pers.jmu.springcloud.entities.Person;

@Component
@FeignClient(value = "CLOUD-PAYMENT-SERVICE")
public interface PaymentFeignService {
    @GetMapping(value = "/payment/getPerson/{classCn}")
    Person getPerson(@PathVariable("classCn") String classCn);

    @GetMapping(value = "/payment/fegin/timeout")
    public String paymentFeignTimeout();
}
