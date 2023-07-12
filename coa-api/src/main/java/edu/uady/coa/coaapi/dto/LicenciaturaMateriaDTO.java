package edu.uady.coa.coaapi.dto;

import edu.uady.coa.coaapi.entity.Materia;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;

import java.util.List;
@Data
@NoArgsConstructor
public class LicenciaturaMateriaDTO {
    private String licenciatura;
    private List<MateriaDTO> materias;

}
