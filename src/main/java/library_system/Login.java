package library_system;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import admin_functions.Admin;
import user_functions.User;

public class Login {
	public static void login() {

		final JFrame f = new JFrame("Login");
		JLabel l1, l2;
		l1 = new JLabel("Username"); 
		l1.setBounds(30, 15, 100, 30); 

		l2 = new JLabel("Password"); 
		l2.setBounds(30, 50, 100, 30);

		final JTextField F_user = new JTextField(); 
		F_user.setBounds(110, 15, 200, 30);

		final JPasswordField F_pass = new JPasswordField(); 
		F_pass.setBounds(110, 50, 200, 30);

		JButton login_but = new JButton("Login");
		login_but.setBounds(130, 90, 80, 25);
		login_but.addActionListener(new ActionListener() { 

			public void actionPerformed(ActionEvent e) {

				String username = F_user.getText(); 
				@SuppressWarnings("deprecation")
				String password = F_pass.getText(); 

				if (username.equals("")) // If username is null
				{
					JOptionPane.showMessageDialog(null, "Please enter username");
				} else if (password.equals("")) // If password is null
				{
					JOptionPane.showMessageDialog(null, "Please enter password"); 
				} else { 
							
					Connection connection = App.connect(); /
					try {
						Statement stmt = connection.createStatement();
						stmt.executeUpdate("USE LIBRARY"); 
						String st = ("SELECT * FROM USERS WHERE USERNAME='" + username + "' AND PASSWORD='" + password
								+ "'"); 
						ResultSet rs = stmt.executeQuery(st); 
						if (rs.next() == false) { 
							System.out.print("No user");
							JOptionPane.showMessageDialog(null, "Wrong Username/Password!"); 

						} else {
							f.dispose();
							do {
								String admin = rs.getString("ADMIN"); 
								System.out.println(admin);
								String UID = rs.getString("UID"); 
								if (admin.equals("1")) { 
									Admin.admin_menu(); 
								} else {
									User.user_menu(UID); 
								}
							}while (rs.next());
						}
					} catch (Exception ex) {
						ex.printStackTrace();
					}
				}
			}
		});

		f.add(F_pass); 
		f.add(login_but);
		f.add(F_user); 
		f.add(l1); 
		f.add(l2);

		f.setSize(400, 180);
		f.setLayout(null);
		f.setVisible(true);
		f.setLocationRelativeTo(null);

	}
}
