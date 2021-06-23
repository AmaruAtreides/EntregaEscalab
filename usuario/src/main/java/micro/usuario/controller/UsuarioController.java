package micro.usuario.controller;


import micro.usuario.model.Usuario;
import micro.usuario.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    UsuarioRepository usuarioRepository;
  //  private final UsuarioRepository usuarioRepository;

   // public UsuarioController(UsuarioRepository usuarioRepository){
    ////  }

    @GetMapping
    public List<Usuario> getUsuarios(){
        return usuarioRepository.findAll();
    }

    @GetMapping("/{id}")
    public Usuario getUsuarioId(@PathVariable Integer id) {
        return usuarioRepository.findById(id).orElseThrow(RuntimeException::new);
    }

    @PostMapping
    public ResponseEntity createClient(@RequestBody Usuario usuario) throws URISyntaxException {
        Usuario savedUsuario = usuarioRepository.save(usuario);
        return ResponseEntity.created(new URI("/usuarios/" + savedUsuario.getId())).body(savedUsuario);
    }

    @PutMapping("/{id}")
    public ResponseEntity updateUsuario(@PathVariable Integer id, @RequestBody Usuario usuario) {
        Usuario currentUsuario = usuarioRepository.findById(id).orElseThrow(RuntimeException::new);
        currentUsuario.setNombre(usuario.getNombre());
        currentUsuario.setDescripcion(usuario.getDescripcion());
        currentUsuario = usuarioRepository.save(usuario);

        return ResponseEntity.ok(currentUsuario);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteClient(@PathVariable Integer id) {
        usuarioRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }

}
