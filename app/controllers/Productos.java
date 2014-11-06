/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.util.List;
import models.Producto;
import play.mvc.Controller;

/**
 *
 * @author omar
 */
public class Productos extends Controller {

    public static void json() {
        List<Producto> productos = Producto.findAll();
        renderJSON(productos);
    }

    public static void getProducto(String uuid) {
        Producto producto = Producto.findById(uuid);
        notFoundIfNull(producto);
        renderJSON(producto);
    }

}
