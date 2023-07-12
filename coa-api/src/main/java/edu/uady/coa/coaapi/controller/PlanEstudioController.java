package edu.uady.coa.coaapi.controller;

import edu.uady.coa.coaapi.entity.PlanEstudio;
import edu.uady.coa.coaapi.error.COAException;
import edu.uady.coa.coaapi.service.PlanEstudioService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/plan-estudios")
@Log4j2
public class PlanEstudioController {

    @Autowired
    private PlanEstudioService planEstudioService;

    @GetMapping
    public ResponseEntity<?> findAllPlanEstudios(){
        try {
            return ResponseEntity.ok().body(planEstudioService.getAllPlanEstudios());
        }catch (COAException ex){
            log.warn("Sin datos");
            log.error(ex);
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping("/{licenciatura-id}")
    public ResponseEntity<?> findLicenciaturaId(@PathVariable(value="licenciatura-id") long licenciatura_id){
        try {
            return ResponseEntity.ok().body(planEstudioService.getLicenciaturaMaterias(licenciatura_id));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }



    @PostMapping
    public ResponseEntity createPlanEstudios(@RequestBody PlanEstudio planEstudio){
        try {
            return new ResponseEntity<>(planEstudioService.createPlanEstudio(planEstudio), HttpStatus.CREATED);
        }catch (COAException ex){
            log.warn("Sin datos");
            log.error(ex);
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    @PutMapping
    public ResponseEntity updatePlanEstudios(@RequestBody PlanEstudio planEstudio){
        try {
            return new ResponseEntity<>(planEstudioService.updatePlanEstudio(planEstudio), HttpStatus.CREATED);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    @DeleteMapping("/{id}")
    public void deletePlanEstudios(@PathVariable Long id){
        planEstudioService.deletePlanEstudio(id);
    }

}
