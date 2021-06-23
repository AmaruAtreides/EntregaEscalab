package micro.composer.composer;

import micro.composer.model.Peticion;
import micro.composer.model.Usuario;
import micro.composer.model.UsuarioPeticion;
import micro.composer.service.PeticionService;
import micro.composer.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class PeticionUsuarioComposer {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private PeticionService peticionService;


}
