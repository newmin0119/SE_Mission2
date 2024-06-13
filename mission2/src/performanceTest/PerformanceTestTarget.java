package performanceTest;

import Books.Book;
import Books.BookManager;

public class PerformanceTestTarget {
    BookManager bookManager;
    private final int minId;
    private final int maxId;
    public PerformanceTestTarget(int minId, int maxId) {
        bookManager = new BookManager();
        this.minId = minId;
        this.maxId = maxId;
        initTestCase();
    }
    private void initTestCase(){
        // Test Case
        for(int i = minId; i < maxId; i++) {
            Book newBook = new Book(i, "newBook" + i, "JUnit", i);
            bookManager.addBook(newBook);
        }
    }
    public long testSearchBook(int targetId){
        long startTime = System.currentTimeMillis();
        bookManager.searchBook(targetId);
        long endTime = System.currentTimeMillis();

        return endTime - startTime;
    }

    public long testSearch_bs(int targetId){
        long startTime = System.currentTimeMillis();
        bookManager.search_bs(targetId);
        long endTime = System.currentTimeMillis();

        return endTime - startTime;
    }
}
