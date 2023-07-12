package com.example.sieapi.service;

import com.example.sieapi.entity.Pago;
import com.example.sieapi.error.COAException;
import com.example.sieapi.repository.PagoRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Service
@Log4j2
public class PagoService {

    private RestTemplate restTemplate;

    @Autowired
    private PagoRepository pagoRepository;

    public List<Pago> getAllPagos() throws Exception {
        List<Pago> pagoList = pagoRepository.findAll();

        if (pagoList.isEmpty()) {
            throw new COAException("No se encontraron datos");
        }

        return pagoList;
    }

    public Pago createPago(Pago pago) {
        Pago pagoRealizado = pagoRepository.save(pago);
        log.info("Se crea pago: " + pago.toString());
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization","Basic YWRtaW46MTIzNDU2");
        String jsonEmail = "{\n"+
                " \"toUser\":[\"janyaa4a@gmail.com\"],\n" +
                " \"subject\":\"Pago UADY\",\n" +
                "\"message\":\"Envio de email pago "+pagoRealizado.toString()+".\""+
                "}";

        log.info(jsonEmail);
        HttpEntity<String> httpEntity = new HttpEntity<>(jsonEmail,headers);
        restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.exchange("http://localhost:6069/v1/email", HttpMethod.GET,httpEntity,String.class);
        log.info(response.getBody());
        return pagoRealizado;
    }

    public Pago updatePago(Pago pago) throws Exception {
        Optional<Pago> pagoOptional = pagoRepository.findByAlumnoIdAndMateriaId(pago.getAlumnoId(), pago.getMateriaId());

        if (pagoOptional.isPresent()) {
            log.info("Actualizando pago: " + pago.toString());
            return pagoRepository.save(pago);
        }

        throw new COAException("No se encontró el pago: " + pago.toString());
    }

    public void deletePago(Long id) {
        pagoRepository.deleteById(id);
    }
}
