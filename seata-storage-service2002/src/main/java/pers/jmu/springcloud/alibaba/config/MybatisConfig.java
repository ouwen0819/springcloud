package pers.jmu.springcloud.alibaba.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author mzq
 * @time 14:18
 * @date 2022-10-31-0031
 */
@Configuration
@MapperScan({"pers.jmu.springcloud.alibaba.dao"})
public class MybatisConfig {
}
