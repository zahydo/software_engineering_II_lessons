package com.openmarket.opemarket.domain.model;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.validation.constraints.NotBlank;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.TemporalType;

@Entity
@Table(name = "category")
@Data
public class Category implements Serializable{
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name")
    @NotBlank(message = "Name  is obligatory")
    private String name;

    @Column(name = "created_at")
    @Temporal(TemporalType.DATE)
    private Date createdAt;
}
