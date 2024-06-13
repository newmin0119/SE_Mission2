package exception;

public class AlreadyExists extends RuntimeException{
	private static final long serialVersionUID = 1L;
	
	public AlreadyExists(){
		
	}
	
	public AlreadyExists(int id){
		super(String.format("Error! Cause: Book(id: %05d) already exists.",id));
	}
}
