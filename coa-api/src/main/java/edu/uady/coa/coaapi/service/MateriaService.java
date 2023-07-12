package edu.uady.coa.coaapi.service;

import edu.uady.coa.coaapi.entity.Licenciatura;
import edu.uady.coa.coaapi.entity.Materia;
import edu.uady.coa.coaapi.error.COAException;
import edu.uady.coa.coaapi.repository.LicenciaturaRepository;
import edu.uady.coa.coaapi.repository.MateriaRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Log4j2
@Service
public class MateriaService {

    @Autowired
    private MateriaRepository materiaRepository;

    public Materia createMateria(Materia materia){
        log.info("Crea Materia:"+materia.toString());
        return materiaRepository.save(materia);
    }

    public Materia updateMateria(Materia materia){
        log.info("Actualiza Materia:"+materia.toString());
        return materiaRepository.save(materia);

    }

    public List<Materia> getAllMaterias() throws Exception {
        List materias = materiaRepository.findAll();
        if(materias.isEmpty()){
            throw new COAException("No se encontraron datos");
        }
        return materias;
    }

    public void deleteMateria(Long id){
        materiaRepository.deleteById(id);
    }
}