package admin_functions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import library_system.App;

public class AddBook {
	public static void addBook() {
		Admin.add_book.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				final JFrame g = new JFrame("Enter Book Details");
				
				JLabel l1, l2, l3;
				l1 = new JLabel("Book Name"); 
				l1.setBounds(30, 15, 100, 30);

				l2 = new JLabel("Genre"); 
				l2.setBounds(30, 53, 100, 30);

				l3 = new JLabel("Price"); 
				l3.setBounds(30, 90, 100, 30);

				
				final JTextField F_bname = new JTextField();
				F_bname.setBounds(110, 15, 200, 30);

				
				final JTextField F_genre = new JTextField();
				F_genre.setBounds(110, 53, 200, 30);
				
				final JTextField F_price = new JTextField();
				F_price.setBounds(110, 90, 200, 30);

				JButton create_but = new JButton("Submit");
				create_but.setBounds(130, 130, 80, 25);
				create_but.addActionListener(new ActionListener() {

					public void actionPerformed(ActionEvent e) {
						
						String bname = F_bname.getText();
						String genre = F_genre.getText();
						String price = F_price.getText();
						
						int price_int = Integer.parseInt(price);

						Connection connection = App.connect();

						try {
							Statement stmt = connection.createStatement();
							stmt.executeUpdate("USE LIBRARY");
							stmt.executeUpdate("INSERT INTO BOOKS(BNAME,GENRE,PRICE) VALUES ('" + bname + "','" + genre
									+ "'," + price_int + ")");
							JOptionPane.showMessageDialog(null, "Book added!");
							g.dispose();

						}

						catch (SQLException e1) {
							
							JOptionPane.showMessageDialog(null, e1);
						}

					}

				});

				g.add(l3);
				g.add(create_but);
				g.add(l1);
				g.add(l2);
				g.add(F_bname);
				g.add(F_genre);
				g.add(F_price);
				g.setSize(350, 200);
				g.setLayout(null);
				g.setVisible(true);
				g.setLocationRelativeTo(null);

			}
		});
	}
}
