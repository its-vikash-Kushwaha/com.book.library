package com.library.demo;

import com.library.demo.Dao.BookDao;
import com.library.demo.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

@SpringBootApplication
public class Application  implements CommandLineRunner {

	@Autowired
	private BookDao bookDao;
	public static void main(String[] args) {

		SpringApplication.run(Application.class, args);



	}

	@Override
	public void run(String... args) throws Exception {
		BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(System.in));
		while(true){
			System.out.println("Welcome to Library Management System ");
			System.out.println("PRESS 1 to add a book");
			System.out.println("PRESS 2 to view all book");
			System.out.println("PRESS 3 to search a book");
			System.out.println("PRESS 4 to update a book");
			System.out.println("PRESS 5 to delete a book");
			System.out.println("PRESS 6 to exit ");

			System.out.println("Enter your choice: ");
			int choice=Integer.parseInt(bufferedReader.readLine());

			if(choice ==1){
				System.out.print("Enter the boook title :");
				String title=bufferedReader.readLine();
				System.out.print("Enter the book author name :");
				String author= bufferedReader.readLine();
				System.out.print("Enter the book about : ");
				String about= bufferedReader.readLine();
				System.out.print("Enter the book language : ");
				String language= bufferedReader.readLine();
				System.out.print("Enter the book availbes T/F :");
				String availabe= bufferedReader.readLine();
				boolean isAvailable=availabe.equalsIgnoreCase("true");
				Book book=new Book();
		book.setTitle(title);
		book.setAuthor(author);
		book.setAbout(about);
		book.setLanguage(language);
		book.setAvailable(isAvailable);
		int r=bookDao.save(book);

			}
			else if(choice ==2){
				List<Book> b=bookDao.getAllBook();
				System.out.println("Id\t"+"Title\t"+"Author\t"+"     About\t      "+"Language\t"+"Available");
				for(Book book:b){
					System.out.println(book.getId()+" "+book.getTitle()+"   "+book.getAuthor()+"   "+book.getAbout()+"   "+book.getLanguage()+"   "+book.getAvailable());

				}
				System.out.println();

			}
			else if(choice==3){
				System.out.print("Enter the book id :");
				int bookId=Integer.parseInt(bufferedReader.readLine());
				Book book=bookDao.getBook(bookId);
				System.out.println("Id\t"+"Title\t"+"Author\t"+"     About\t      "+"Language\t"+"Available");

					System.out.println(book.getId()+" "+book.getTitle()+"   "+book.getAuthor()+"   "+book.getAbout()+"   "+book.getLanguage()+"   "+book.getAvailable());


				System.out.println();

			}
			else if(choice==4){
				System.out.print("Enter the book id ");
				int bookId=Integer.parseInt(bufferedReader.readLine());
				System.out.print("Enter the boook title :");
				String title=bufferedReader.readLine();
				System.out.print("Enter the book author name :");
				String author= bufferedReader.readLine();
				System.out.print("Enter the book about : ");
				String about= bufferedReader.readLine();
				System.out.print("Enter the book language : ");
				String language= bufferedReader.readLine();
				System.out.print("Enter the book availbe T/F :");
				String availabe= bufferedReader.readLine();
				boolean isAvailable=availabe.equalsIgnoreCase("true");
				Book book=new Book();
				book.setTitle(title);
				book.setAuthor(author);
				book.setAbout(about);
				book.setLanguage(language);
				book.setAvailable(isAvailable);
                bookDao.update(bookId,book);


			}
			else if(choice==5){
				System.out.print("Enter the book id :");
				int bookId=Integer.parseInt(bufferedReader.readLine());

				bookDao.delete(bookId);
				System.out.println("Book Deleted \n");

			}
			else if(choice==6){
				System.out.println("Exit the Application");
				break;
			}
			else {
				System.out.println("Invalid option choice");

			}

		}
