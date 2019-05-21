package past;

import java.util.Scanner;

public class ApplicationInput {
	
	
	
	  public  int getIntegerInput(){
	        
	        int n;
	        
	        while(!scanner.hasNextInt()){
	            scanner.next();
	            System.out.println("Please only enter an integer value: ");
	        }
	        n= scanner.nextInt();
	        return n;
	    }
	  

	        public  Scanner scanner;

	        public ApplicationInput()
	        {

	           this(new Scanner(System.in));
	        }

	        
	        ApplicationInput(Scanner scanner)
	        {
	            this.scanner  = scanner;
	        }

	        
}
