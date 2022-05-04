package admin_functions;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
@PrepareForTest(ViewBooks.class)
public class ViewBooksTest {

	@Test
	public void viewBookTest() {
		PowerMockito.mockStatic(ViewBooks.class);
		ViewBooks.viewBooks();
		PowerMockito.verifyStatic(ViewBooks.class);
		ViewBooks.viewBooks();
	}

}