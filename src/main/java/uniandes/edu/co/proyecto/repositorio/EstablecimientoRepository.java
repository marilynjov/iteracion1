package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.Establecimiento;
import uniandes.edu.co.proyecto.modelo.TipoEstablecimiento;

public interface EstablecimientoRepository extends JpaRepository<Establecimiento, Integer> {
    @Query(value="SELECT * FROM establecimientos", nativeQuery=true) 
    Collection<Establecimiento> darEstablecimientos();

    @Query(value="SELECT * FROM establecimientos WHERE idservicio = :idservicio", nativeQuery = true)
    Establecimiento darEstablecimiento(@Param("idservicio") Integer idservicio);

    @Modifying
    @Transactional
    @Query(value="INSERT INTO establecimientos (idservicio, estilo,tipo) VALUES(parranderos_sequence.nextval,:estilo,:tipo", nativeQuery=true) 
    void insertarEstablecimiento(@Param("estilo") String estilo,@Param("tipo") TipoEstablecimiento tipoEstablecimiento);

    @Modifying
    @Transactional
    @Query (value ="UPDATE establecimientos SET costoTotal=:costoTotal,capacidad= :capacidad, estilo=:estilo,tipo=:tipo WHERE idservicio=:idservicio", nativeQuery = true)
    void actualizarEstablecimiento(@Param("idservicio") Integer idservicio,@Param("estilo") String estilo,@Param("tipo") TipoEstablecimiento tipo);

    @Modifying
    @Transactional
    @Query (value ="DELETE FROM establecimientos WHERE idservicio=:idservicio", nativeQuery=true)
    void eliminarEstablecimiento(@Param("idservicio") Integer idservicio);
}
