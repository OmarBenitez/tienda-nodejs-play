/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.List;
import models.Oferta;
import models.Producto;
import models.enums.SubTipo;
import models.enums.TipoProducto;
import play.modules.morphia.Model;
import play.modules.paginate.ValuePaginator;
import play.mvc.After;

/**
 *
 * @author omar
 */
public class Productos extends CRUD  {

    @After(only = {"create", "save"})
    public static void redirect(){
        String id = params.get(String.format("object.%s._id", "oferta"));
        Productos.list(id);
    }
    
    public static void list(String id){
        Oferta oferta = Oferta.findById(id);
        oferta = oferta == null ? Oferta.getDefault() : oferta;
        List<Producto> productos = oferta.getProds();
        productos = Producto.findAll();
        ValuePaginator objects = new ValuePaginator(productos);
        render(objects, oferta);
    }
    
    public static void view(String id){
        Producto object = Producto.findById(id);
        render(object);
    }
    

    public static void blank(String id){
        Oferta oferta = Oferta.findById(id);
        Producto object = new Producto();
        object.oferta = oferta;
        render(object);
    }
    
    public static void json(){
        List<Producto> productos = Producto.find().asList();
        renderJSON(productos);
    }

}
