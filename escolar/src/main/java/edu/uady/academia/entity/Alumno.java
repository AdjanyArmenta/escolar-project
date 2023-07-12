package edu.uady.academia.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Entity
@Table(name="alumnos")
@Data
@NoArgsConstructor
@ToString
public class Alumno {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name="matricula")
    private String matricula;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "apellidos")
    private String apellidos;

    @Column(name="edad")
    private int edad;

    @Column(name = "sexo",precision = 1,length = 1)
    private char sexo;

    @Column(name="licenciatura_id")
    private Long licenciaturaId;

    // Relación con la tabla de kardex
    @OneToMany(fetch=FetchType.LAZY,mappedBy = "alumno")
    private List<Kardex> kardexs;
}
