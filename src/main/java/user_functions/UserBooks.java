package user_functions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import library_system.App;
import net.proteanit.sql.DbUtils;

public class UserBooks {
	public static void userBooks(final String UID) {
		User.my_book.addActionListener(new ActionListener() { // Perform action
			public void actionPerformed(ActionEvent e) {
		
				JFrame f = new JFrame("My Books"); // View books issued by user
				// f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				int UID_int = Integer.parseInt(UID); 
		
				// .iid,issued.uid,issued.bid,issued.issued_date,issued.return_date,issued,
				Connection connection = App.connect(); // connect to database
				// retrieve data
				String sql = "select distinct issued.*,books.bname,books.genre,books.price from issued,books "
						+ "where ((issued.uid=" + UID_int
						+ ") and (books.bid in (select bid from issued where issued.uid=" + UID_int
						+ "))) group by iid";
				String sql1 = "select bid from issued where uid=" + UID_int;
				try {
					Statement stmt = connection.createStatement();
					// use database
					stmt.executeUpdate("USE LIBRARY");
					stmt = connection.createStatement();
		
					ResultSet rs = stmt.executeQuery(sql);
					JTable book_list = new JTable(); // store data in table format
					book_list.setModel(DbUtils.resultSetToTableModel(rs));
					// enable scroll bar
					JScrollPane scrollPane = new JScrollPane(book_list);
		
					f.add(scrollPane); // add scroll bar
					f.setSize(800, 400); 
					f.setVisible(true);
					f.setLocationRelativeTo(null);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, e1);
				}
		
			}
			
		});
	}
}
