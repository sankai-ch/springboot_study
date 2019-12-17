package com.example.demo.dataobject;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.util.Date;

/**
 * @author SanKai
 * @since 2019-10-25
 */
@Data
@Entity
@Table(name = "student")
@Api(value = "用户表")
public class TestDO {

    private Boolean isTest;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(value = "用户ID")
    private Long id;

    @ApiModelProperty(value = "用户姓名")
    private String name;

    @ApiModelProperty(value = "文件名")
    private String fileName;

    @CreatedDate
    @Column(name = "create_time")
    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    @LastModifiedDate
    @Column(name = "update_time")
    @ApiModelProperty(value = "更新时间")
    private Date updateTime;
}
