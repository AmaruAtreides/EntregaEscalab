package micro.composer.service;

import micro.composer.clients.PeticionFeignClient;
import micro.composer.model.Peticion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PeticionServiceImp implements PeticionService {

    @Autowired
    private PeticionFeignClient peticionFeignClient;

    @Override
    public Optional<Peticion> getPeticion(Integer id) {
        return peticionFeignClient.getPeticion(id);
    }
}
