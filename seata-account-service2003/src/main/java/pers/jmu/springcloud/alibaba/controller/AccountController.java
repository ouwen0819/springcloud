package pers.jmu.springcloud.alibaba.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pers.jmu.springcloud.alibaba.service.AccountService;

import javax.annotation.Resource;
import java.math.BigDecimal;

/**
 * @author mzq
 * @time 14:51
 * @date 2022-11-3-0003
 */
@RestController
public class AccountController {
    @Resource
    AccountService accountService;

    /**
     * 扣减账户余额
     */
    @RequestMapping("/account/decrease")
    public String decrease(@RequestParam("userId") Long userId, @RequestParam("money") BigDecimal money) {
        accountService.decrease(userId, money);
        return "200--------扣减账户余额成功！";
    }
}
