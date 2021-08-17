package com.chandra.demo.services;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.chandra.demo.constants.ProductTypes;
import com.chandra.demo.controllerAdvisordemo.NoProductsFoundException;
import com.chandra.demo.controllerAdvisordemo.ProductNotFoundException;
import com.chandra.demo.productEntitys.Product;
import com.chandra.demo.productRepositories.ProductRepo;

@Service
public class ProductService {

  @Autowired
  private ProductRepo productrepo;

  public void saveProduct(Product entity) {

    productrepo.save(entity);
  }

  public List<Product> getAllProduct() {
    if (productrepo.findAll().isEmpty()) {
      throw new NoProductsFoundException();
    }
    return productrepo.findAll();

  }

  public Product getProduct(Integer id) {

    return this.productrepo.findById(id).orElseThrow(() -> new ProductNotFoundException(id));

  }


  public List<Product> getProductsByProductManufactureDateAfter(String date) {
    List<Product> list = productrepo
        .findAllByProductManufactureDateAfter(LocalDate.parse(date, DateTimeFormatter.ISO_DATE));
    if (list.isEmpty()) {
      throw new NoProductsFoundException(date);
    }
    return list;
  }


  public List<Product> getProductByNameOrType(String name) {

    if (isType(name)) {
      return productrepo.findByProductNameOrProductType(null, name);
    } else {
      return productrepo.findByProductNameOrProductType(name, null);
    }
  }

  private boolean isType(String name) {
    List<Object> list = Arrays.asList(ProductTypes.values());
    if (list != null && !list.isEmpty()) {
      // boolean type = list.stream().map(l ->
      // name.equalsIgnoreCase(l.toString())).findFirst().orElse(null) != null;
      // return type;
      for (Object object : list) {
        if (name.equalsIgnoreCase(object.toString())) {
          return true;
        }
      }
    }
    return false;
  }


  public List<Product> getProductByProductTypeAndProductPrice(String type, String price) {
    if (productrepo.findByProductTypeIgnoreCaseAndProductPrice(type, price).isEmpty()) {

      throw new NoProductsFoundException(price, type);
    }
    return productrepo.findByProductTypeIgnoreCaseAndProductPrice(type, price);

  }

  public List<Product> getProductWithProductName(String name) {

    if (productrepo.findByProductNameContainingIgnoreCase(name).isEmpty()) {
      throw new NoProductsFoundException(name);
    }
    return productrepo.findByProductNameContainingIgnoreCase(name);
  }

  public List<Product> getProductWithProductType(String type) {
    if (productrepo.findByProductTypeContainingIgnoreCase(type).isEmpty()) {
      throw new NoProductsFoundException(type);
    }
    return productrepo.findByProductTypeContainingIgnoreCase(type);
  }

  public List<Product> getProductsNotContainingThisProductsType(String type) {

    if (productrepo.findByProductTypeNotLike(type).isEmpty()) {
      throw new NoProductsFoundException(type);
    }

    return productrepo.findByProductTypeNotLike(type);
  }


  public List<Product> getProductsByProductManufactureDate(String date) {

    if (productrepo
        .findAllByProductManufactureDate(LocalDate.parse(date, DateTimeFormatter.ISO_DATE))
        .isEmpty()) {
      throw new NoProductsFoundException(date);
    }

    return productrepo
        .findAllByProductManufactureDate(LocalDate.parse(date, DateTimeFormatter.ISO_DATE));
  }


  public List<Product> getProductsByProductManufactureDateBefore(String date) {

    if (productrepo
        .findAllByProductManufactureDateBefore(LocalDate.parse(date, DateTimeFormatter.ISO_DATE))
        .isEmpty()) {
      throw new NoProductsFoundException(date);
    }

    return productrepo
        .findAllByProductManufactureDateBefore(LocalDate.parse(date, DateTimeFormatter.ISO_DATE));
  }

}
