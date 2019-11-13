package ederson_cardoso_exercise4;

import java.security.SecureRandom;
import java.util.concurrent.ExecutorService;
// Fig. 23.7: SharedArrayTest.java
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class SharedArrayTest {
	public static void main(String[] arg) {
		// construct the shared object
		SimpleArray sharedSimpleArray = new SimpleArray(9);

		
		// create two tasks to write to the shared SimpleArray
		ArrayWriter writer1 = new ArrayWriter(getRandomIntInRange(0,10), sharedSimpleArray); 
		ArrayWriter writer2 = new ArrayWriter(getRandomIntInRange(11,20), sharedSimpleArray);
		ArrayWriter writer3 = new ArrayWriter(getRandomIntInRange(21,30), sharedSimpleArray);


		// execute the tasks with an ExecutorService
		ExecutorService executorService = Executors.newCachedThreadPool();
		executorService.execute(writer1);
		executorService.execute(writer2);
		executorService.execute(writer3);

		executorService.shutdown();

		try {
			// wait 1 minute for both writers to finish executing
			boolean tasksEnded = executorService.awaitTermination(1, TimeUnit.MINUTES);

			if (tasksEnded) {
				System.out.printf("%nContents of SimpleArray:%n");
				System.out.println(sharedSimpleArray); // print contents
			} else {
				System.out.println("Timed out while waiting for tasks to finish.");
			}
		} catch (InterruptedException ex) {
			ex.printStackTrace();
		}
	}
	/**
	 * This method will generate a random integer in a range between min (inclusive) and max (inclusive).
	 * @param min
	 * @param max
	 * @return
	 */
	private static int getRandomIntInRange(int min, int max) {
		// validate max > min
		if (min >= max) {
			throw new IllegalArgumentException("Max must be greater than Min");
		}

		// create random object
		SecureRandom r = new SecureRandom();
		return r.nextInt((max - min) + 1) + min;
      
	} // end method getRandomIntInRange
	
} // end class
