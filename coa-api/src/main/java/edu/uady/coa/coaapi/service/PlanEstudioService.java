package edu.uady.coa.coaapi.service;

import edu.uady.coa.coaapi.dto.LicenciaturaMateriaDTO;
import edu.uady.coa.coaapi.dto.MateriaDTO;
import edu.uady.coa.coaapi.entity.PlanEstudio;
import edu.uady.coa.coaapi.error.COAException;
import edu.uady.coa.coaapi.repository.PlanEstudioRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Log4j2
@Service
public class PlanEstudioService {

    @Autowired
    private PlanEstudioRepository planEstudioRepository;

    public PlanEstudio createPlanEstudio(PlanEstudio planEstudio) throws Exception {
        log.info("crea PlanEstudio: "+planEstudio.toString());
        Optional<PlanEstudio> existePlanEstudios = planEstudioRepository.findByLicenciatura_RevoeAndAndMateriaClaveMateria(planEstudio.getLicenciatura().getRevoe(),
                        planEstudio.getMateria().getClaveMateria());
        if(!existePlanEstudios.isPresent()){
            log.info("inserta PlanEstudio: "+planEstudio.toString());
            return planEstudioRepository.save(planEstudio);
        }
        throw new COAException("Ya existe una materia asignada a esta licenciatura");
    }

    public PlanEstudio updatePlanEstudio(PlanEstudio planEstudio) throws COAException {
        if(planEstudio.getId()== null){
            throw new COAException("No se puede actualizar este plan de estudios");
        }
        Optional<PlanEstudio> existePlanEstudio = planEstudioRepository.findByLicenciatura_RevoeAndAndMateriaClaveMateria(planEstudio.getLicenciatura().getRevoe(), planEstudio.getMateria().getClaveMateria());
        if(existePlanEstudio.isPresent()){
            log.info("Actualiza Plan Estudio:"+planEstudio.toString());
            return planEstudioRepository.save(planEstudio);
        }
        throw new COAException("No existe el plan de estudios");
    }

    public LicenciaturaMateriaDTO getLicenciaturaMaterias(Long licenciatura_id){
       List<PlanEstudio> planEstudios = planEstudioRepository.findPlanEstudioByLicenciatura_Id(licenciatura_id);
       log.info(planEstudios.toString());
       LicenciaturaMateriaDTO dto = new LicenciaturaMateriaDTO();
        dto.setLicenciatura(planEstudios.get(0).getLicenciatura().getNombre());
        List<MateriaDTO> materiaDTO = new ArrayList<>();
        planEstudios.stream().forEach(pe-> {
            MateriaDTO materia = new MateriaDTO();
            materia.setClave(pe.getMateria().getClaveMateria());
            materia.setMateria(pe.getMateria().getNombreMateria());
            materia.setSemestre(String.valueOf(pe.getSemestre()));
            materia.setCreditos(String.valueOf(pe.getCreditos()));
            materiaDTO.add(materia);
        });
        dto.setMaterias(materiaDTO);
        return dto;
    }
    public List<PlanEstudio> getAllPlanEstudios() throws Exception{
        List planEstudios = planEstudioRepository.findAll();
        if(planEstudios.isEmpty()){
            throw new COAException("No se encontraron datos");
        }
        return planEstudios;
    }


    public void deletePlanEstudio(Long id){
        planEstudioRepository.deleteById(id);
    }

}