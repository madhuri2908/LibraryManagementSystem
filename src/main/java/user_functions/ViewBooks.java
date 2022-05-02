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

public class ViewBooks {
	public static void viewBooks() {
		User.view_but.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				JFrame f = new JFrame("Books Available"); // View books stored in database
				// f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

				Connection connection = App.connect();
				String sql = "select * from BOOKS"; // Retreive data from database
				try {
					Statement stmt = connection.createStatement(); // connect to database
					stmt.executeUpdate("USE LIBRARY"); // use librabry
					stmt = connection.createStatement();
					ResultSet rs = stmt.executeQuery(sql);
					JTable book_list = new JTable(); // show data in table format
					book_list.setModel(DbUtils.resultSetToTableModel(rs));

					JScrollPane scrollPane = new JScrollPane(book_list); // enable scroll bar

					f.add(scrollPane); // add scroll bar
					f.setSize(800, 400); // set dimensions of view books frame
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
