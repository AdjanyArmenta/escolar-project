package com.example.sieapi.repository;

import com.example.sieapi.entity.Pago;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PagoRepository extends JpaRepository<Pago,Long> {

    Optional<Pago> findByAlumnoIdAndMateriaId(Long alumnoId, Long materiaId);
}
