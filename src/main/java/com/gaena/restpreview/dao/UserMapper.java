package com.gaena.restpreview.dao;

import com.gaena.restpreview.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.SelectKey;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {

    @Insert("INSERT INTO user(login ,password , role , created)" +
            "VALUES(#{login} , #{password} , #{role}) , now()")
    @SelectKey(statement = "SELECT LAST_INSERT_ID()", keyProperty = "id", before = false, resultType = long.class)
    long saveUser(User user);
}
