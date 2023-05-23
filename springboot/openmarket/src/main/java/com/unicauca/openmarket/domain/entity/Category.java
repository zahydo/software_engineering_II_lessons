package com.unicauca.openmarket.domain.entity;
import lombok.Data;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "categories")
@Data
public class Category implements Serializable {
    private static final long serialVersionUID=1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="name")
    @NotNull(message = "El nombre es obligatorio")
    private String name;

    @Column(name = "created_at")
    @Temporal(TemporalType.DATE)
    private Date createdAt;
}
