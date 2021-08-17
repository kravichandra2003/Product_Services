package com.chandra.demo.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.chandra.demo.productEntitys.Product;
import com.chandra.demo.services.ProductService;

@RestController
public class Controllers {

  @Autowired
  private ProductService service;

  @PostMapping(value = "/saveProducts", consumes = MediaType.APPLICATION_JSON_VALUE,
      produces = MediaType.APPLICATION_JSON_VALUE)
  public void saveProduct(@RequestBody Product entity) {

    service.saveProduct(entity);

  }

  @GetMapping("/getAllProducts")
  public List<Product> getAllProduct() {

    return service.getAllProduct();
  }

  @GetMapping("/getProductsById/{Id}")
  public Product getProductById(@PathVariable Integer Id) {

    return service.getProduct(Id);


  }

  @GetMapping("/getProductsByProductNameOrProductType/{name}")
  public List<Product> getProductByNameOrType(@PathVariable String name) {

    return service.getProductByNameOrType(name);

  }

  @GetMapping("getProductsByProductTypeAndProductPrice/{type}/{price}")
  public List<Product> getProductByProductTypeAndProductPrice(@PathVariable String type,
      @PathVariable String price) {

    return service.getProductByProductTypeAndProductPrice(type, price);

  }

  @GetMapping("/getProductsWithProductName/{name}")
  public List<Product> getProductWithProductName(@PathVariable String name) {

    return service.getProductWithProductName(name);

  }

  @GetMapping("/getProductsWithProductType/{type}")
  public List<Product> getProductWithProductType(@PathVariable String type) {

    return service.getProductWithProductType(type);

  }

  @GetMapping("getProductsNotContainingTheseProductsType/{type}")
  public List<Product> getProductsNotContainingThisProductsType(@PathVariable String type) {

    return service.getProductsNotContainingThisProductsType(type);

  }

  @GetMapping("getProductsByProductManufactureDate/{date}")
  public List<Product> getProductsByProductManufactureDate(@PathVariable String date) {

    return service.getProductsByProductManufactureDate(date);

  }

  @GetMapping("getProductsByProductManufactureDateAfter/{date}")
  public List<Product> getProductsByProductManufactureDateAfter(@PathVariable String date) {

    return service.getProductsByProductManufactureDateAfter(date);

  }

  @GetMapping("getProductsByProductManufactureDateBefore/{date}")
  public List<Product> getProductsByProductManufactureDateBefore(@PathVariable String date) {

    return service.getProductsByProductManufactureDateBefore(date);

  }
}
