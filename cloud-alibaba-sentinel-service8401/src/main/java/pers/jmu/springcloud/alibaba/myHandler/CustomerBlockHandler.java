package pers.jmu.springcloud.alibaba.myHandler;

import com.alibaba.csp.sentinel.slots.block.BlockException;

/**
 * @author mzq
 * @time 11:03
 * @date 2022-10-20-0020
 */
public class CustomerBlockHandler {

    public static String handlerException1(BlockException blockException) {
        return "444 按客户自定义，global handlerException-----1";
    }

    public static String handlerException2(BlockException blockException) {
        return "444 按客户自定义，global handlerException-----2";
    }

}
