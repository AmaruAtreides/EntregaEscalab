package micro.peticion.repository;

import micro.peticion.model.Peticion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PeticionRepository extends JpaRepository<Peticion, Integer> {

    @Query(value = "SELECT * FROM peticion C WHERE C.usuario_solicitante = ?1", nativeQuery = true)
    List<Peticion> getPeticionesPorUsuarioSolicitante(Peticion id);

}
