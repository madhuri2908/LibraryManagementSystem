package admin_functions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import library_system.App;

public class AddUser {
	public static void addUser() {
		Admin.add_user.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				final JFrame g = new JFrame("Enter User Details"); 
				
				
				JLabel l1, l2;
				l1 = new JLabel("Username"); 
				l1.setBounds(30, 15, 100, 30);

				l2 = new JLabel("Password"); 
				l2.setBounds(30, 50, 100, 30);

				
				final JTextField F_user = new JTextField();
				F_user.setBounds(110, 15, 200, 30);

				
				final JPasswordField F_pass = new JPasswordField();
				F_pass.setBounds(110, 50, 200, 30);
				
				final JRadioButton a1 = new JRadioButton("Admin");
				a1.setBounds(55, 80, 200, 30);
				
				JRadioButton a2 = new JRadioButton("User");
				a2.setBounds(130, 80, 200, 30);
				
				ButtonGroup bg = new ButtonGroup();
				bg.add(a1);
				bg.add(a2);

				JButton create_but = new JButton("Create");
				create_but.setBounds(130, 130, 80, 25);
				create_but.addActionListener(new ActionListener() {

					public void actionPerformed(ActionEvent e) {

						String username = F_user.getText();
						@SuppressWarnings("deprecation")
						String password = F_pass.getText();
						Boolean admin = false;

						if (a1.isSelected()) {
							admin = true;
						}

						Connection connection = App.connect();

						try {
							Statement stmt = connection.createStatement();
							stmt.executeUpdate("USE LIBRARY");
							stmt.executeUpdate("INSERT INTO USERS(USERNAME,PASSWORD,ADMIN) VALUES ('" + username + "','"
									+ password + "'," + admin + ")");
							JOptionPane.showMessageDialog(null, "User added!");
							g.dispose();

						}

						catch (SQLException e1) {
							
							JOptionPane.showMessageDialog(null, e1);
						}

					}

				});

				g.add(create_but);
				g.add(a2);
				g.add(a1);
				g.add(l1);
				g.add(l2);
				g.add(F_user);
				g.add(F_pass);
				g.setSize(350, 200);
				g.setLayout(null);
				g.setVisible(true);
				g.setLocationRelativeTo(null);

			}
		});

	}
}
