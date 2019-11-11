package ederson_cardoso_exercise3;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;

public class EmployeeTest {

	public static void main(String[] args) {
		
		Employee emp1 = new Employee("John", 3000.00);
		Employee emp2 = new Employee("Susan", 1500.00);
		Employee emp3 = new Employee("Bob", 2000.00);

		Employee[] employees = { emp1, emp2, emp3 };

		LinkedList<Employee> list = new LinkedList<>(Arrays.asList(employees));

		// print unsorted list
		System.out.printf("%n---Unsorted List---");
		System.out.printf("%s%n", list);

		// print sorted list
		System.out.printf("%n---Sorted List---");
		list.sort(Comparator.comparing(Employee::getSalary).thenComparingDouble(Employee::getSalary));
		System.out.printf("%s%n", list);

	} // end Main

} // end class
