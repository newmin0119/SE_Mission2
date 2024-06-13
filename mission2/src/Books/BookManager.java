package Books;

import java.util.Set;
import java.util.LinkedHashSet;

import exception.*;

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