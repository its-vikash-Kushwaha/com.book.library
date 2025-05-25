package com.library.demo;

import com.library.demo.Dao.BookDao;
import com.library.demo.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import java.util.List;

@SpringBootApplication
public class Application  implements CommandLineRunner {

	public static void main(String[] args) {

		SpringApplication.run(Application.class, args);



	}

	@Override
	public void run(String... args) throws Exception {

	}
}
