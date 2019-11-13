package ederson_cardoso_exercise4;

import java.security.SecureRandom;

public class ArrayWriter implements Runnable {
	private final SimpleArray sharedSimpleArray;
	private final int startValue;

	public ArrayWriter(int value, SimpleArray array) {
		startValue = value;
		sharedSimpleArray = array;
	}

	@Override
	public void run() {

		for (int i = startValue; i < startValue + 3; i++) {
			if (startValue == 0) {
				sharedSimpleArray.add(getRandomIntInRange(startValue, startValue + 10)); // add an element to the shared
																							// array
			} else {
				sharedSimpleArray.add(getRandomIntInRange(startValue, startValue + 9)); // add an element to the shared
																						// array
			}
		} // end for
	} // end run

	/**
	 * This method will generate a random integer in a range between min (inclusive)
	 * and max (inclusive).
	 * 
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
