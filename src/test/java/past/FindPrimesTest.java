package past;

import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Assert;
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
	public void testGenerateInvocation() throws URISyntaxException, IOException {
		FindPrimes fp=mock( FindPrimes.class);
		fp.generatePrimeMultiplicationTable(2, "");
		String expectedData = "{2, 3}";
		String expectedData1 = "{\"2\":[4,6]}";
		String expectedData2 = "{\"3\":[6,9]}";
	    Path path = Paths.get("0.json");
	    Path path1 = Paths.get("1.json");
	    Path path2 = Paths.get("2.json");      
	    String data = extractFileData(path);
	    
	    String data1 = extractFileData(path1);
	    String data2 = extractFileData(path2);
	          
	    Assert.assertEquals(expectedData, data.trim());
	    Assert.assertEquals(expectedData1, data1.trim());
	}

	private String extractFileData(Path path) throws IOException {
		Stream<String> lines = Files.lines(path);
	    String data = lines.collect(Collectors.joining("\n"));
	    lines.close();
		return data;
	}
	
	
	
	

}
