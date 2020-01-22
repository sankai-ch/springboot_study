package com.example.demo.jpa;

import com.example.demo.dataobject.UserRoleDO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * @author SanKai
 * @since 2020-01-04
 */
@Repository
@Mapper
public interface UserRoleJpaDAO extends JpaRepository<UserRoleDO,Long> {

//    @Query("select UserRoleDO.role_name from UserRoleDO where UserRoleDO.username = ?1")
//    UserRoleDO getByName(String username);
}
