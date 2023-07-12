package com.example.sieapi.repository;

import com.example.sieapi.entity.CostoMateria;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CostoMateriaRepository extends JpaRepository<CostoMateria,Long> {
    Optional<CostoMateria> findCostoMateriaById(Long materiaId);
}
