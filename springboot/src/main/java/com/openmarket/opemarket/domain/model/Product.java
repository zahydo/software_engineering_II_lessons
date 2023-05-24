package com.openmarket.opemarket.domain.model;

import java.io.Serializable;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.validation.constraints.Negative;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.persistence.Entity;

import javax.persistence.Id;
import org.springframework.lang.NonNull;

@Entity
@Table(name = "product")
@Data
public class Product implements Serializable  {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name")
    @NotBlank(message = "Name  is obligatory")
    private String name;

    @Column(name = "description")
    @NotBlank(message = "Description is obligatory")
    private String description;

    @Column(name = "price")
    @NonNull
    private long price;
    
      public Product() {
        // Default constructor
    }

  

}
