package user_functions;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
@PrepareForTest(UserBooks.class)
public class UserBooksTest {

	@Test
	public void addBookTest() {
		PowerMockito.mockStatic(UserBooks.class);
		UserBooks.userBooks("1");
		PowerMockito.verifyStatic(UserBooks.class);
		UserBooks.userBooks("1");
	}

}
