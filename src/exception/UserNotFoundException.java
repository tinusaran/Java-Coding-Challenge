package exception;

public class UserNotFoundException extends Exception {

	/**
	 * 
	 */
	public UserNotFoundException(String message) {
		
        super("user not found"+message);}
	

}
