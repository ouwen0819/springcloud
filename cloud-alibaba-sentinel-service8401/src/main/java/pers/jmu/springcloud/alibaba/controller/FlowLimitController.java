package pers.jmu.springcloud.alibaba.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

@RestController
public class FlowLimitController {

    @GetMapping("/testA")
    public String testA() {
        return "-----------testA";
    }

    @GetMapping("/testB")
    public String testB() {

        System.out.println(LocalDateTime.now() + "******" + Thread.currentThread().getName() + "--------testB");
        return "-----------testB";
    }

    @GetMapping("/testC")
    public String testC() {

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("testC,测试RT");
        return "-----------testC";
    }

    @GetMapping("/testD")
    public String testD() {
        System.out.println("testD,测试异常比例");
        int a = 10 / 0;
        return "-----------testD";
    }

    @GetMapping("/testE")
    public String testE() {
        System.out.println("testE,测试异常数");
        int a = 10 / 0;
        return "-----------testE";
    }

    @GetMapping("/testhotkey")
    @SentinelResource(value = "testhotkey", blockHandler = "deal_testhotkey") //资源名   兜底方法
    public String testHotKey(@RequestParam(value = "p1", required = false) String p1, @RequestParam(value = "p2", required = false) String p2) {

        return "-------testhotkey";
    }

    public String deal_testhotkey(String p1, String p2, BlockException blockException) {
        //sentinel 默认提示 Blocked by Sentinel (flow limiting)
        return "----------deal_testhotkey";
    }

}
