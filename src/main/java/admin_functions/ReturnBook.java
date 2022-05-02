package admin_functions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import library_system.App;
import user_functions.User.ex;

public class ReturnBook {
	public static void returnBook() {
		Admin.return_book.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				final JFrame g = new JFrame("Enter Details");
				// g.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				// set labels
				JLabel l1, l2, l3, l4;
				l1 = new JLabel("Issue ID(IID)"); // Label 1 for Issue ID
				l1.setBounds(30, 15, 100, 30);

				l4 = new JLabel("Return Date(DD-MM-YYYY)");
				l4.setBounds(30, 50, 150, 30);

				final JTextField F_iid = new JTextField();
				F_iid.setBounds(110, 15, 200, 30);

				final JTextField F_return = new JTextField();
				F_return.setBounds(180, 50, 130, 30);

				JButton create_but = new JButton("Return");// creating instance of JButton to mention return date and
															// calculcate fine
				create_but.setBounds(130, 170, 80, 25);// x axis, y axis, width, height
				create_but.addActionListener(new ActionListener() {

					public void actionPerformed(ActionEvent e) {

						String iid = F_iid.getText();
						String return_date = F_return.getText();

						Connection connection = App.connect();

						try {
							Statement stmt = connection.createStatement();
							stmt.executeUpdate("USE LIBRARY");
							// Intialize date1 with NULL value
							String date1 = null;
							String date2 = return_date; // Intialize date2 with return date

							// select issue date
							ResultSet rs = stmt.executeQuery("SELECT ISSUED_DATE FROM ISSUED WHERE IID=" + iid);
							while (rs.next()) {
								date1 = rs.getString(1);

							}

							try {
								Date date_1 = new SimpleDateFormat("dd-MM-yyyy").parse(date1);
								Date date_2 = new SimpleDateFormat("dd-MM-yyyy").parse(date2);
								// subtract the dates and store in diff
								long diff = date_2.getTime() - date_1.getTime();
								// Convert diff from milliseconds to days
								ex.days = (int) (TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS));

							} catch (ParseException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}

							// update return date
							stmt.executeUpdate("UPDATE ISSUED SET RETURN_DATE='" + return_date + "' WHERE IID=" + iid);
							g.dispose();

							Connection connection1 = App.connect();
							Statement stmt1 = connection1.createStatement();
							stmt1.executeUpdate("USE LIBRARY");
							ResultSet rs1 = stmt1.executeQuery("SELECT PERIOD FROM ISSUED WHERE IID=" + iid); // set
																												// period
							String diff = null;
							while (rs1.next()) {
								diff = rs1.getString(1);

							}
							int diff_int = Integer.parseInt(diff);
							if (ex.days > diff_int) { // If number of days are more than the period then calculcate fine

								// System.out.println(ex.days);
								int fine = (ex.days - diff_int) * 1; // fine for every day after the period is $ 10.
								// update fine in the system
								stmt1.executeUpdate("UPDATE ISSUED SET FINE=" + fine + " WHERE IID=" + iid);
								String fine_str = ("Fine: $ " + fine);
								JOptionPane.showMessageDialog(null, fine_str);

							}

							JOptionPane.showMessageDialog(null, "Book Returned!");

						}

						catch (SQLException e1) {
							// TODO Auto-generated catch block
							JOptionPane.showMessageDialog(null, e1);
						}

					}

				});
				g.add(l4);
				g.add(create_but);
				g.add(l1);
				g.add(F_iid);
				g.add(F_return);
				g.setSize(350, 250);// 400 width and 500 height
				g.setLayout(null);// using no layout managers
				g.setVisible(true);// making the frame visible
				g.setLocationRelativeTo(null);
			}
		});
	}
}
