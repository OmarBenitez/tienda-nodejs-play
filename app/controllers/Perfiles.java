package controllers;

import java.util.List;
import models.Perfil;
import models.Permiso;
import play.i18n.Messages;

/**
 *
 * @author omar
 */
@CRUD.For(Perfil.class)
public class Perfiles extends CRUD {

    /**
     * Método que renderiza una lista de permisos para poder ser seleccionados
     * por el usuario hacia un perfil.
     *
     * @param id UUID del perfil al que pertenecen los permisos.
     */
    public static void permisos(String id) {
        Perfil perfil = Perfil.findById(id);
        List<Permiso> permisos;
        Boolean contiene;
        permisos = Permiso.find().asList();
        for (Permiso permiso : permisos) {
            contiene = perfil.tieneDerecho(permiso);
            permiso.activo = contiene;
        }
        render(permisos, perfil);
    }

    /**
     * Método que agrega permisos al perfil seleccionado.
     *
     * @param id UUID del perfil al que pertenecen los permisos.
     * @param objects permisos contenidos dentro de la Aplicación.
     */
    public static void addPermisos(String id, List<Permiso> objects) {
        Perfil perfil = Perfil.findById(id);
        perfil.permisos.clear();
        objects.stream().filter((permiso) -> (permiso.activo != null)).forEach((permiso) -> {
            perfil.permisos.add(permiso);
        });
        perfil.save();
        flash.success(Messages.get("permisos-ok"));
        permisos(id);
    }

}
