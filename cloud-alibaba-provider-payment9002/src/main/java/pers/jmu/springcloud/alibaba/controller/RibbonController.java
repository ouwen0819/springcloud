package pers.jmu.springcloud.alibaba.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author mzq
 * @time 13:44
 * @date 2022-10-20-0020
 */
@RestController
public class RibbonController {

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/paymentRibbon/{id}")
    public String getServerPort(@PathVariable("id") String id) {

        return "id:" + id + "------------serverPort:" + serverPort;
    }

}
