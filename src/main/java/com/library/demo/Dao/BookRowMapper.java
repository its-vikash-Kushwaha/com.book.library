package com.library.demo.Dao;

import com.library.demo.entity.*;
import org.springframework.jdbc.core.RowMapper;

import javax.swing.tree.TreePath;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BookRowMapper implements RowMapper<Book> {

    @Override
    public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
       Book b=new Book();
       b.setId(rs.getInt("id"));
       b.setTitle(rs.getString("title"));
       b.setAbout(rs.getString("about"));
       b.setAuthor(rs.getString("author"));
       b.setLanguage(rs.getString("language"));
       b.setAvailable(rs.getBoolean("available"));

        return b;
    }


}
