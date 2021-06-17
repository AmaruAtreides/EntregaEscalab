package micro.peticion.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="peticion")
public class Peticion {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "problema", nullable = false)
    private String problema;
    @Column(name = "usuario_solicitante", nullable = false)
    private Integer usuarioSolicitante;
    @Column(name = "usuario_responsable", nullable = false)
    private Integer usuarioResponsable;
}
