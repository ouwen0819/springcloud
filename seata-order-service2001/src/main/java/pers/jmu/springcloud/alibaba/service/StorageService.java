package pers.jmu.springcloud.alibaba.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author mzq
 * @time 13:46
 * @date 2022-10-31-0031
 */
@FeignClient(value = "seata-storage-service")
public interface StorageService {
    @PostMapping(value = "/storage/decrease")
    String decrease(@RequestParam("productId") Long productId, @RequestParam("count") Integer count);
}
