package micro.solicitud.controller;


import micro.solicitud.model.Solicitud;
import micro.solicitud.repository.SolicitudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:8087")
@RestController
@RequestMapping("/solicitudes")
public class SolicitudController {

    @Autowired
    SolicitudRepository solicitudRepository;

    @GetMapping
    public ResponseEntity<List<Solicitud>> getSolicitudes(@RequestParam(required = false) Integer id) {
        try {
            List<Solicitud> solicitudes = new ArrayList<Solicitud>();

            if (id == null)
                solicitudRepository.findAll().forEach(solicitudes::add);

            if  (solicitudes.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(solicitudes, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/solicitudes/{id}")
    public ResponseEntity<Solicitud> getSolicitudById(@PathVariable("id") Integer id) {
        Optional<Solicitud> solicitud = solicitudRepository.findById(id);

        if (solicitud.isPresent()) {
            return new ResponseEntity<>(solicitud.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/solicitudes")
    public ResponseEntity<Solicitud> createSolicitud(@RequestBody Solicitud solicitud) {
        try {
            Solicitud _solicitud = solicitudRepository.save(
                    new Solicitud(solicitud.getId(), solicitud.getProblema(),
                            solicitud.getUsuarioSolicitante(),
                            solicitud.getUsuarioResponsable()));
            return new ResponseEntity<>(_solicitud, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PutMapping("/tutorials/{id}")
    public ResponseEntity<Solicitud> updateSolicitud(@PathVariable("id") Integer id, @RequestBody Solicitud solicitud) {
        Optional<Solicitud> solicitudX = solicitudRepository.findById(id);

        if (solicitudX.isPresent()) {
            Solicitud _solicitud = solicitudX.get();
            _solicitud.setProblema(solicitudX.get().getProblema());
            _solicitud.setUsuarioResponsable(solicitudX.get().getUsuarioResponsable());
            _solicitud.setUsuarioSolicitante(solicitudX.get().getUsuarioSolicitante());
            return new ResponseEntity<>(solicitudRepository.save(_solicitud), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/tutorials/{id}")
    public ResponseEntity<HttpStatus> deleteSolicitud(@PathVariable("id") Integer id) {
        try {
            solicitudRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
