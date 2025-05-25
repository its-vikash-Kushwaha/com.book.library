package com.library.demo.Dao;

import com.library.demo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class userDao {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public userDao(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate=jdbcTemplate;
    }

    public int save(User user){
        String query="insert into usersBook (Name,email,password,city) values (?,?,?,?);";
        int rowEffected=jdbcTemplate.update(query,
                user.getName(),
                user.getEmail(),
                user.getPassword(),
                user.getCity());

        System.out.println("User added "+rowEffected);
        return rowEffected;
    }

    public void delete(int id){
        String query="delete from usersBook where user_id=?;";
        int r=jdbcTemplate.update(query,id);
        System.out.println("User deleted  :"+r);
    }

    public void update(int id,User user){
        String qeury="update set Name=?,email=?,password=?,city=? where user_id=? ;";
        int row=jdbcTemplate.update(qeury,
                user.getName(),
                user.getEmail(),
                user.getPassword(),
                user.getCity());
        System.out.println("User updated : "+row);
    }

    public User getUser(int id){
        String query="select * from usersBook where user_id=?;";
        User u=jdbcTemplate.queryForObject(query,
                new UserRowMapper(),
                id);
        return u;
    }

    public List<User> getAllUser(){
        String query="select * from usersBook;";
        List<User> u=jdbcTemplate.query(query,
                new UserRowMapper());
        return u;
    }

    public List<User> search(String name){
        String query ="Select * from usersBook where Name like ?;";
        List<User> u=jdbcTemplate.query(query, new UserRowMapper(),
                "%"+name+"%");
        return u;
    }


}
