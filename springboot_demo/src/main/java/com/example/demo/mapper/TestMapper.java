package com.example.demo.mapper;

import com.example.demo.dataobject.TestDO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author SanKai
 * @since 2019-10-25
 */
public interface TestMapper extends JpaRepository<TestDO, Long> {

    List<TestDO> findAll();
}
