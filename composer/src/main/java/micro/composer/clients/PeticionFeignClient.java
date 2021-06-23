package micro.composer.clients;

import micro.composer.model.Peticion;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@FeignClient(name = "micropeticion")
public interface PeticionFeignClient {

    @GetMapping("/peticiones/{id}")
    public Optional<Peticion> getPeticion(@PathVariable Integer id);
}
