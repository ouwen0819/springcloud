package pers.jmu.springcloud.alibaba.service;

/**
 * @author mzq
 * @time 11:20
 * @date 2022-11-3-0003
 */
public interface StorageService {
    /**
     * 扣减库存
     *
     * @param productId
     * @param count
     */
    void decrease(Long productId, Integer count);
}
