package pers.jmu.springcloud.alibaba.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import pers.jmu.springcloud.alibaba.service.PaymentService;

import javax.annotation.Resource;

/**
 * @author mzq
 * @time 13:56
 * @date 2022-10-20-0020
 */
@RestController
public class CircleBreakerController {

    public static final String SERVICE_URL = "http://nacos-payment-provider";

    @Resource
    private RestTemplate restTemplate;

    @Resource
    private PaymentService paymentService;

    @GetMapping("/consumer/fallback/{id}")
    //@SentinelResource(value = "fallback")
    //@SentinelResource(value = "fallback", fallback = "handlerFallback")//fallback 业务异常
    //@SentinelResource(value = "fallback", blockHandler = "blockHandler")//blockhandler sentinel配置台配置违规
    //@SentinelResource(value = "fallback", blockHandler = "blockHandler", fallback = "handlerFallback", exceptionsToIgnore = IllegalArgumentException.class)//特定异常不处理
    @SentinelResource(value = "fallback", blockHandler = "blockHandler", fallback = "handlerFallback")//两个都配，blockhandler优先
    public String fallback(@PathVariable String id) {

        String forObject = restTemplate.getForObject(SERVICE_URL + "/paymentRibbon/" + id, String.class, id);
        if (id.equals("2")) {
            throw new IllegalArgumentException("不合法参数异常。。。");
        } else if (id.equals("3")) {
            throw new NullPointerException("空指针异常了。。。");
        }
        System.out.println("-----------/consumer/fallback/--------------");
        return forObject;
    }

    public String handlerFallback(@PathVariable String id, Throwable throwable) {
        return "444兜底异常handlerfallback，exception内容" + throwable.getMessage() + "id:-----" + id;
    }

    public String blockHandler(@PathVariable String id, BlockException blockException) {
        return "445---blockHandler-sentinel限流，无此流水。blockException：----" + blockException.getMessage() + "--------id:" + id;
    }

    @GetMapping("/consumer/paymentRibbon/{id}")
    public String paymentSQL(@PathVariable String id) {
        return paymentService.paymentSQL(id);
    }

}