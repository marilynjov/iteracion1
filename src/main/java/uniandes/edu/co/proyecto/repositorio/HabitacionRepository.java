package uniandes.edu.co.proyecto.repositorio;

import uniandes.edu.co.proyecto.modelo.Habitacion;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import jakarta.transaction.Transactional;


public interface HabitacionRepository extends JpaRepository<Habitacion, Integer>{
    @Query(value = "SELECT * FROM habitaciones", nativeQuery = true)
    Collection<Habitacion> darHabitaciones();

    @Query(value = "SELECT * FROM habitaciones WHERE idhabitacion = :idhabitacion", nativeQuery = true)
    Habitacion darHabitacion(@Param("idhabitacion") int idhabitacion);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO habitaciones (idhabitacion, capacidad, disponible, tipo, dotacion, precionoche,nombrehotel) VALUES (parranderos_sequence.nextval, :capacidad, :disponible, :tipo, :dotacion, :precionoche, :nombrehotel)", nativeQuery = true)
    void insertarHabitacion(@Param("capacidad") int capacidad, @Param("disponible") Boolean disponible, @Param("tipo") String tipo, @Param("dotacion") String dotacion, @Param("precionoche") int precionoche, @Param("nombrehotel") String nombrehotel);

    @Modifying
    @Transactional
    @Query(value = "UPDATE habitaciones SET capacidad = :capacidad, disponible = :disponible, tipo = :tipo, dotacion = :dotacion, precionoche = :precionoche WHERE idhabitacion = :idhabitacion", nativeQuery = true)
    void actualizarHabitacion(@Param("idhabitacion") int idHabitacion, @Param("capacidad") int capacidad, @Param("disponible") Boolean disponible, @Param("tipo") String tipo, @Param("dotacion") String dotacion, @Param("precionoche") int precioNoche);
    
    @Modifying
    @Transactional
    @Query(value = "DELETE FROM habitaciones WHERE idhabitacion = :idhabitacion", nativeQuery = true)
    void eliminarHabitacion(@Param("idhabitacion") int idhabitacion);
    
}

