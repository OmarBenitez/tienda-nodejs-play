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

    public Municipio municipio;

    public Direccion(String calle, String numero, Integer cp, String colonia, Municipio municipio) {
        this.calle = calle;
        this.numero = numero;
        this.cp = cp;
        this.colonia = colonia;
        this.municipio = municipio;
    }

    public Direccion() {
    }

}
