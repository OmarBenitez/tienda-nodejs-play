package controllers;

import java.util.List;
import models.Oferta;
import models.Producto;
import play.modules.morphia.Model;

/**
 *
 * @author omar
 */
public class Ofertas extends CRUD {

    public static void getProds(String id) {

        Oferta oferta = Oferta.findById(id);

        List<Producto> objects = oferta.getProds();

        render(objects, oferta);

    }

    public static void delete(String id) throws Exception {
        ObjectType type = ObjectType.get(getControllerClass());
        notFoundIfNull(type);
        Oferta object = Oferta.findById(id);
        notFoundIfNull(object);
        try {
            if (object.getProds().isEmpty() && object != Oferta.getDefault()) {
                object._delete();
            } else {
                flash.error(play.i18n.Messages.
                        get("crud.delete.error", type.modelName));
                redirect(request.controller + ".list");
            }
        } catch (Exception e) {
            flash.error(play.i18n.Messages.
                    get("crud.delete.error", type.modelName));
            redirect(request.controller + ".list");
        }
        flash.success(play.i18n.Messages.
                get("crud.deleted", type.modelName));
        redirect(request.controller + ".list");
    }

}
