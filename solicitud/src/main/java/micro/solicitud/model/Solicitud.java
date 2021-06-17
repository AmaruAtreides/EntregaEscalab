package micro.solicitud.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Column;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="microsolicitud")
public class Solicitud {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "problema", nullable = false)
    private String problema;
    @Column(name = "usuario_solicitante", nullable = false)
    private Integer usuarioSolicitante;
    @Column(name = "usuario_responsable", nullable = false)
    private Integer usuarioResponsable;
}
