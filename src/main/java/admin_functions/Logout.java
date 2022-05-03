package admin_functions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import library_system.Login;

public class Logout {
	public static void logout() {
		Admin.logout.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) {
				Admin.f.dispose();
				Login.login();
			}
		});
	}
}
