package test;

import Books.*;
import exception.*;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * {@code BookManagerTest} is a test class for the {@code BookManager} class.<br>
 * This class contains unit tests for the methods of {@code BookManager},
 * including add, search, binary search, and remove functionalities.
 * <p>
 * The tests are written using JUnit 5 framework.
 * </p>
 *
 * <pre>
 * Example usage:
 * {@code
 * // This class is automatically run by the JUnit framework to verify the functionality of the BookManager class.
 * }
 * </pre>
 *
 * @see BookManager
 * @see Book
 * @see AlreadyExistsException
 * @see DoesNotExistsException
 *
 * @author 이상혁
 *
 */
class BookManagerTest {
	private BookManager bookManager;

	@BeforeEach
	void setup() {
		bookManager = new BookManager();
	}

	/**
	 * Tests the {@code addBook} method of {@code BookManager}.
	 * Ensures that books are added correctly and that attempting to add a duplicate book throws an {@code AlreadyExistsException}.
	 */
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
		RuntimeException exception = assertThrows(AlreadyExistsException.class, () ->
				bookManager.addBook(newBook1)
		);
		System.out.println("\t" + exception.getMessage());	
		

		System.out.println("addBook 테스트 종료.");
	}

	/**
	 * Tests the {@code searchBook} method of {@code BookManager}.
	 * Ensures that books can be searched by id and that searching for a non-existent book throws a {@code DoesNotExistsException}.
	 */
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
		RuntimeException exception = assertThrows(DoesNotExistsException.class,
			() -> bookManager.searchBook(200)
		);
		System.out.println("\t" + exception.getMessage());	

		System.out.println("searchBook 테스트 종료.");
	}

	/**
	 * Tests the {@code search_bs} method of {@code BookManager}.
	 * Ensures that books can be searched using binary search by id and that searching for a non-existent book throws a {@code DoesNotExistsException}.
	 */
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
		RuntimeException exception = assertThrows(DoesNotExistsException.class,
				() -> bookManager.search_bs(200)
		);
		System.out.println("\t" + exception.getMessage());

		System.out.println("search_bs 테스트 종료.");
	}

	/**
	 * Tests the {@code removeBook} method of {@code BookManager}.
	 * Ensures that books can be removed by id and that attempting to remove a non-existent book throws a {@code DoesNotExistsException}.
	 */
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
		RuntimeException exception = assertThrows(DoesNotExistsException.class,
			() -> bookManager.removeBook(2)
		);
		System.out.println("\t" + exception.getMessage());	

		System.out.println("removeBook 테스트 종료.");
	}
}
