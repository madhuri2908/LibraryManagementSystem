package admin_functions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import library_system.CreateDB;

public class Admin {
	final static JFrame f = new JFrame("Admin Functions");
	static JButton view_but = new JButton("View Books");
	static JButton users_but = new JButton("View Users");
	static JButton issued_but = new JButton("View Issued Books");
	static JButton add_user = new JButton("Add User");
	static JButton add_book = new JButton("Add Book"); 
	static JButton issue_book = new JButton("Issue Book");
	static JButton return_book = new JButton("Return Book"); 
	static JButton logout = new JButton("Logout");
	public static void admin_menu() {

		 // Give dialog box name as admin functions
		// f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //

		JButton create_but = new JButton("Create/Reset");// creating instance of JButton to create or reset database
		create_but.setBounds(450, 60, 120, 25);// x axis, y axis, width, height
		create_but.addActionListener(new ActionListener() { // Perform action
			public void actionPerformed(ActionEvent e) {

				CreateDB.create(); // Call create function
				JOptionPane.showMessageDialog(null, "Database Created/Reset!"); // Open a dialog box and display the
																				// message

			}
		});

		view_but.setBounds(20, 20, 120, 25);// creating instance of JButton to view books
		ViewBooks.viewBooks();// x axis, y axis, width, height

		// creating instance of JButton to view users
		users_but.setBounds(150, 20, 120, 25);// x axis, y axis, width, height
		UserList.userList();
		
		// creating instance of JButton to view the issued books
		issued_but.setBounds(280, 20, 160, 25);// x axis, y axis, width, height
		IssuedBooks.issuedBooks();

		 // creating instance of JButton to add users
		add_user.setBounds(20, 60, 120, 25); // set dimensions for button
		AddUser.addUser();
		
		// creating instance of JButton for adding books
		add_book.setBounds(150, 60, 120, 25);
		AddBook.addBook();

		 // creating instance of JButton to issue books
		issue_book.setBounds(450, 20, 120, 25);
		IssueBook.issueBook();
		

		// creating instance of JButton to return books
		return_book.setBounds(280, 60, 160, 25);
		ReturnBook.returnBook();

		
		
		// creating instance of JButton
		logout.setBounds(210, 100, 120, 25);// x axis, y axis, width, height
		Logout.logout();
		

		f.add(create_but);
		f.add(return_book);
		f.add(issue_book);
		f.add(add_book);
		f.add(issued_but);
		f.add(users_but);
		f.add(view_but);
		f.add(add_user);
		f.add(logout);
		f.setSize(600, 200);// 400 width and 500 height
		f.setLayout(null);// using no layout managers
		f.setVisible(true);// making the frame visible
		f.setLocationRelativeTo(null);

	}
}
