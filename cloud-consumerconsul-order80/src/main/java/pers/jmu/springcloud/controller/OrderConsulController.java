package pers.jmu.springcloud.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
public class OrderConsulController {

    public static final String INVOKE_URL = "http://consul-payment-service";
    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/consumer/payment/consul")
    public String paymentInfo() {
        String object = restTemplate.getForObject(INVOKE_URL + "/payment/consul", String.class);
        System.out.println("-----------consumer------------");
        return object;
    }

    @GetMapping(value = "/consumer/gateWay/test1/{id}")
    public String getGateWay(@PathVariable("id") String id) {
        System.out.println("---consumer----gateway--------" + id);
        return id;
    }

}
