package Books;

import java.util.ArrayList;
import java.util.List;

import exception.*;


/**
 * The {@code BookManager} class provides methods to manage a list of {@code Book} objects.
 * It allows adding, searching, and removing books from the list.
 * <p>
 * This class ensures that books are managed by their unique identifiers (ids).
 * Also use arrayList container to save data.
 * </p>
 *
 * <pre>
 * Example usage:
 * {@code
 * BookManager manager = new BookManager();
 * Book book = new Book(1, "software engineer", "SangHyeok", 2010);
 * manager.addBook(book);
 * Book foundBook = manager.searchBook(1);
 * manager.removeBook(1);
 * }
 * </pre>
 *
 * @see Book
 * @see AlreadyExistsException
 * @see DoesNotExistsException
 *
 * @author 이상혁
 * @author 이상민
 */
public class BookManager {

    /**
     * List to store book information, using ArrayList.
     */
    private List<Book> bookList = new ArrayList<>();
    /**
     * Constructs a new {@code BookManager}.
     */
	public BookManager() {}


    /**
     * Adds a {@code Book} to the book list.
     * @param book
     * @throws AlreadyExistsException
     */
    public void addBook(Book book) throws AlreadyExistsException {
        if(bookList.contains(book)){
        	// the book already exists.
        	throw new AlreadyExistsException(book.getId());
        }
        bookList.add(indexOfBook(book.getId()),book);
    }

    /**
     * Searches for a {@code Book} by its id.
     *
     * @param id the id of the book to search for
     * @return the book with the specified id
     * @throws DoesNotExistsException if the book with the specified id does not exist
     */
    public Book searchBook(int id) {
        for(Book book : bookList) {
            if(book.getId() == id) {
                return book;
            }
        }
        throw new DoesNotExistsException(id);
    }

    /**
     * Removes a {@code Book} from the book list by its id.
     *
     * @param id the id of the book to remove
     * @throws DoesNotExistsException if the book with the specified id does not exist
     */
    public void removeBook(int id) {
        if(!bookList.removeIf(book -> book.getId() == id)) {
        	// removeIf 함수는 삭제한 아이템이 없는 경우 false return.
        	throw new DoesNotExistsException(id);
        }
    }

    /**
     * Finds the index where a book with the specified id should be inserted.
     * Define by private.
     *
     * @param id the id of the book to find the index for
     * @return the index where the book should be inserted
     */
    private int indexOfBook(int id) {
        for (int i = 0; i < bookList.size(); i++) {
            if (bookList.get(i).getId() > id) {
                return i;
            }
        }
        return bookList.size();
    }


    /**
     * Searches for a {@code Book} using binary search by its id.
     *
     * @param id the id of the book to search for
     * @return the book with the specified id
     * @throws DoesNotExistsException if the book with the specified id does not exist
     */
    public Book search_bs(int id){
        int left = 0;
        int right = bookList.size() - 1;
        while(left <= right){
            int mid = left + (right - left) / 2;
            Book mid_book = bookList.get(mid);
            int mid_id = mid_book.getId();

            if(mid_id == id){
                return mid_book;
            }
            else if(mid_id > id){
                right = mid - 1;
            }
            else {
                left = mid + 1;
            }
        }
        throw new DoesNotExistsException(id);
    }
}