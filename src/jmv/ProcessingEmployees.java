package jmv;

// Processing streams of Employee objects.
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ProcessingEmployees
{
	public static void main(String[] args)
	{
		// initialize array of Employees
		Employee[] employees = {
				new Employee("Jason", "Red", 5000, "IT"),
				new Employee("Ashley", "Green", 7600, "IT"),
				new Employee("Matthew", "Indigo", 3587.5, "Sales"),
				new Employee("James", "Indigo", 4700.77, "Marketing"),
				new Employee("Luke", "Indigo", 6200, "IT"),
				new Employee("Jason", "Blue", 3200, "Sales"),
				new Employee("Wendy", "Brown", 4236.4, "Marketing")};
	
			// get List view of the Employees
			List<Employee> list = Arrays.asList(employees);

			// sum of Employee salaries with DoubleStream sum method
			 System.out.printf("%nSum of Employees' salaries (via sum method): %.2f%n",
			 list.stream()
			 .mapToDouble(Employee::getSalary)
			 .sum());
			
			 // calculate sum of Employee salaries with Stream reduce method
			 System.out.printf(
			 "Sum of Employees' salaries (via reduce method): %.2f%n",
			 list.stream()
			 .mapToDouble(Employee::getSalary)
			 .reduce(0, (value1, value2) -> value1 + value2));
			
			 // average of Employee salaries with DoubleStream average method
			 System.out.printf("Average of Employees' salaries: %.2f%n",
			 list.stream()
			 .mapToDouble(Employee::getSalary)
			 .average()
			 .getAsDouble());
					 
	}
} //end class