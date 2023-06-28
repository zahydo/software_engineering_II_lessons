package com.unicauca.consumercategory.domain.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Entity
@Table(name = "categories")
@Data // Generare constructor, getters and setters and ToString methods
public class CategoryEvent implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id // This makes the id as primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    @NotNull(message = "El nombre es obligatorio")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "action")
    @NotNull(message = "La accion es obligatoria")
    private String action;

    @Column(name = "holderEmail")
    @NotNull(message = "El correo es obligatorio")
    private String holderEmail;
}
