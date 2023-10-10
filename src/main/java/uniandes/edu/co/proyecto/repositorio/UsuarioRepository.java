package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.Hotel;
import uniandes.edu.co.proyecto.modelo.Usuario;

public interface UsuarioRepository extends JpaRepository <Usuario, Integer>{
    

    @Query(value = "SELECT * FROM usuarios", nativeQuery = true)
    Collection<Usuario> darUsuarios();

    @Query(value = "SELECT * FROM usuarios WHERE idusuario= :idusuario", nativeQuery = true)
    Usuario darUsuario(@Param("idusuario") Integer idusuario);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO usuarios(idusuario, nombre, correo, rol, nombrehotel) VALUES (parranderos_sequence.nextval, :nombre, :correo, :rol, :nombrehotel)", nativeQuery = true)
    void insertarUsuario(@Param("nombre") String nombre, @Param("correo") String correo, @Param("rol") String rol, @Param("nombrehotel") String nombrehotel);

    @Modifying
    @Transactional
    @Query(value ="UPDATE usuarios SET nombre= :nombre, correo= :correo, rol= :rol WHERE idusuario = :idusuario", nativeQuery = true)
    void actualizarUsuario(@Param("idusuario") Integer idusuario, @Param("nombre") String nombre, @Param("correo") String correo, @Param("rol") String rol);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM usuarios WHERE idusuario= :idusuario", nativeQuery = true)
    void eliminarUsuario(@Param("idusuario") Integer idusuario);
}

