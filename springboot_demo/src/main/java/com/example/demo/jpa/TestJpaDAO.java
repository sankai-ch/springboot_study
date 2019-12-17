package com.example.demo.jpa;

import com.example.demo.dataobject.TestDO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author SanKai
 * @since 2019-10-25
 */
public interface TestJpaDAO extends JpaRepository<TestDO, Long> {

    List<TestDO> findAll();

    TestDO findAllById(Long id);

}
