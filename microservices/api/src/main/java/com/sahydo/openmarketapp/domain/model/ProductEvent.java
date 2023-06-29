package com.sahydo.openmarketapp.domain.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Data;

/**
 * @author Santiago Hyun
 */
@Entity
@Table(name = "products")
@Data
public class ProductEvent implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id // This makes the id as primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    @NotNull(message = "El nombre es obligatorio")
    private String name;

    @Column(name = "price")
    @NotNull(message = "El precio es obligatorio")
    private Double price;

    @Column(name = "action")
    @NotNull(message = "La accion es obligatoria")
    private String action;

    @Column(name = "holderEmail")
    @NotNull(message = "El correo es obligatorio")
    private String holderEmail;

}
