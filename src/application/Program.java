package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.stream.Collectors;

import entities.Employee;

public class Program {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter full file path: ");
		String path = sc.nextLine();
		System.out.println("Enter salary: ");
		Double salary = sc.nextDouble();

		try (BufferedReader br = new BufferedReader(new FileReader(path))) {

			String line = br.readLine();

			List<Employee> emp = new ArrayList<>();

			while (line != null) {
				String[] fields = line.split(",");
				emp.add(new Employee(fields[0], fields[1], Double.parseDouble(fields[2])));

				line = br.readLine();
			}

			List<String> email = emp.stream().filter(e -> e.getSalary() > salary).map(e -> e.getEmail()).sorted()
					.collect(Collectors.toList());
			System.out.println("Email of people whose salary is more than " + String.format("%.2f", salary));
			email.forEach(System.out::println);

			Double avg = emp.stream().filter(e -> e.getName().charAt(0) == 'M').map(e -> e.getSalary()).reduce(0.0,
					(x, y) -> x + y);

			System.out.println("Sum of slary of people whose name starts with 'M' :" + String.format("%.2f", avg));

		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}

		sc.close();

	}
}
