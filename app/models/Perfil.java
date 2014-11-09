package models;

import com.google.code.morphia.annotations.Entity;
import java.util.List;
import play.modules.morphia.Model;

/**
 *
 * @author omar
 */
@Entity
public class Perfil extends Model {

    public String clave;

    public String descripcion;

    public List<Permiso> permisos;

    public Perfil(String clave, String descripcion, List<Permiso> permisos) {
        this.clave = clave;
        this.descripcion = descripcion;
        this.permisos = permisos;
    }

    public Perfil() {
    }

}
