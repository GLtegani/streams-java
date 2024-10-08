package ex1.entities;

import java.util.ArrayList;
import java.util.List;

public class Storage {
   private final List<Product> productList = new ArrayList<>();

   public Storage() {
   }

   public final List<Product> getProductList() {
      return productList;
   }

   public final void addProduct(Product product) {
      this.getProductList().add(product);
   }

   public final void removeProduct(Product product) {
      this.getProductList().remove(product);
   }

   public final Double getAveragePrice() {
      Double sum = 0.0;
      for(Product product : this.getProductList()) {
         sum += product.getPrice();
      }
      return sum / this.getProductList().size();
   }

}
