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
				// set frame wot enter book details
				final JFrame g = new JFrame("Enter Book Details");
				// g.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				// set labels
				JLabel l1, l2, l3;
				l1 = new JLabel("Book Name"); // lebel 1 for book name
				l1.setBounds(30, 15, 100, 30);

				l2 = new JLabel("Genre"); // label 2 for genre
				l2.setBounds(30, 53, 100, 30);

				l3 = new JLabel("Price"); // label 2 for price
				l3.setBounds(30, 90, 100, 30);

				// set text field for book name
				final JTextField F_bname = new JTextField();
				F_bname.setBounds(110, 15, 200, 30);

				// set text field for genre
				final JTextField F_genre = new JTextField();
				F_genre.setBounds(110, 53, 200, 30);
				// set text field for price
				final JTextField F_price = new JTextField();
				F_price.setBounds(110, 90, 200, 30);

				JButton create_but = new JButton("Submit");// creating instance of JButton to submit details
				create_but.setBounds(130, 130, 80, 25);// x axis, y axis, width, height
				create_but.addActionListener(new ActionListener() {

					public void actionPerformed(ActionEvent e) {
						// assign the book name, genre, price
						String bname = F_bname.getText();
						String genre = F_genre.getText();
						String price = F_price.getText();
						// convert price of integer to int
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
							// TODO Auto-generated catch block
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
				g.setSize(350, 200);// 400 width and 500 height
				g.setLayout(null);// using no layout managers
				g.setVisible(true);// making the frame visible
				g.setLocationRelativeTo(null);

			}
		});
	}
}
