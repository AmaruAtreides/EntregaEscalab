package micro.composer.service;

import micro.composer.model.Peticion;

import java.util.List;
import java.util.Optional;

public interface PeticionService {

    Optional<Peticion> getPeticion(Integer id);
}
