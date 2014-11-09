package models;

import com.google.code.morphia.annotations.Entity;
import java.util.List;
import play.data.validation.Unique;
import play.modules.morphia.Model;

/**
 *
 * @author omar
 */
@Entity
public class Oferta extends Model {

    @Unique
    public String clave;

    public String descripcion;

    public Double descuento;

    public Oferta(String clave, String descripcion, Double desc) {
        this.clave = clave;
        this.descripcion = descripcion;
        this.descuento = desc;
    }

    public Oferta() {
    }

    public List<Producto> getProds() {
        return Producto.find("oferta", this).asList();
    }

    public static Oferta getDefault() {
        Oferta o = Oferta.find("clave", "DEF").first();
        if (o == null) {
            o = new Oferta("DEF", "No aplica ningun descuento", 0.0);
            o.validateAndSave();
        } 
        return o;
    }

}
