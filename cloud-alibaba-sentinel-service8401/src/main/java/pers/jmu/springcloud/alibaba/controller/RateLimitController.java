package pers.jmu.springcloud.alibaba.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pers.jmu.springcloud.alibaba.myHandler.CustomerBlockHandler;

/**
 * @author mzq
 * @time 10:21
 * @date 2022-10-20-0020
 */
@RestController
public class RateLimitController {

    @GetMapping("/byResource")
    @SentinelResource(value = "byResource", blockHandler = "handlerException")//blockhandler是配置违规
    public String byResource() {

        return "200---按资源名称限流测试ok";
    }

    public String handlerException(BlockException blockException) {
        return "500" + blockException.getClass().getCanonicalName() + "服务不可用";
    }


    @GetMapping("/rateLimit/byUrl")
    @SentinelResource(value = "byUrl")
    public String byUrl() {
        return "200 按url限流测试成功";
    }

    @GetMapping("/rateLimit/customerBlockHandler")
    @SentinelResource(value = "customerBlockHandler", blockHandlerClass = CustomerBlockHandler.class, blockHandler = "handlerException2")
    public String customerBlockHandler() {
        return "200 按客户自定义";
    }

}
