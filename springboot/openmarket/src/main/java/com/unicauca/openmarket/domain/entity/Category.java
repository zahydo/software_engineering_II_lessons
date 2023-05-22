
package com.unicauca.openmarket.domain.entity;

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
 *
 * @author SANTIAGO
 */


@Entity
@Table(name = "categories")
@Data

public class Category implements Serializable{
    private static final long serialVersionUID = 1L;
    
    @Id 
    @GeneratedValue( strategy =  GenerationType.IDENTITY)
    private long id;
    
    @Column(name = "name")
    @NotNull(message = "El nombre es obligatorio")
    private String name;
}
