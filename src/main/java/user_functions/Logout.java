package user_functions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import library_system.Login;

public class Logout {
	public static void logout() {
		User.logout.addActionListener(new ActionListener() { // Perform action
			public void actionPerformed(ActionEvent e) {
				User.f.dispose();
				Login.login();
			}
		});
	}
}
