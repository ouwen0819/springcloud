package pers.jmu.springcloud.service;

import org.apache.ibatis.annotations.Param;
import pers.jmu.springcloud.entities.Person;

public interface PaymentService {
    Person getPerson(@Param("classCn") String classCn);
}
