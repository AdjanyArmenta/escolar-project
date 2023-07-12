package edu.uady.academia.repository;

import edu.uady.academia.entity.Alumno;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AlumnoRepository extends JpaRepository<Alumno,Long> {
}
