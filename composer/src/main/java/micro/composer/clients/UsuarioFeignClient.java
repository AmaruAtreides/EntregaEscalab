package micro.composer.clients;


import micro.composer.model.Usuario;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@FeignClient(name = "microusuario")
public interface UsuarioFeignClient {

    @GetMapping("/usuarios/{id}")
    public Optional<Usuario> getUsuario(@PathVariable Integer id);

}
