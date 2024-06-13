package Books;

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
 *
 */
public class BookManager {
	// Singleton
	private static BookManager instance;
	
	// Constructor
	private BookManager() {};
	
	// Instance getter
	public static BookManager getInstance() {
		if(instance==null) {
			instance = new BookManager();
		}
		
		return instance;
	};
	
	// bookMap: HashMap Container ( Id -> Book )
	private Set<Book> bookSet = new LinkedHashSet<Book>();
	
	// Add Book argument into bookMap
    public void addBook(Book book) throws AlreadyExists {
        if(bookSet.contains(book)){
        	// the book already exists.
        	throw new AlreadyExists(book.getId());
        }
        bookSet.add(book);
    }
    
    // Search Book by id value.
    public Book searchBook(int id) {
        for(Book book : bookSet) {
            if(book.getId() == id) {
                return book;
            }
        }
        throw new DoesNotExists(id);
    }
    
    public void removeBook(int id) {
        if(!bookSet.removeIf(book -> book.getId() == id)) {
        	// removeIf 함수는 삭제한 아이템이 없는 경우 false return.
        	throw new DoesNotExists(id);
        };
    }
}