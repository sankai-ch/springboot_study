package com.example.demo.dao;

import com.example.demo.DemoApplication;
import com.example.demo.dataobject.TestDO;
import com.example.demo.dataobject.UserDO;
import com.example.demo.jpa.UserJpaDAO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

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
//        TestDO testDO = new TestDO();
        UserDO userDO = new UserDO();
        userDO.setUsername("sankai");
        System.out.println(userDO.getUsername());
        UserDO userDOS = userJpaDAO.finDD(userDO.getUsername());
        System.out.println(userDOS);
//        list.forEach(userDO1 -> {
//            System.out.println(userDO1);
//        });
//        testDO.setIsTest(true);
//        testDO.getIsTest();
    }

    @Test
    public void testData() {
        TestDO testDO = new TestDO();

        testDO.setIsTestB(true);
        testDO.setName("你好");
        TestDO testDO1 = new TestDO(10L, "你好", "文件名", new Date(), new Date(), true, true);
        System.out.println("testDO：" + testDO);
        System.out.println("testDO1：" + testDO1);

    }

    @Test
    public void findMaxValue() {
        int[] maxValue = new int[]{3443, 5, 14356, 2, 4, 6, 78, 43, 2, 6, 3, 35, 435};
        int max = maxValue[0];
        for (int i = 0; i < maxValue.length; i++) {
            if (maxValue[i] > max) {
                max = maxValue[i];
            }
        }
        System.out.println(max);

    }
}
