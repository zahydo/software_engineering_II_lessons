package com.unicauca.openmarket.domain.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;
import javax.persistence.*;

import lombok.Data;

@Entity
@Table(name = "products")
@Data
public class Product implements Serializable {

    private static final  Long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    @NotNull(message = "El nombre es obligatorio")
    private String name;
    @Column(name ="description")
    private String description;
    @Column(name = "price")
    @NotNull(message = "El precio es obligatorio")
    private Double price;
    @Column(name = "created_at")
    @Temporal(TemporalType.DATE)
    private Date createdAt;
}