package exception;

/**
 * The {@code AlreadyExistsException} class represents an exception that is thrown
 * when an operation attempts to add a {@code Book} that already exists in the collection.
 * <p>
 * This exception extends {@code RuntimeException}, meaning it is an unchecked exception.
 * </p>
 *
 * <pre>
 * Example usage:
 * {@code
 * BookManager manager = new BookManager();
 * Book book = new Book(1, "software engineer", "SangHyeok", 2010);
 * try {
 *     manager.addBook(book);
 *     manager.addBook(book); // This will throw AlreadyExistsException
 * } catch (AlreadyExistsException e) {
 *     System.out.println(e.getMessage());
 * }
 * }
 * </pre>
 *
 * @see Books.BookManager
 * @author 이상민
 */
public class AlreadyExistsException extends RuntimeException{
	public AlreadyExistsException(){
		
	}
	public AlreadyExistsException(int id){
		super(String.format("Error! Cause: Book(id: %05d) already exists.",id));
	}
}
