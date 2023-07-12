package edu.uady.academia.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Kardex {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "folio")
    private String folioKardex;

    @Column(name = "materia_id",nullable = false,precision = 30)
    private Long materia;

    @Column(name = "calificacion" ,nullable = false, precision = 6)
    private double calificacion;

    @Column(name = "aprobado")
    private Boolean aprobado;

    @ManyToOne
    @JoinColumn(name="alumno_id")
    @JsonIgnoreProperties("kardexs") // Ignora la propiedad kardexs de la entidad Alumno durante la serialización
    private Alumno alumno;
}
