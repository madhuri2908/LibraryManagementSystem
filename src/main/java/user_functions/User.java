package user_functions;

import javax.swing.JButton;
import javax.swing.JFrame;

public class User {
	
	final static JFrame f = new JFrame("User Functions");
	static JButton my_book = new JButton("My Books");
	static JButton view_but = new JButton("View Books");
	static JButton logout = new JButton("Logout");
	public static class ex {
		public static int days = 0;
	}

	public static void user_menu(final String UID) {

		 // Give dialog box name as User functions
		// f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Exit user menu on closing
		// the dialog box
		// creating instance of JButton
		view_but.setBounds(20, 20, 120, 25);// x axis, y axis, width, height
		ViewBooks.viewBooks();
		
		
		

		// creating instance of JButton
		my_book.setBounds(150, 20, 120, 25);// x axis, y axis, width, height
		UserBooks.userBooks(UID);
		
		
		
		logout.setBounds(90, 60, 120, 25);// x axis, y axis, width, height
		Logout.logout();
		

		f.add(my_book); // add my books
		f.add(view_but); // add view books
		f.add(logout);
		f.setSize(300, 150);// 400 width and 500 height
		f.setLayout(null);// using no layout managers
		f.setVisible(true);// making the frame visible
		f.setLocationRelativeTo(null);
	}

}