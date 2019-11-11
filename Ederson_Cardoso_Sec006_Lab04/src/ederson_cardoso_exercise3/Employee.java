package ederson_cardoso_exercise3;

public class Employee {
	private String name;
	private double salary = 0.0;

	// getters and setters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		// validate empty Name
		if (name == null || name.isEmpty()) {
			throw new IllegalArgumentException("Name cannot be null");
		} else {
			this.name = name;
		}
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		// Validate negative value
		if (salary < 0) {
			throw new IllegalArgumentException("Salary cannot be negative");
		} else {
			this.salary = salary;
		}

	}

	/***
	 * This is the default constructor with all parameters
	 * 
	 * @param name
	 * @param salary
	 */
	public Employee(String name, double salary) {
		super();
		this.name = name;
		this.salary = salary;
	}

	/***
	 * This is the toString method
	 */
	@Override
	public String toString() {
		return String.format("%nName: %s \t"
				+ "Salary: $%,.2f", 
				 name, salary);
	}
} // end class
