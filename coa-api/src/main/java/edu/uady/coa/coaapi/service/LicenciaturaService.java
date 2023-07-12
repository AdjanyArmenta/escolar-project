package edu.uady.coa.coaapi.service;

import edu.uady.coa.coaapi.dto.LicenciaturaMateriaDTO;
import edu.uady.coa.coaapi.entity.Licenciatura;
import edu.uady.coa.coaapi.entity.PlanEstudio;
import edu.uady.coa.coaapi.error.COAException;
import edu.uady.coa.coaapi.repository.LicenciaturaRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Log4j2
@Service
public class LicenciaturaService {

    @Autowired
    private LicenciaturaRepository licenciaturaRepository;

    public Licenciatura createLicenciatura(Licenciatura licenciatura){
        log.info("Crea licenciatura:"+licenciatura.toString());
        return licenciaturaRepository.save(licenciatura);
    }

    public Licenciatura updateLicenciatura(Licenciatura licenciatura,String revoe) throws COAException {
        Optional<Licenciatura> optionalLicenciatura = licenciaturaRepository.findByRevoe(revoe);
        if(optionalLicenciatura.isPresent()){
            log.info("Actualiza licenciatura:"+licenciatura.toString());
            return licenciaturaRepository.save(licenciatura);
        }
        throw new COAException("No existe la licenciatura con el revoe");
    }

    public LicenciaturaMateriaDTO getLicenciaturaMaterias(Long licenciatura_id) throws Exception{
        return null;
    }
    public List<Licenciatura> getAllLicenciaturas() throws Exception {
        List licenciaturas = licenciaturaRepository.findAll();
        if(licenciaturas.isEmpty()){
            throw new COAException("No se encontraron datos");
        }
        return licenciaturas;
    }

    public void deleteLicenciatura(Long id){
        licenciaturaRepository.deleteById(id);
    }
}
