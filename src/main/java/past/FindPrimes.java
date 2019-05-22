package past;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.BitSet;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 
 */

/**
 * @author sayanti
 *
 */
public class FindPrimes {
	
	private final static Logger LOGGER = Logger.getLogger(FindPrimes.class.getName());
	
	 public static void main(String[] args) {
		    String jsonFilePath = args[0];
	        System.out.println("Enter the number of primes");
	        int n = new ApplicationInput().getIntegerInput();
	        try{
	        	Instant start = Instant.now();
	        	generatePrimeMultiplicationTable(n,jsonFilePath);
	        	Instant end = Instant.now();
	        	long diffAsMillis = ChronoUnit.MILLIS.between(end, start);
	        	LOGGER.info("Time taken in millis" + diffAsMillis);
	        }
	        catch(Exception e){
	        	LOGGER.log(Level.SEVERE,"Unable to write to console/file"+e.getMessage());
	        }
	    }
	 
	  
	  public static void generatePrimeMultiplicationTable(int n, String jsonFilePath) {
		  
	        PrimeEvaluation p = new PrimeEvaluation();
	        try {
	         Instant start = Instant.now();
	         BitSet bits= p.generatePrimesBitsValues(n);
	         Instant end = Instant.now();
	        	long diffAsMillis = ChronoUnit.MILLIS.between(end, start);
	        	LOGGER.info("Prime numbers bit generation done"+diffAsMillis);
	        	  
	        	  Instant startDisplay = Instant.now();
	        	  DisplayPrimes.displayPrimes(bits,jsonFilePath);
	        	  Instant endDisplay = Instant.now();
	        	  long diff = ChronoUnit.MILLIS.between(endDisplay, startDisplay);
	        	  LOGGER.info("Prime generation display done"+diff);
	         
	    }catch(Exception e)
	        {
	    	LOGGER.log(Level.SEVERE,"Unable to write to file"+e.getMessage());
	        }
	        }
	  


}
