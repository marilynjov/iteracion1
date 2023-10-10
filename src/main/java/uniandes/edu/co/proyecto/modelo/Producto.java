    package uniandes.edu.co.proyecto.modelo;
import jakarta.annotation.Generated;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Table;   
import jakarta.persistence.Id;
import jakarta.persistence.GenerationType;

@Entity
@Table(name="productos")
public class Producto {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer idproducto;
    private Integer precio;

    public Producto(Integer idproducto, Integer precio) {
        this.idproducto = idproducto;
        this.precio = precio;
    }
    public Producto()
    {;}

    // Getter for idproducto
    public Integer getIdproducto() {
        return idproducto;
    }

    // Setter for idproducto
    public void setIdproducto(Integer idproducto) {
        this.idproducto = idproducto;
    }

    // Getter for precio
    public Integer getPrecio() {    
        return precio;
    }

    // Setter for precio
    public void setPrecio(Integer precio) {
        this.precio = precio;
    }

    
}