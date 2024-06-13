package exception;

public class DoesNotExists extends RuntimeException{
	private static final long serialVersionUID = 1L;
	
	public DoesNotExists(){
		
	}
	
	public DoesNotExists(int id){
		super(String.format("Error! Cause: Book(id: %05d) doesn't exist.",id));
	}
}