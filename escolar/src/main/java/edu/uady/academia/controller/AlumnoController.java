package edu.uady.academia.controller;

import edu.uady.academia.entity.Alumno;
import edu.uady.academia.service.AlumnoService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Log4j2
@RequestMapping(value = "/alumno")
public class AlumnoController {

    @Autowired
    private AlumnoService alumnoService;

    @GetMapping()
    public List<Alumno> getAllAlumnos(){
        return alumnoService.getAllAlumnos();
    }

    @PostMapping()
    public Alumno createAlumno(@RequestBody Alumno alumno) throws Exception {
        log.info("Alumno creado" + alumno.toString());
        return alumnoService.createAlumno(alumno);
    }

    @PutMapping
    public Alumno updateAlumno(@RequestBody Alumno alumno){
        return alumnoService.updateAlumno(alumno);
    }

    @DeleteMapping("/{id}")
    public void deleteAlumno(@PathVariable (value = "id") Long id){
        alumnoService.deleteAlumno(id);
    }



}
