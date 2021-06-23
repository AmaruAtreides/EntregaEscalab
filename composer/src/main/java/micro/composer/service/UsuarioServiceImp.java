package micro.composer.service;

import micro.composer.clients.UsuarioFeignClient;
import micro.composer.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioServiceImp implements UsuarioService {

    @Autowired
    private UsuarioFeignClient usuarioFeignClient;

    @Override
    public Optional<Usuario> getUsuario(Integer id) {
        return usuarioFeignClient.getUsuario(id);
    }

}
