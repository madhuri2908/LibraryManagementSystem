package library_system;

import java.sql.Connection;
import java.sql.DriverManager;

public class App {
	public static void main(String[] args) {
		Login.login();
		//create();
	}

	public static Connection connect() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?user=root&password=1234");
			return con;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}
}
