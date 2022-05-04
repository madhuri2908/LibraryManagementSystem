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

		 
		

		JButton create_but = new JButton("Create/Reset");
		create_but.setBounds(450, 60, 120, 25);
		create_but.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) {
				CreateDB.create(); 
				JOptionPane.showMessageDialog(null, "Database Created/Reset!");																
			}
		});

		view_but.setBounds(20, 20, 120, 25);
		ViewBooks.viewBooks();

		
		users_but.setBounds(150, 20, 120, 25);
		UserList.userList();
		
		
		issued_but.setBounds(280, 20, 160, 25);
		IssuedBooks.issuedBooks();

		 
		add_user.setBounds(20, 60, 120, 25); 
		AddUser.addUser();
		
		
		add_book.setBounds(150, 60, 120, 25);
		AddBook.addBook();

		 
		issue_book.setBounds(450, 20, 120, 25);
		IssueBook.issueBook();
		

		
		return_book.setBounds(280, 60, 160, 25);
		ReturnBook.returnBook();

		
		
		
		logout.setBounds(210, 100, 120, 25);
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
		f.setSize(600, 200);
		f.setLayout(null);
		f.setVisible(true);
		f.setLocationRelativeTo(null);

	}
}
