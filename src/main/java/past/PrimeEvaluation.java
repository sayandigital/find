package past;

import java.util.BitSet;

public class PrimeEvaluation {
	
	    int n;
	    
	    public PrimeEvaluation(){
	    }
	    
	    public PrimeEvaluation(int n){
	        this.n = n;
	    }
	
  public BitSet generatePrimesBitsValues(int limit){  
  	int count =1;
		    BitSet bitSet = new BitSet(limit);
		    bitSet.set(0, false);
		    bitSet.set(1, false);
		    bitSet.set(2, true);

		    for (int i = 3; i  < Integer.MAX_VALUE; ++i) {

		       if(isPrime(i))
		       {
		                bitSet.set(i, isPrime(i));
		       count++;
		       }
		       if(count>=limit)
		    	   break;
		            }

        return bitSet;
    }
  
  boolean isPrime(int n){
	//even but is prime
	    if(n==2)
	        return true;
	//even numbers filtered already 
	    if(n==0 || n==1 || n%2==0)
	        return false;

	// loop for checking only odd factors
	// i*i <= n  (same as i<=sqrt(n), avoiding floating point calculations)
	    for(int i=3 ; i*i <=n ; i+=2){
	    // if any odd factor divides n then its not a prime!
	        if(n%i==0)
	            return false;
	    }
	// its prime now
	    return true;
	}
    
   
} 
  


