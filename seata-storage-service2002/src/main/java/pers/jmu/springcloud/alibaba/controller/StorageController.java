package pers.jmu.springcloud.alibaba.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pers.jmu.springcloud.alibaba.service.StorageService;

import javax.annotation.Resource;

/**
 * @author mzq
 * @time 11:24
 * @date 2022-11-3-0003
 */
@RestController
public class StorageController {

    @Resource
    private StorageService storageService;

    /**
     * 扣减库存
     */
    @RequestMapping("/storage/decrease")
    public String decrease(@RequestParam("productId") Long productId, @RequestParam("count") Integer count) {
        storageService.decrease(productId, count);
        return "200---扣减库存成功";
    }
}
