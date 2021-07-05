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
public class UsuarioPeticionComposer {


    //  List<Usuario> usuarioList = new ArrayList<Usuario>();
    //    List<Peticion> peticionList = new ArrayList<Peticion>();
         List<UsuarioPeticion> usuarioPeticionList = new ArrayList<UsuarioPeticion>();
         List<Peticion> peticionList = peticionService.getPeticiones();
         List<Usuario> usuarioList = usuarioService.getUsuarios();






/**
 *
 *
 *

        List<CompraUsuario> parserCompraUsuario(Integer codUser) {
        List<Compra> compraList = compraService.obtenerCompra(codUser);
        List<CompraUsuario> compraUsuarioList = new ArrayList<CompraUsuario>();
        for(Compra compra : compraList) {
            CompraUsuario compraUsuarioTemp = new CompraUsuario();
            compraUsuarioTemp.setFecha(compra.getCodCompra().getFecha());
            compraUsuarioTemp.setCantidad(compra.getCantidad());

            Producto productoTemp = productoService.getProducto(compra.getCodCompra().getCodProd()).get();

            compraUsuarioTemp.setProducto(productoTemp);

            compraUsuarioList.add(compraUsuarioTemp);
        }

        return compraUsuarioList;
    }
**/

}
