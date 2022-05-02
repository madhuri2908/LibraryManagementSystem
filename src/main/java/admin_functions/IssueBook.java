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

public class IssueBook {
	public static void issueBook() {
		Admin.issue_book.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// enter details
				final JFrame g = new JFrame("Enter Details");
				// g.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				// create labels
				JLabel l1, l2, l3, l4;
				l1 = new JLabel("Book ID(BID)"); // Label 1 for Book ID
				l1.setBounds(30, 15, 100, 30);

				l2 = new JLabel("User ID(UID)"); // Label 2 for user ID
				l2.setBounds(30, 53, 100, 30);

				l3 = new JLabel("Period(days)"); // Label 3 for period
				l3.setBounds(30, 90, 100, 30);

				l4 = new JLabel("Issued Date(DD-MM-YYYY)"); // Label 4 for issue date
				l4.setBounds(30, 127, 150, 30);

				final JTextField F_bid = new JTextField();
				F_bid.setBounds(110, 15, 200, 30);

				final JTextField F_uid = new JTextField();
				F_uid.setBounds(110, 53, 200, 30);

				final JTextField F_period = new JTextField();
				F_period.setBounds(110, 90, 200, 30);

				final JTextField F_issue = new JTextField();
				F_issue.setBounds(180, 130, 130, 30);

				JButton create_but = new JButton("Submit");// creating instance of JButton
				create_but.setBounds(130, 170, 80, 25);// x axis, y axis, width, height
				create_but.addActionListener(new ActionListener() {

					public void actionPerformed(ActionEvent e) {

						String uid = F_uid.getText();
						String bid = F_bid.getText();
						String period = F_period.getText();
						String issued_date = F_issue.getText();

						int period_int = Integer.parseInt(period);

						Connection connection = App.connect();

						try {
							Statement stmt = connection.createStatement();
							stmt.executeUpdate("USE LIBRARY");
							stmt.executeUpdate("INSERT INTO ISSUED(UID,BID,ISSUED_DATE,PERIOD) VALUES ('" + uid + "','"
									+ bid + "','" + issued_date + "'," + period_int + ")");
							JOptionPane.showMessageDialog(null, "Book Issued!");
							g.dispose();

						}

						catch (SQLException e1) {
							// TODO Auto-generated catch block
							JOptionPane.showMessageDialog(null, e1);
						}

					}

				});

				g.add(l3);
				g.add(l4);
				g.add(create_but);
				g.add(l1);
				g.add(l2);
				g.add(F_uid);
				g.add(F_bid);
				g.add(F_period);
				g.add(F_issue);
				g.setSize(350, 250);// 400 width and 500 height
				g.setLayout(null);// using no layout managers
				g.setVisible(true);// making the frame visible
				g.setLocationRelativeTo(null);

			}
		});
	}
}
