package admin_functions;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
@PrepareForTest(AddUser.class)
public class AddUserTest {

	@Test
	public void addUserTest() {
		PowerMockito.mockStatic(AddUser.class);
		AddUser.addUser();
		PowerMockito.verifyStatic(AddUser.class);
		AddUser.addUser();
	}

}
