package past;

import java.util.Scanner;

import org.junit.Test;
import org.mockito.Mock;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
/**
 * 
 */

/**
 * @author sayanti
 *
 */


public class FindPrimesTest {
	
	@Mock
	Scanner sc;

	@Test
	public void testGenerateInvocation() {
		FindPrimes fp=mock( FindPrimes.class);
		verify(fp).generatePrimeMultiplicationTable(5, "/a/b");
	}
	
	
	
	

}
