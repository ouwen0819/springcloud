package pers.jmu.springcloud.alibaba.service.impl;

import org.springframework.stereotype.Service;
import pers.jmu.springcloud.alibaba.dao.StorageDao;
import pers.jmu.springcloud.alibaba.service.StorageService;

import javax.annotation.Resource;

/**
 * @author mzq
 * @time 11:21
 * @date 2022-11-3-0003
 */
@Service
public class StorageServiceImpl implements StorageService {
    @Resource
    private StorageDao storageDao;

    /**
     * 扣减库存
     */
    @Override
    public void decrease(Long productId, Integer count) {
        System.out.println("------->storage-service中扣减库存开始");
        storageDao.decrease(productId, count);
        System.out.println("------->storage-service中扣减库存结束");
    }

}
