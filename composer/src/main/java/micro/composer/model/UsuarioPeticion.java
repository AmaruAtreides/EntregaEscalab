package micro.composer.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioPeticion {

    private Integer id;
    private String problema;
    private String nombreUsuarioSolicitante;
    private String nombreUsuarioResponsable;


}
