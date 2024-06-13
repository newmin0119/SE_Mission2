package test;

import Books.*;
import exception.*;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

/**
 * {@code BookManagerTest}는 {@code BookManger}객체에 대한 테스트 코드이다.. <br>
 * @author 이상혁
 *
 */
class BookManagerTest {
	static private BookManager bookManager;

	//인스턴스 호출
	@BeforeAll
	static void setup() throws Exception {
		bookManager = BookManager.getInstance();
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
		Book newBook3 = new Book(3, "newBook3", "Java",2020);
		bookManager.addBook(newBook3);
		System.out.println("\t" + newBook3.getInfoStr() + "도서가 추가되었습니다.");
		
		// Normal Case
		assertEquals(newBook3,bookManager.searchBook(3));
		System.out.println("\t" + newBook3.getInfoStr() + "도서가 검색되었습니다.");
		
		// Error Case - Not Found
		RuntimeException exception = assertThrows(DoesNotExists.class,
			() -> bookManager.searchBook(4)
		);
		System.out.println("\t" + exception.getMessage());	

		System.out.println("searchBook 테스트 종료.");
	}
	
	//removeBook 테스트
	@Test
	void testRemoveBook() {
		System.out.println("removeBook 테스트 시작.");
		
		// Test Case
		Book newBook4 = new Book(4, "newBook4", "Eclipse",2024);
		bookManager.addBook(newBook4);
		System.out.println("\t" + newBook4.getInfoStr() + "도서가 추가되었습니다.");
		
		// Normal Case
		assertDoesNotThrow(() -> bookManager.removeBook(4));
		System.out.println("\t" + newBook4.getInfoStr() + "도서가 삭제되었습니다.");
		
		// Error Case - Not Found
		RuntimeException exception = assertThrows(DoesNotExists.class,
			() -> bookManager.removeBook(4)
		);
		System.out.println("\t" + exception.getMessage());	

		System.out.println("removeBook 테스트 종료.");
	}
}
