package micro.usuario.consumer;

import micro.usuario.model.Usuario;
import micro.usuario.producer.EventSenderMessage;
import micro.usuario.repository.UsuarioRepository;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class EventConsumer {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private EventSenderMessage eventSenderMessage;

    @RabbitListener(queues="usuarioSAGA")
    public void receive(TXCompra txCompra) {
        Date date = new Date();
        SimpleDateFormat dateformat = new SimpleDateFormat("dd-M-yyyy");
        String date_guardar = dateformat.format(date);
        try {
            Date newDate = dateformat.parse(date_guardar);
            Compra compraTemp = new Compra(new CompraPK(
                    txCompra.getCodUser(),
                    txCompra.getCodProd(),
                    newDate),txCompra.getUnidades(),
                    txCompra.getPrecioUnitario());
            compraRepository.save(compraTemp);

            //enviar el evento
            txCompra.setDate(newDate);
            eventSenderMessage.sendMessage(txCompra);

        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @RabbitListener(queues="rollbackUsuario")
    public void receiveRollback(Usuario usuario) {
        //transaccion de compensacion
        Optional<Usuario> usuarioTemp = usuarioRepository.findById(new Usuario(
                txCompra.getCodUser(),
                txCompra.getCodProd(),
                txCompra.getDate()));
        compraRepository.delete(compraTemp.get());
    }
}
