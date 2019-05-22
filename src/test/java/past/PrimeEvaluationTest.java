package past;

import static org.junit.Assert.*;

import java.math.BigInteger;
import java.util.BitSet;
import java.util.Random;

import org.junit.Before;
import org.junit.Test;



public class PrimeEvaluationTest {
	
	
	PrimeEvaluation prime;
	@Before
   public void setup() {
		 prime=new PrimeEvaluation();
	}
	@Test
	public void testPrime() {
		assertTrue(prime.isPrime(2));
	}
	
	@Test
	public void testNonPrime() {
		assertFalse(prime.isPrime(4));
	}
	
	@Test
	public void testNonPrime0() {
		assertFalse(prime.isPrime(0));
	}
	
	@Test
	public void testNonPrime1() {
		assertFalse(prime.isPrime(1));
	}
	
	@Test
	public void testNonPrimeRandom() {
		Random r= new Random();
		int number=r.nextInt(Integer.MAX_VALUE);
		BigInteger bigInt = BigInteger.valueOf(number);
	     bigInt.isProbablePrime(100);
	     assertEquals(prime.isPrime(number), bigInt.isProbablePrime(100));
	}
	
	@Test
	public void testBitSetForAValue() {
		BitSet b= new BitSet();
		b.set(2);
		b.set(3);
		b.set(5);
		b.set(7);
		b.set(11);
		BitSet b1=prime.generatePrimesBitsValues(5);
		assertEquals(b1.length(),12);
		assertEquals(b.cardinality(), b1.cardinality());
		assertTrue(b.intersects(b1));
	}
	
	
	
}
