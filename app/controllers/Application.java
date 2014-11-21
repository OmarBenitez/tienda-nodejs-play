package controllers;

import play.*;
import play.mvc.*;

import java.util.*;

import models.*;

@With(Secure.class)
public class Application extends Controller {

    public static void index() {
        List<Producto> objects = Producto.findAll();
        List<Producto> top = Producto.top10();
        render(objects, top);
    }

}
