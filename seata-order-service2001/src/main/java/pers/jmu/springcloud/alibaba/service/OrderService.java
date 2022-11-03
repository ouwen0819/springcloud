package pers.jmu.springcloud.alibaba.service;

import pers.jmu.springcloud.alibaba.domain.Order;

/**
 * @author mzq
 * @time 13:43
 * @date 2022-10-31-0031
 */
public interface OrderService {
    void create(Order order);
}
