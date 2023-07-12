package edu.uady.coa.coaapi.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MateriaDTO {
    private String clave;
    private String materia;
    private String creditos;
    private String semestre;
}
