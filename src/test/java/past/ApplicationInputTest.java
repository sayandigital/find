package past;

import java.util.Scanner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;

import org.junit.Test;

public class ApplicationInputTest {

	
	
	
	@Test
	public void shouldTakeUserInput() {
	    //create a mock scanner
	    //set up the scanner
		Scanner mockScanner = mock(Scanner.class);
	    //set up the scanner
		 when(mockScanner.hasNextInt()).thenReturn(true);
	    when(mockScanner.nextInt()).thenReturn(5);

	    ApplicationInput inputOutput= new ApplicationInput(mockScanner);

	    //assert output
	    assertEquals(5, inputOutput.getIntegerInput());

	   
	}
	
}
