package entity;

public class User {
	

	
		int userId;
		String username;
		String password;
		String role;
		public User(int userId, String username, String password, String role) {
	        this.userId = userId;
	        this.username = username;
	        this.password = password;
	        this.role = role;
	    }
}
