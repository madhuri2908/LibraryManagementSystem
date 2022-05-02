package admin_functions;

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

public class IssuedBooks {
	public static void issuedBooks(){
		Admin.issued_but.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
	
				JFrame f = new JFrame("Users List");
				// f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
				Connection connection = App.connect();
				String sql = "select * from issued";
				try {
					Statement stmt = connection.createStatement();
					stmt.executeUpdate("USE LIBRARY");
					stmt = connection.createStatement();
					ResultSet rs = stmt.executeQuery(sql);
					JTable book_list = new JTable();
					book_list.setModel(DbUtils.resultSetToTableModel(rs));
	
					JScrollPane scrollPane = new JScrollPane(book_list);
	
					f.add(scrollPane);
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
