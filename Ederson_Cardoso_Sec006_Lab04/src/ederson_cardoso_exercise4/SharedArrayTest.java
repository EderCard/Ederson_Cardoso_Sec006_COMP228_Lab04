package ederson_cardoso_exercise4;

import java.util.concurrent.ExecutorService;
// Fig. 23.7: SharedArrayTest.java
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class SharedArrayTest {
	public static void main(String[] arg) {
		// construct the shared object
		SimpleArray sharedSimpleArray = new SimpleArray(9);

		
		// create two tasks to write to the shared SimpleArray
		ArrayWriter writer1 = new ArrayWriter(0, sharedSimpleArray); 
		ArrayWriter writer2 = new ArrayWriter(11, sharedSimpleArray);
		ArrayWriter writer3 = new ArrayWriter(21, sharedSimpleArray);

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
	
	
} // end class
