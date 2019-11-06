package com.example.demo.jpa;

import com.example.demo.dataobject.UserDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author SanKai
 * @since 2019-11-06
 */
@Repository
public interface UserJpaDAO extends JpaRepository<UserDO, Long> {

    List<UserDO> findByName(String name);

    UserDO findByNameAndAndPassword(String name, String password);

}
