package Books;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.LinkedHashSet;

import exception.*;

/**
 * {@code BookManager}는 {@code Book}객체에 대한 create, read, delete 기능을 지원한다. <br>
 * <pre>
 *     singleton을 통해 생성되는 인스턴스를 하나로 유지하고 LinkedHashSet을 통해
 *     데이터 셋의 타입을 가변적으로 유지하고
 *     커스터마이징된 예외를 throw한다.
 * </pre>
 * @author 이상민
 * @author 이상혁
 *
 */
public class BookManager {

	// Constructor
	public BookManager() {};
	
	// bookList: ArrayList Container
	private List<Book> bookList = new ArrayList<>();
	
	// Add Book argument into bookL
    public void addBook(Book book) throws AlreadyExists {
        if(bookList.contains(book)){
        	// the book already exists.
        	throw new AlreadyExists(book.getId());
        }
        bookList.add(indexOfBook(book.getId()),book);
    }
    
    // Search Book by id value.
    public Book searchBook(int id) {
        for(Book book : bookList) {
            if(book.getId() == id) {
                return book;
            }
        }
        throw new DoesNotExists(id);
    }

    //remove book by id value.
    public void removeBook(int id) {
        if(!bookList.removeIf(book -> book.getId() == id)) {
        	// removeIf 함수는 삭제한 아이템이 없는 경우 false return.
        	throw new DoesNotExists(id);
        };
    }

    //find index of book by id number.
    private int indexOfBook(int id) {
        for (int i = 0; i < bookList.size(); i++) {
            if (bookList.get(i).getId() > id) {
                return i;
            }
        }
        return bookList.size();
    }
}