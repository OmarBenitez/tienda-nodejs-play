package controllers;

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
                return true;
            } else {
                flash.error("secure.error", user);
            }
        }
        return false;
    }

}
