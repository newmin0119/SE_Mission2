package performanceTest;

import Books.Book;
import Books.BookManager;

/**
 * The {@code PerformanceTestTarget} class is designed to test the performance of searching for books
 * within a {@code BookManager} instance.
 * <p>
 * This class initializes a {@code BookManager} with a range of book ids and provides methods to
 * measure the time taken to search for a book by its id using both linear and binary search methods.
 * </p>
 *
 * <pre>
 * Example usage:
 * {@code
 * PerformanceTestTarget testTarget = new PerformanceTestTarget(1, 1000);
 * long linearSearchTime = testTarget.testSearchBook(500);
 * long binarySearchTime = testTarget.testSearch_bs(500);
 * System.out.println("Linear search time(searchBook) : " + linearSearchTime + " ms");
 * System.out.println("Binary search time(search_bs) : " + binarySearchTime + " ms");
 * }
 * </pre>
 *
 * @see Book
 * @see BookManager
 *
 * @author 이상민
 */
public class PerformanceTestTarget {
    BookManager bookManager;
    private final int minId;
    private final int maxId;


    /**
     * Constructs a {@code PerformanceTestTarget} with the specified range of book ids.
     *
     * @param minId The minimum book id.
     * @param maxId The maximum book id.
     */
    public PerformanceTestTarget(int minId, int maxId) {
        bookManager = new BookManager();
        this.minId = minId;
        this.maxId = maxId;
        initTestCase();
    }

    /**
     * Initializes the test case by adding books with ids ranging from {@code minId} to {@code maxId - 1}
     * to the {@code BookManager}.
     */
    private void initTestCase(){
        // Test Case
        for(int i = minId; i < maxId; i++) {
            Book newBook = new Book(i, "newBook" + i, "JUnit", i);
            bookManager.addBook(newBook);
        }
    }

    /**
     * Measures the time taken to search for a book by its id using a linear search method.
     *
     * @param targetId The id of the book to be searched.
     * @return The time taken to search for the book in milliseconds.
     */
    public long testSearchBook(int targetId){
        long startTime = System.currentTimeMillis();
        bookManager.searchBook(targetId);
        long endTime = System.currentTimeMillis();

        return endTime - startTime;
    }

    /**
     * Measures the time taken to search for a book by its id using a binary search method.
     *
     * @param targetId The id of the book to be searched.
     * @return The time taken to search for the book in milliseconds.
     */
    public long testSearch_bs(int targetId){
        long startTime = System.currentTimeMillis();
        bookManager.search_bs(targetId);
        long endTime = System.currentTimeMillis();

        return endTime - startTime;
    }
}
