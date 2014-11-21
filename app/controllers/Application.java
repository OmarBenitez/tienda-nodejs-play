package controllers;

import play.*;
import play.mvc.*;

import java.util.*;

import models.*;

@With(Secure.class)
public class Application extends Controller {

    static String PERFIL_HASH = "d5as5d6adasd8asd769asd776ad57as9d9";

    public static void index() {
        List<Producto> objects = Producto.findAll();
        List<Producto> top = Producto.top10();
        Estado.fillEstados();
        Municipio.fillMunicipios();
        Perfil.fillPerfiles();
        Permiso.fillPermisos();
        System.out.println("asdasda");
        render(objects, top);

    }

}
