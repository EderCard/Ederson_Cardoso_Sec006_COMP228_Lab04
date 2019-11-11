package ederson_cardoso_exercise1;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class SetTest {
	// create a List<String> of names
	static String[] names = { "JOHN", "SUSAN", "BOB", "RICHARD", "BOB" };
	static List<String> list = new LinkedList<>(Arrays.asList(names));
	// create a scanner to read data
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {

		int option = 999;
		while (option != 0) {
			System.out.println("---Main Menu---");
			System.out.println("[1] Print names");
			System.out.println("[2] Print non duplicated names");
			System.out.println("[3] Add name");
			System.out.println("[4] Search name");
			System.out.println("[0] Exit ");
			System.out.println();
			System.out.print("Enter an option: ");

			try {
				option = scanner.nextInt();
			} catch (java.util.InputMismatchException e) {
				System.out.println(" Invalid Option.");
				option = 0;
			}

			switch (option) {
			case 1:
				printList(list);
				break;
			case 2:
				printNonDuplicates(list);
				break;
			case 3:
				addName(list);
				break;
			case 4:
				searchName(list);
				break;
			case 0:
				System.out.printf("%n***Program terminated***");
				break;
			default:
				System.out.println(" Invalid number: [0 - 4]");
			} // end switch
		} // end while

		scanner.close();

	} // end main

	/**
	 * This method prints values from a list collection
	 * 
	 * @param values
	 */
	private static void printList(Collection<String> values) {
		System.out.printf("%n Initial list: %s%n", values);
		System.out.println();
	} // end method printList

	/**
	 * This method prints a non duplicated values form a list collection
	 * 
	 * @param values
	 */
	private static void printNonDuplicates(Collection<String> values) {
		// create a HashSet
		Set<String> set = new HashSet<>(values);
		System.out.printf("%n Non-duplicated names are: ");

		for (String value : set) {
			System.out.printf("%s ", value);
		}

		System.out.println();
		System.out.println();
	} // end method printNonDuplicates

	/**
	 * This method adds a value to a list collection
	 * 
	 * @param values
	 */
	private static void addName(Collection<String> values) {
		System.out.printf("%n Enter a name: ");
		String name = scanner.next().toUpperCase();
		values.add(name);
		System.out.printf("%n New list is: %s%n", values);
		System.out.println();
	} // end method addName

	/**
	 * This method search for a value in a list collection
	 * 
	 * @param values
	 */
	private static void searchName(Collection<String> values) {
		System.out.printf("%n Enter a name to search: ");
		String name = scanner.next().toUpperCase();

		// sort a list collection
		Collections.sort(list);
		int position = Collections.binarySearch(list, name);
		if (position >= 0) {
			System.out.printf("%n%s is in the list.%n", name);
		} else {
			System.out.printf("%n%s not found.%n", name);
		}
		System.out.println();
	} // end method searchName

} // end class