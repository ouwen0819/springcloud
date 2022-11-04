package pers.jmu.springcloud.alibaba.service.impl;

import org.springframework.stereotype.Service;
import pers.jmu.springcloud.alibaba.dao.AccountDao;
import pers.jmu.springcloud.alibaba.service.AccountService;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.concurrent.TimeUnit;

/**
 * @author mzq
 * @time 14:48
 * @date 2022-11-3-0003
 */
@Service
public class AccountServiceImpl implements AccountService {
    @Resource
    AccountDao accountDao;

    /**
     * 扣减账户余额
     */
    @Override
    public void decrease(Long userId, BigDecimal money) {
        System.out.println("------->account-service中扣减账户余额开始");
        //模拟超时异常，全局事务回滚
//        try {
//            TimeUnit.SECONDS.sleep(20);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        accountDao.decrease(userId, money);
        System.out.println("------->account-service中扣减账户余额结束");
    }

}
