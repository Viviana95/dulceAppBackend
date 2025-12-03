package com.dulceapp.backend.entity;
import java.time.LocalDateTime;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "favorito")
public class Favorito {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch= FetchType.EAGER)
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    @ManyToOne(fetch= FetchType.EAGER)
    @JoinColumn(name = "id_receta")
    private Receta receta;

    @Column(nullable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime fechaGuardado;
    @PrePersist
    public void prePersist() {
        if (fechaGuardado == null) {
            fechaGuardado = LocalDateTime.now();
        }
    }
}
