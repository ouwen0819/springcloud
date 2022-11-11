package pers.jmu.springcloud.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author mzq
 * @time 11:19
 * @date 2022-11-11-0011
 */
@RestController
public class OrderZKController {

    public static final String INVOKE_URL = "http://cloud-provider-payment";

    @Resource
    private RestTemplate restTemplate;

    @GetMapping(value = "/consumer/payment/zk")
    public String paymentInfo() {
        String restTemplateForObject = restTemplate.getForObject(INVOKE_URL + "/payment/zk", String.class);
        return restTemplateForObject;
    }
}
