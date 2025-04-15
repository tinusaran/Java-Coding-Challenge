package util;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DButil {
	 public static Connection getDBConn() throws SQLException {
		 
	        String url = "jdbc:mysql://localhost:3306/Coding_challenge";
	        String username = "root";
	        String password = "srishtyAg12@";
	        return DriverManager.getConnection(url, username, password);
	        
	     
	    }
	    }

