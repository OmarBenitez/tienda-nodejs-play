package models;

import com.google.code.morphia.annotations.Entity;
import java.util.Date;
import play.modules.morphia.Model;

/**
 *
 * @author omar
 */
@Entity
public class Mensaje extends Model {

    public String contenido;

    public Date envio;

    public Usuario emisor;

    public Usuario receptor;

    public Mensaje(String contenido, Date envio, Usuario emisor, Usuario receptor) {
        this.contenido = contenido;
        this.envio = envio;
        this.emisor = emisor;
        this.receptor = receptor;
    }

    public Mensaje() {
    }

}
