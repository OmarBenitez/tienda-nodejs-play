package models;

import com.google.code.morphia.annotations.Entity;
import java.util.ArrayList;
import java.util.List;
import play.modules.morphia.Model;
import sun.security.util.Password;

/**
 *
 * @author omar
 */
@Entity
public class Usuario extends Model {

    public String nombre;

    public String password;

    public String apellidoPaterno;

    public String apellidoMaterno;

    public Perfil perfil;

    public List<Direccion> direcciones;

    public Usuario(String nombre, String password, String apellidoPaterno, String apellidoMaterno, Perfil perfil, List<Direccion> direcciones) {
        this.nombre = nombre;
        this.password = password;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.perfil = perfil;
        this.direcciones = direcciones;
    }

    public Usuario() {
        this.direcciones = new ArrayList<Direccion>();
    }

}
