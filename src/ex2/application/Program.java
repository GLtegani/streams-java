package ex2.application;

import ex2.entities.Employee;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Program {
   public static void main(String[] args) {
      Locale.setDefault(Locale.US);
      Scanner sc = new Scanner(System.in);

      System.out.print("Enter full file path: ");
      String filePath = sc.nextLine();

      try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
         String line = br.readLine();
         List<Employee> employeeList = new ArrayList<>();

         while(line != null) {
            String[] fields = line.trim().split(",");
            String name = fields[0];
            String email = fields[1];
            Double salary = Double.parseDouble(fields[2]);
            employeeList.add(new Employee(name, email, salary));


            line = br.readLine();
         }

         System.out.print("Enter salary: ");
         Double salary = sc.nextDouble();

         Comparator<String> comparator = Comparator.comparing(String::toUpperCase);

         List<String> employeeEmail = employeeList.stream()
                 .filter(emp -> emp.getSalary() > salary)
                 .map(Employee::getEmail)
                 .sorted(comparator)
                 .toList();

         System.out.println("Email of people whose salary is more than " + String.format("%.2f", salary));
         for(String email : employeeEmail) {
            System.out.println(email);
         }

         Double sumSalary = employeeList.stream()
                 .filter(emp -> emp.getName().toUpperCase().startsWith("M"))
                 .map(Employee::getSalary)
                 .reduce(0.0, Double::sum);

         System.out.println("Sum of salary of people whose name starts with 'M': " + String.format("%.2f", sumSalary));

      } catch (IOException e) {
         System.err.println("Error:" + e.getMessage());
      }



      sc.close();
   }
}
