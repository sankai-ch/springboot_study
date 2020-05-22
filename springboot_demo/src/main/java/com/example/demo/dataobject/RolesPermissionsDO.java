package com.example.demo.dataobject;

import lombok.Data;

import javax.persistence.*;

/**
 * @author SanKai
 * @since 2020-01-04
 */

@Data
@Entity
@Table(name = "roles_permissions")
public class RolesPermissionsDO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String roleName;

    private String permission;
}
