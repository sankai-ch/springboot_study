package com.example.demo.mapper;

import com.example.demo.dataobject.TestDO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author SanKai
 * @since 2019-10-25
 */
public interface TestMapper {

    List<TestDO> findAll();
}
