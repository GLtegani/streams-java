package ex1.application;

import ex1.entities.Product;
import ex1.entities.Storage;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Program {
   public static void main(String[] args) {
      Locale.setDefault(Locale.US);
      Scanner sc = new Scanner(System.in);

      System.out.print("Enter full file path: ");
      String filePath = sc.nextLine();

      try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
         String line = br.readLine();
         Storage storage = new Storage();

         while(line != null) {
            String[] parts = line.trim().split(",");
            String name = parts[0];
            Double price = Double.parseDouble(parts[1]);
            storage.addProduct(new Product(name, price));



            line = br.readLine();
         }

      } catch (IOException e) {
         System.err.print("ERROR:" + e.getMessage());
      }



      sc.close();
   }
}
