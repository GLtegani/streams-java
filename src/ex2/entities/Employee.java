package ex2.entities;

public class Employee {
   private final String name;
   private final String email;
   private final Double salary;

   public Employee(String name, String email, Double salary) {
      this.name = name;
      this.email = email;
      this.salary = salary;
   }

   public final String getName() {
      return name;
   }

   public final String getEmail() {
      return email;
   }

   public final Double getSalary() {
      return salary;
   }

}
