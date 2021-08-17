package com.chandra.demo.productEntitys;

import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@JsonIgnoreProperties({"hibernateLazyInitializer"})
@Entity
@Data
public class Product {

  @Id
  @GeneratedValue
  private Integer productId;
  @NotBlank(message = "Product Name is mandatory")
  private String productName;

  private String productType;

  private String productPrice;
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
  private LocalDate productManufactureDate;
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
  private LocalDate productExpiryDate;


}
