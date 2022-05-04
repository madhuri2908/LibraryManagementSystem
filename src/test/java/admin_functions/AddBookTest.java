package admin_functions;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
@RunWith(PowerMockRunner.class)
@PrepareForTest(AddBook.class)
public class AddBookTest {
	
	@Test
	public void addBookTest() {
		PowerMockito.mockStatic(AddBook.class);
        AddBook.addBook();
        PowerMockito.verifyStatic(AddBook.class);
        AddBook.addBook();
	}

}
