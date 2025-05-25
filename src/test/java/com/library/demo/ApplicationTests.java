package com.library.demo;

import com.library.demo.Dao.*;
import com.library.demo.entity.Book;
import com.library.demo.entity.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.Random;

@SpringBootTest
class ApplicationTests {
	@Autowired
	private BookDao bookDao;
	@Autowired
	private userDao uDao;
//	@Test
//	void saveUserTest() {
//		User user = new User();
//		user.setUser_id(500 + (new Random().nextInt(1000)));
//		user.setName("Moin Ali");
//		user.setCity("Landon");
//		user.setPassword("Moin@1234");
//		user.setEmail("moin@gmail.com");
//		int row = uDao.save(user);
//		Assertions.assertEquals(1, row);
//	}
//	@Test
//	public void saveBook(){
//
//	}
	@Test
	void contextLoads() {
		Book book=new Book();
		book.setTitle("Maths ");
		book.setAuthor("Hery");
		book.setAbout("Concept of maths");
		book.setLanguage("English");
		book.setAvailable(true);
		int r=bookDao.save(book);
		Assertions.assertEquals(1,r);
	}


}
