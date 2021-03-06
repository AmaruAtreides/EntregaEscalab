package micro.composer.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Peticion {

    private Integer id;
    private String problema;
    private Integer usuarioSolicitante;
    private Integer usuarioResponsable;

}
