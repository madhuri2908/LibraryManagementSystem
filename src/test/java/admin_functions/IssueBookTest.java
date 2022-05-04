package admin_functions;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
@PrepareForTest(IssueBook.class)
public class IssueBookTest {

	@Test
	public void issueBookTest() {
		PowerMockito.mockStatic(IssueBook.class);
		IssueBook.issueBook();
		PowerMockito.verifyStatic(IssueBook.class);
		IssueBook.issueBook();
	}

}