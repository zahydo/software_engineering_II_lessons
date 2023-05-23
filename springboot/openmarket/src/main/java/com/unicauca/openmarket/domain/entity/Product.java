
package com.unicauca.openmarket.domain.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import lombok.Data;

/**
 *
 * @author brayan
 */
@Entity //va ser mapeado como unatabla
@Table(name="products")// la tabla se va llamar productos
@Data//Genera constructores,getters/setters and toString

public class Product  implements Serializable{
   
    
   private static final long serialVersionUID=1L; 
   @Id//esta va ser nuestra primary key
   @GeneratedValue(strategy=GenerationType.IDENTITY)//esto hace que la variable sea auto incremental
   private Long id;
   
   @Column(name="name")
   @NotNull(message="El nombre es obligatorio")
   private String name;
   @Column(name="description")
   private String description;
   @Column(name="price")
   @NotNull(message="el precio es obligatorio")
   private Double price;
   @Column(name="created_at")
   @Temporal(TemporalType.DATE)
   private Date createdAt;
    
}
