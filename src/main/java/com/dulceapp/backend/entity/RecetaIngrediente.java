package com.dulceapp.backend.entity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "receta_ingrediente")
public class RecetaIngrediente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_receta", 
        foreignKey = @ForeignKey(
            name = "FK_receta_ingrediente_receta",
            foreignKeyDefinition = "FOREIGN KEY (id_receta) REFERENCES receta(id) ON DELETE CASCADE"
        ))
    private Receta receta;

    @ManyToOne
    @JoinColumn(name = "id_ingrediente")
    private Ingrediente ingrediente;

    @Column(length = 50)
    private String cantidad;
}
