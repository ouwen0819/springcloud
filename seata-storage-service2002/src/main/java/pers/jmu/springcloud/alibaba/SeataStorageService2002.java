package pers.jmu.springcloud.alibaba;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author mzq
 * @time 11:26
 * @date 2022-11-3-0003
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class SeataStorageService2002 {

    public static void main(String[] args) {
        SpringApplication.run(SeataStorageService2002.class, args);
    }
}
