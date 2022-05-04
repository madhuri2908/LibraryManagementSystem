package admin_functions;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
@PrepareForTest(ReturnBook.class)
public class ReturnBookTest {

	@Test
	public void returnBookTest() {
		PowerMockito.mockStatic(ReturnBook.class);
		ReturnBook.returnBook();
		PowerMockito.verifyStatic(ReturnBook.class);
		ReturnBook.returnBook();
	}

}