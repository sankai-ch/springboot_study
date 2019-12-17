package com.example.demo.dao;

import com.example.demo.DemoApplication;
import com.example.demo.dataobject.TestDO;
import com.example.demo.dataobject.UserDO;
import com.example.demo.jpa.UserJpaDAO;
import javafx.application.Application;
import net.bytebuddy.implementation.bind.annotation.RuntimeType;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author SanKai
 * @since 2019-11-11
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = DemoApplication.class)
public class UserDAOTest {

    @Autowired
    private UserJpaDAO userJpaDAO;

    @Test
    public void test() {
        TestDO testDO = new TestDO();
        testDO.setIsTest(true);
        testDO.getIsTest();
    }
}
