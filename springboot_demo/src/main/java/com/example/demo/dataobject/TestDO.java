package com.example.demo.dataobject;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.util.Date;

/**
 * @author SanKai
 * @since 2019-10-25
 */
@Data//getter/setter方法的注解
@Entity
@Table(name = "student")
@Api(value = "用户表")
@AllArgsConstructor//用于有参构造函数的注解
@NoArgsConstructor//用于无参构造函数的注解
public class TestDO {


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

    private boolean isTestA;

    private Boolean isTestB;
}
