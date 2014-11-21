package controllers;

import models.Perfil;
import models.Permiso;
import models.Usuario;
import org.apache.commons.codec.digest.DigestUtils;

/**
 *
 * @author omar
 */
public class Security extends Secure.Security {

    static boolean authenticate(String email, String password) {
        Usuario user = Usuario.find("email", email).first();
        System.out.println(user);
        if (user == null) {
            flash.error("secure.error", user);
        } else {
            if (user.password.equalsIgnoreCase(DigestUtils.md5Hex(password))) {
                session.put(Application.PERFIL_HASH, user.getIdAsStr());
                return true;
            } else {
                flash.error("secure.error", user);
            }
        }
        return false;
    }

    public static boolean check(String profile) {
        try{
            Usuario usuario = Usuario.findById(session.get(Application.PERFIL_HASH));
            Perfil perfil = usuario.perfil;
            Permiso permiso = Permiso.find("clave", profile).first();
            return perfil.tieneDerecho(permiso);
        }catch(Exception ex){
            return false;
        }
    }
     
}
