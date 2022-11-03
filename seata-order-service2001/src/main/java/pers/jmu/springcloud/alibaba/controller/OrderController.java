package pers.jmu.springcloud.alibaba.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pers.jmu.springcloud.alibaba.domain.Order;
import pers.jmu.springcloud.alibaba.service.OrderService;

import javax.annotation.Resource;

/**
 * @author mzq
 * @time 14:09
 * @date 2022-10-31-0031
 */
@RestController
public class OrderController {
    @Resource
    private OrderService orderService;

    @GetMapping("/order/create")
    public String create(Order order) {
        orderService.create(order);
        return "200---订单创建成功";
    }

}
