package com.example.demo.manager;

import com.example.demo.dataobject.TestDO;
import com.example.demo.jpa.TestJpaDAO;
import com.example.demo.mapper.TestMapper;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.weaver.ast.Test;
import org.hibernate.type.descriptor.java.UUIDTypeDescriptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

/**
 * @author SanKai
 * @since 2019-10-25
 */
@Service
@Slf4j
public class TestManager {

    @Autowired(required = false)
    private TestMapper testMapper;

    @Autowired
    private TestJpaDAO testJpaDAO;

    public List<TestDO> findAll() {
        return testMapper.findAll();
//        return testJpaDAO.findAll();
    }

    public boolean upload(Long id, MultipartFile file) {
        List<String> imageType = new ArrayList<>(Arrays.asList("jpg", "png", "jpeg", "bmp", "git"));
        TestDO testDO = testJpaDAO.findAllById(id);
        String fileName = file.getOriginalFilename();
        System.out.println(fileName);
        String fileSuffix = fileName.substring(fileName.lastIndexOf("."));//后缀名
        //只有当满足图片格式，重新赋图片名
        String filePath = "/Users/sankai/Documents/image/";
        fileName = UUID.randomUUID() + fileSuffix;
        String fileReplaceName = fileName.replaceAll("-", "");
        File newFile = new File(filePath + fileReplaceName);
        try {
            if (!newFile.getParentFile().exists()) {
                newFile.getParentFile().mkdir();
            }
            file.transferTo(newFile);
            testDO.setFileName(fileReplaceName);
            if (testDO.getCreateTime()==null){
                testDO.setCreateTime(new Date());
            }
            testDO.setUpdateTime(new Date());
            testJpaDAO.save(testDO);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return true;
    }

}
