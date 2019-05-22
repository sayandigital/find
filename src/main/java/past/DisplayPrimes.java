package past;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.BitSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Supplier;
import java.util.stream.Stream;

import org.apache.commons.lang3.StringUtils;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import java.util.logging.Logger;
import java.util.logging.Level;




public class DisplayPrimes {
	
	private final static Logger LOGGER = Logger.getLogger(DisplayPrimes.class.getName());
	
	static void displayPrimes(BitSet bits,String jsonFilePath)
	{
		
	Map<Integer , LinkedHashSet<Long>> docIdMap = new ConcurrentHashMap<Integer , LinkedHashSet<Long>>();
	LOGGER.log(Level.INFO, "Bit Length"+bits.length());
	System.out.println(bits.toString());
	try {
		Files.write(Paths.get(jsonFilePath+"0.json"), bits.toString().getBytes());
	} catch (IOException  e1) {
		LOGGER.log(Level.SEVERE, "IO Exception Occured"+e1.getMessage());
	}
	Supplier<Stream<Integer>> streamSupplier 
	  = () -> bits.stream().boxed();
    AtomicInteger counter = new AtomicInteger(0);
    ForkJoinPool forkJoinPool = new ForkJoinPool(16);
    forkJoinPool.submit(() ->
    streamSupplier.get().forEach(p -> {
      int batchNo =  counter.incrementAndGet() ;
      
       processPrimeBits(streamSupplier.get(), p,docIdMap);
       
       Gson gson = new Gson();
       String json = gson.toJson(docIdMap,LinkedHashMap.class);
       if(bits.cardinality() < 100)
       {
       System.out.println(json);
       }
       try {
       	Files.write(Paths.get(jsonFilePath+batchNo+".json"), json.getBytes());
   		        
   	} catch (JsonIOException | IOException e) {
   		// TODO Auto-generated catch block
   		LOGGER.log(Level.SEVERE, "IO Exception Occured"+e.getMessage());
   	}
       docIdMap.clear();
     
       })).join();
    forkJoinPool.shutdown();
   
  }
public static void processPrimeBits(Stream<Integer> iStream, Integer p,Map<Integer , LinkedHashSet<Long>> docIdMap) {
		// TODO Auto-generated method stub
	  LinkedHashSet<Long> valueSet=new LinkedHashSet<Long>();
	  iStream.forEach(x -> {
		  valueSet.add((long)x*p);
	  });
	  docIdMap.put(p, valueSet);
	}



}
