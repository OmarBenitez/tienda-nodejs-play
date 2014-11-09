package models;

import com.google.code.morphia.annotations.Entity;
import play.modules.morphia.Model;

/**
 *
 * @author omar
 */
@Entity
public class Direccion extends Model {

    public String calle;

    public String numero;

    public Integer cp;

    public String colonia;

    public Ciudad ciudad;

    public Direccion(String calle, String numero, Integer cp, String colonia, Ciudad ciudad) {
        this.calle = calle;
        this.numero = numero;
        this.cp = cp;
        this.colonia = colonia;
        this.ciudad = ciudad;
    }

    public Direccion() {
    }

}
