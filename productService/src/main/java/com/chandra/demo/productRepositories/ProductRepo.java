package com.chandra.demo.productRepositories;

import java.time.LocalDate;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.chandra.demo.productEntitys.Product;

@Repository
public interface ProductRepo extends JpaRepository<Product, Integer> {

  List<Product> findByProductTypeIgnoreCaseAndProductPrice(String type, String price);

  // List<Product> findByProductTypeContainingIgnoreCase(String type);

  List<Product> findByProductTypeNotLike(String name);

  List<Product> findByProductNameOrProductType(String name, String type);

  List<Product> findAllByProductManufactureDate(LocalDate date);

  List<Product> findAllByProductManufactureDateAfter(LocalDate date);

  List<Product> findAllByProductManufactureDateBefore(LocalDate date);

  List<Product> findByProductNameContainingIgnoreCase(String name);

  List<Product> findByProductTypeContainingIgnoreCase(String type);


}
