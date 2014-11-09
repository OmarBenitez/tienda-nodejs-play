package controllers;

import flexjson.JSONException;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.Perfil;
import models.Usuario;
import org.apache.commons.codec.digest.DigestUtils;

/**
 *
 * @author omar
 */
@CRUD.For(Usuario.class)
public class Usuarios extends CRUD {

    public static void create() throws JSONException {

        Map<String, String[]> values = params.getRootParamNode().originalParams;

        String nombre = values.get("nombre")[0];
        String aPat = values.get("apellidoPaterno")[0];
        String aMat = values.get("apellidoMaterno")[0];
        String email = values.get("email")[0];
        String password = values.get("password")[0];
        Perfil perfil = Perfil.find("clave", "CLIENTE").first();
        Usuario u = Usuario.find("email", email).first();

        if (perfil == null) {
            perfil = new Perfil("CLIENTE", "Perfil para el cliente comun");
        }

        if (u != null) {
            try {
                Secure.authenticate(email, password, true);
            } catch (Throwable ex) {
                Logger.getLogger(Usuarios.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            Usuario usuario = new Usuario(
                    email,
                    nombre,
                    DigestUtils.md5Hex(password),
                    aPat,
                    aMat,
                    perfil
            );
            usuario.validateAndSave();
            try {
                Secure.authenticate(usuario.email, password, true);
                Application.index();
            } catch (Throwable ex) {
                Logger.getLogger(Usuarios.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public static void blank() {
        render();
    }

}
