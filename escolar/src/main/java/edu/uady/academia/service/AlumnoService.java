package edu.uady.academia.service;

import edu.uady.academia.dto.client.LicenciaturaMateriaDTO;
import edu.uady.academia.dto.client.MateriaDTO;
import edu.uady.academia.entity.Alumno;
import edu.uady.academia.entity.Kardex;
import edu.uady.academia.error.ControlEscolarException;
import edu.uady.academia.repository.AlumnoRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Log4j2
public class AlumnoService {

    @Autowired
    AlumnoRepository alumnoRepository;

    public List<Alumno> getAllAlumnos(){
        return alumnoRepository.findAll();
    }

    public Alumno createAlumno(Alumno alumno){
        log.info("crea alumno: "+alumno.toString());
        return alumnoRepository.save(alumno);
    }

    public Alumno updateAlumno(Alumno alumno){

        return alumnoRepository.save(alumno);
    }

    public void deleteAlumno(Long id){

        alumnoRepository.deleteById(id);
    }

}
