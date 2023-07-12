package edu.uady.coa.coaapi.controller;


import edu.uady.coa.coaapi.entity.Licenciatura;
import edu.uady.coa.coaapi.error.COAException;
import edu.uady.coa.coaapi.service.LicenciaturaService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/licenciatura")
@Log4j2
public class LicenciaturaController {

    @Autowired
    private LicenciaturaService licenciaturaService;

    @GetMapping
    public ResponseEntity<?> getAllLicenciatura() {
        try {
            return ResponseEntity.ok().body(licenciaturaService.getAllLicenciaturas());
        }catch (COAException ex){
            log.warn("Sin datos");
            log.error(ex);
            return new ResponseEntity<>("datos no encontrados", HttpStatus.OK);
        } catch (Exception e) {
            log.error(e);
            throw new RuntimeException(e);
        }
    }

    @PostMapping
    public Licenciatura createLiceciatura(@RequestBody Licenciatura licenciatura){
        log.info("Licenciatura  a guardar: "+licenciatura.toString());
        return licenciaturaService.createLicenciatura(licenciatura);
    }

    @PutMapping("/{revoe}")
    public ResponseEntity<?> updateLicenciatura(@RequestBody Licenciatura licenciatura, @PathVariable(value = "revoe")String revoe) {
        log.info("Licenciatura a actualizar :"+licenciatura.toString());
        try {
            return  ResponseEntity.ok().body(licenciaturaService.updateLicenciatura(licenciatura,revoe));
        }catch(COAException ex){
            log.warn("Sin datos");
            log.error(ex);
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @DeleteMapping("/{id}")
    public void deleteLicenciatura(@PathVariable (value = "id") Long id){
        licenciaturaService.deleteLicenciatura(id);
    }
}
