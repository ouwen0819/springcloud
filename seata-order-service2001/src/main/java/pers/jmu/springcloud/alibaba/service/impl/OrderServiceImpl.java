package pers.jmu.springcloud.alibaba.service.impl;

import io.seata.spring.annotation.GlobalTransactional;
import org.springframework.stereotype.Service;
import pers.jmu.springcloud.alibaba.dao.OrderDao;
import pers.jmu.springcloud.alibaba.domain.Order;
import pers.jmu.springcloud.alibaba.service.AccountService;
import pers.jmu.springcloud.alibaba.service.OrderService;
import pers.jmu.springcloud.alibaba.service.StorageService;

import javax.annotation.Resource;

/**
 * @author mzq
 * @time 13:44
 * @date 2022-10-31-0031
 */
@Service
public class OrderServiceImpl implements OrderService {
    @Resource
    private OrderDao orderDao;
    @Resource
    private AccountService accountService;
    @Resource
    private StorageService storageService;

    @Override
    @GlobalTransactional(name = "xm_create_order", rollbackFor = Exception.class)//name 唯一即可，rollbackFor发生何种异常回滚
    public void create(Order order) {
        System.out.println("--------开始新建订单");
        orderDao.create(order);
        System.out.println("--------订单微服务开始调用库存count做扣减start");
        storageService.decrease(order.getProductId(), order.getCount());
        System.out.println("--------订单微服务开始调用库存做扣减end");

        System.out.println("--------订单微服务开始调用账户money做扣减start");
        accountService.decrease(order.getUserId(), order.getMoney());
        System.out.println("--------订单微服务开始调用账户做扣减end");

        System.out.println("--------修改订单状态start");
        orderDao.update(order.getUserId(), 0);
        System.out.println("--------修改订单状态end");
    }
}
