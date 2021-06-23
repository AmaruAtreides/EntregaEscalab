package micro.usuario.consumer;

import micro.usuario.model.Usuario;
import micro.usuario.producer.EventSenderMessage;
import micro.usuario.repository.UsuarioRepository;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.ParseException;
import java.util.Optional;

public class EventConsumer {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private EventSenderMessage eventSenderMessage;

    @RabbitListener(queues="microusuario")
    public void receive(Usuario usuario) {

        Usuario usuarioTemp = new Usuario(usuario.getId(), usuario.getNombre(), usuario.getDescripcion());
        usuarioRepository.save(usuarioTemp);

        //enviar el evento
        eventSenderMessage.sendMessage(usuario);

    }

    @RabbitListener(queues="rollbackUsuario")
    public void receiveRollback(Usuario usuario) {
        //transaccion de compensacion
    //    Optional<Usuario> usuarioTemp = usuarioRepository.findById(new Usuario(usuario.getId()));
      //  usuarioRepository.delete(usuarioTemp.get());
         usuarioRepository.delete(this.usuarioRepository.getOne(usuario.getId()));
            
        }
    }

