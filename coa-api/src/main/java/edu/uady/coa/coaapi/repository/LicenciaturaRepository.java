package edu.uady.coa.coaapi.repository;

import edu.uady.coa.coaapi.entity.Licenciatura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface LicenciaturaRepository extends JpaRepository<Licenciatura,Long> {
    Optional<Licenciatura> findByRevoe(String revoe);
    Licenciatura findByNombreAndRevoe(String revoe, String nombre);
    @Query("select l from Licenciatura l where l.nombre = :param")
    Optional<Licenciatura> findByOtherParams(String param);
}
