package com.example.demo.dataobject;

import lombok.Data;

import javax.persistence.*;

/**
 * @author SanKai
 * @since 2020-01-04
 */
@Data
@Entity
@Table(name = "user_roles")
public class UserRoleDO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    private String role_name;

}
