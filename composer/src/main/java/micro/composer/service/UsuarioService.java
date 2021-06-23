package micro.composer.service;

import micro.composer.model.Usuario;

import java.util.Optional;

public interface UsuarioService {

    Optional<Usuario> getUsuario(Integer id);
}
