package ederson_cardoso_exercise3;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

public class EmployeeTest {

	public static void main(String[] args) {
		// instantiate 3 objects of Employee(Name, Salary)
		Employee emp1 = new Employee("John", 3000.00);
		Employee emp2 = new Employee("Susan", 1500.00);
		Employee emp3 = new Employee("Bob", 2000.00);

		// create an array of objects
		Employee[] employees = { emp1, emp2, emp3 };

		// create a linked list with an array
		LinkedList<Employee> list = new LinkedList<>(Arrays.asList(employees));

		// print unsorted list
		System.out.printf("%n---Unsorted List---");
		System.out.printf("%s%n", list);

		// print sorted list
		System.out.printf("%n---Sorted List---");
		// Sort employees by Salary using Comparator
		Comparator<Employee> EmployeeSalaryComparator = new Comparator<Employee>() {
			@Override
			public int compare(Employee emp1, Employee emp2) {
				return (int) (emp1.getSalary() - emp2.getSalary());
			}
		};

		Collections.sort(list, EmployeeSalaryComparator);
		System.out.printf("%s%n", list);
		
		/**
		 *  This implementation does the same Comparator.comparing and lambda expression
		 */
		// list.sort(Comparator.comparing(Employee::getSalary).thenComparingDouble(Employee::getSalary));
		// System.out.printf("%s%n", list);

	} // end Main

} // end class
