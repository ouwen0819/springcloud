package pers.jmu.springcloud.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import pers.jmu.springcloud.entities.Person;

@Mapper
public interface PersonDao {
    Person getPerson(@Param("classCn") String classCn);
}
