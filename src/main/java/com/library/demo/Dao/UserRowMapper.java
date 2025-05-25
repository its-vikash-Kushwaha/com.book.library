package com.library.demo.Dao;

import com.library.demo.entity.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRowMapper implements RowMapper<User> {
    @Override
    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
        User user=new User();
        user.setUser_id(rs.getInt("user_id"));
        user.setName(rs.getString("Name"));
        user.setEmail(rs.getString("email"));
        user.setPassword(rs.getString("password"));
        user.setCity(rs.getString("city"));
        return user;
    }
}
