package com.gaena.restpreview.dao;

import com.gaena.restpreview.model.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {

    @Insert("INSERT INTO users(login ,password , role , created)" +
            "VALUES(#{login} , #{password} , #{role} , now())")
    @SelectKey(statement = "SELECT LAST_INSERT_ID()", keyProperty = "id", before = false, resultType = long.class)
    long saveUser(User user);

    @Select("SELECT * FROM users WHERE id = #{id}")
    User getUserById(Long id);

    @Select("SELECT * FROM users")
    List<User> getAllUsers();

    @Update("UPDATE users SET password = #{password} , role = #{role} WHERE id = #{id}")
    void updateUser(User user);

    @Delete("DELETE FROM users WHERE id = #{id}")
    void deleteUser(Long id);
}
