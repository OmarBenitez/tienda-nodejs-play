package models;

import com.google.code.morphia.annotations.Entity;
import java.util.ArrayList;
import java.util.List;
import play.modules.morphia.Model;

/**
 *
 * @author omar
 */
@Entity
public class Usuario extends Model {

    public String email;

    public String nombre;

    public String password;

    public String apellidoPaterno;

    public String apellidoMaterno;

    public Perfil perfil;

    public List<Direccion> direcciones;

    public Usuario(String email, String nombre, String password, String apellidoPaterno, String apellidoMaterno, Perfil perfil) {
        this.email = email;
        this.nombre = nombre;
        this.password = password;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.perfil = perfil;
        this.direcciones = new ArrayList<Direccion>();
    }

    public Usuario() {
        this.direcciones = new ArrayList<Direccion>();
    }
    
    @Override
    public String toString(){
        return String.format("%s - %s", this.email, this.nombre);
    }

}
