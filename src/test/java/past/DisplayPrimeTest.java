package past;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Stream;

import org.junit.Test;

public class DisplayPrimeTest {
	
	
	@Test
	public void testMultiplicationTableGen() {
		Integer[] intArr = {2, 3, 5};
		Stream<Integer> stream = Arrays.stream(intArr);
		LinkedHashSet<Long> x= new LinkedHashSet<Long>();
		x.add(4L);
		x.add(6L);
		x.add(10L);
		Map<Integer , LinkedHashSet<Long>> docIdMap =new ConcurrentHashMap<Integer , LinkedHashSet<Long>> ();
		
		DisplayPrimes.processPrimeBits(stream, 2 ,docIdMap);
		assertTrue(null!=docIdMap.get(2));
		assertEquals(x,docIdMap.get(2));
	}

}
