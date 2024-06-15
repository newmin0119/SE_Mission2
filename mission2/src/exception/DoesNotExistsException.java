package exception;

/**
 * The {@code DoesNotExistsException} class represents an exception that is thrown
 * when an operation attempts to access a {@code Book} that does not exist in the collection.<br>
 * Rename it to DoesNotExists -> DoesNotExistsException
 * <p>
 * This exception extends {@code RuntimeException}, meaning it is an unchecked exception.
 * </p>
 *
 * <pre>
 * Example usage:
 * {@code
 * BookManager manager = new BookManager();
 * try {
 *     Book book = manager.searchBook(1); //This will throw DoesNotExistsException
 * } catch (DoesNotExistsException e) {
 *     System.out.println(e.getMessage());
 * }
 * }
 * </pre>
 * @see Books.BookManager
 *
 * @author 이상민
 */
public class DoesNotExistsException extends RuntimeException{
	public DoesNotExistsException(){ }
	
	public DoesNotExistsException(int id){
		super(String.format("Error! Cause: Book(id: %05d) doesn't exist.",id));
	}
}