package micro.composer.controller;


import micro.composer.composer.UsuarioPeticionComposer;
import micro.composer.model.UsuarioPeticion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ComposerController {

    @Autowired
    private UsuarioPeticionComposer peticionUsuarioComposer ;

    @GetMapping("/usuariopeticion/")
    public List<UsuarioPeticion> getPeticionUsuario(//@PathVariable Integer id
                                                     ){
    //    return PeticionUsuarioComposer.parserPeticionUsuario(id);
        return null;
    }



}
