package com.example.demo.jpa;

import com.example.demo.entity.Person;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @author SanKai
 * @since 2020-04-13
 */
public interface PersonJpaDAO extends JpaRepository<Person, Long> {

    @Query(value = "select * from person", nativeQuery = true)
    List<Person> queryAlls();

}
