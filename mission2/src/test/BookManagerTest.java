package test;

import Books.*;
import exception.*;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * {@code BookManagerTest}는 {@code BookManger}객체에 대한 테스트 코드이다.. <br>
 * @author 이상혁
 *
 */
class BookManagerTest {
	private BookManager bookManager;

	@BeforeEach
	void setup() {
		bookManager = new BookManager();
	}

	//addBook 테스트코드
	@Test
	void testAddBook() {
		System.out.println("addBook 테스트 시작.");
		
		// Test Case
		Book newBook1 = new Book(1, "newBook1", "JUnit",2000);
		Book newBook2 = new Book(2, "newBook2", "JUnit",2001);
		
		// Normal Case
		assertDoesNotThrow(() -> bookManager.addBook(newBook1));
		System.out.println("\t" + newBook1.getInfoStr() + "도서가 추가되었습니다.");
		
		assertDoesNotThrow(() -> bookManager.addBook(newBook2));
		System.out.println("\t" + newBook2.getInfoStr() + "도서가 추가되었습니다.");
		
		
		// Error Case - Duplication
		RuntimeException exception = assertThrows(AlreadyExists.class, () -> 
				bookManager.addBook(newBook1)
		);
		System.out.println("\t" + exception.getMessage());	
		

		System.out.println("addBook 테스트 종료.");
	}

	//searchBook 테스트
	@Test
	void testSearchBook() {
		System.out.println("searchBook 테스트 시작.");


		// Test Case
		for(int i = 0; i < 50; i++) {
			Book newBook = new Book(i, "newBook" + i, "JUnit", 2000 + i/10);
			bookManager.addBook(newBook);
		}
		Book newBook = new Book(50, "newBook50", "JUnit", 2024);
		bookManager.addBook(newBook);

		System.out.println("\t" + "도서 50개가 추가되었습니다.");
		// Normal Case
		assertEquals(newBook,bookManager.searchBook(50));
		System.out.println("\t" + newBook.getInfoStr() + "도서가 검색되었습니다.");
		
		// Error Case - Not Found
		RuntimeException exception = assertThrows(DoesNotExists.class,
			() -> bookManager.searchBook(200)
		);
		System.out.println("\t" + exception.getMessage());	

		System.out.println("searchBook 테스트 종료.");
	}

	@Test
	void testSearch_bs() {
		System.out.println("search_bs 테스트 시작.");


		// Test Case
		for(int i = 0; i < 50; i++) {
			Book newBook = new Book(i, "newBook" + i, "JUnit", 2000 + i/10);
			bookManager.addBook(newBook);
		}
		Book newBook = new Book(50, "newBook50", "JUnit", 2024);
		bookManager.addBook(newBook);

		System.out.println("\t" + "도서 50개가 추가되었습니다.");
		// Normal Case
		assertEquals(newBook,bookManager.search_bs(50));
		System.out.println("\t" + newBook.getInfoStr() + "도서가 검색되었습니다.");

		// Error Case - Not Found
		RuntimeException exception = assertThrows(DoesNotExists.class,
				() -> bookManager.search_bs(200)
		);
		System.out.println("\t" + exception.getMessage());

		System.out.println("search_bs 테스트 종료.");
	}
	
	//removeBook 테스트
	@Test
	void testRemoveBook() {
		System.out.println("removeBook 테스트 시작.");
		
		// Test Case
		Book newBook1 = new Book(1, "newBook1", "JUnit",2000);
		bookManager.addBook(newBook1);
		System.out.println("\t" + newBook1.getInfoStr() + "도서가 추가되었습니다.");
		
		// Normal Case
		assertDoesNotThrow(() -> bookManager.removeBook(1));
		System.out.println("\t" + newBook1.getInfoStr() + "도서가 삭제되었습니다.");
		
		// Error Case - Not Found
		RuntimeException exception = assertThrows(DoesNotExists.class,
			() -> bookManager.removeBook(2)
		);
		System.out.println("\t" + exception.getMessage());	

		System.out.println("removeBook 테스트 종료.");
	}
}
