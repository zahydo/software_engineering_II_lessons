package com.unicauca.openmarketConsumer.domain.entity;

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
@Table(name = "actionProducts")
@Data
public class ActionProducts implements Serializable{
    
    public ActionProducts(Long id, String name, Double price, String action) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.action = action;
    }
    
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    @NotNull(message = "El nombre es obligatorio")
    private String name;

    @Column(name = "price")
    @NotNull(message = "El precio es obligatorio")
    private Double price;

    @Column(name = "action")
    @NotNull(message = "La acción es obligatoria")
    private String action;

    
    
    
}
