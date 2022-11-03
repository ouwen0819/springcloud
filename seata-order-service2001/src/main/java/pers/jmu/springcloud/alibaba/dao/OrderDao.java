package pers.jmu.springcloud.alibaba.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import pers.jmu.springcloud.alibaba.domain.Order;

/**
 * @author mzq
 * @time 11:29
 * @date 2022-10-31-0031
 */
@Mapper
public interface OrderDao {
    //新建订单
    void create(Order order);

    //修改订单状态
    void update(@Param("userId") Long userId, @Param("status") Integer status);
}
