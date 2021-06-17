package micro.solicitud.repository;

import micro.solicitud.model.Solicitud;
import org.springframework.data.jpa.repository.JpaRepository;


public interface SolicitudRepository extends JpaRepository<Solicitud,Integer> {
}
