package micro.peticion.controller;


import micro.peticion.model.Peticion;
import micro.peticion.repository.PeticionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;


@RestController
@RequestMapping("/peticiones")
public class PeticionController {

  //  private final PeticionRepository peticionRepository;

   // public PeticionController(PeticionRepository peticionRepository){
  //      this.peticionRepository = peticionRepository;
  //  }

    @Autowired
    PeticionRepository peticionRepository;

    @GetMapping
    public List<Peticion> getPeticiones(){
        return peticionRepository.findAll();
    }

    @GetMapping("/{id}")
    public Peticion getPeticionId(@PathVariable Integer id) {
        return peticionRepository.findById(id).orElseThrow(RuntimeException::new);
    }

  //  @GetMapping
   // public List<Peticion> getPeticionesPorUsuario(@PathVariable Integer id){
   //     return peticionRepository.getPeticionesPorUsuarioSolicitante(this.getPeticionId(id));
  //  }


    @PostMapping
    public ResponseEntity createPeticion(@RequestBody Peticion peticion) throws URISyntaxException {
        Peticion savedPeticion = peticionRepository.save(peticion);
        return ResponseEntity.created(new URI("/peticiones/" + savedPeticion.getId())).body(savedPeticion);
    }

    @PutMapping("/{id}")
    public ResponseEntity updatePeticion(@PathVariable Integer id, @RequestBody Peticion peticion) {
        Peticion currentPeticion = peticionRepository.findById(id).orElseThrow(RuntimeException::new);
        currentPeticion.setProblema(peticion.getProblema());
        currentPeticion.setUsuarioSolicitante(peticion.getUsuarioSolicitante());
        currentPeticion.setUsuarioResponsable(peticion.getUsuarioResponsable());
        currentPeticion = peticionRepository.save(peticion);

        return ResponseEntity.ok(currentPeticion);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletePeticion(@PathVariable Integer id) {
        peticionRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }

}
