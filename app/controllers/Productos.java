/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.List;
import models.Producto;
import models.enums.SubTipo;
import models.enums.TipoProducto;
import play.modules.paginate.ValuePaginator;

/**
 *
 * @author omar
 */
public class Productos extends CRUD  {

    public static void json() {
        List<Producto> productos = Producto.findAll();
        renderJSON(productos);
    }

    public static void getProducto(String uuid) {
        Producto producto = Producto.findById(uuid);
        notFoundIfNull(producto);
        renderJSON(producto);
    }

    public static void list(){
        List<Producto> productos = Producto.findAll();
        ValuePaginator producto = new ValuePaginator(productos);
        render(producto);
    }

    public static void save(String nombre, String descripcion, String precio, String img){
        Double pre = Double.valueOf(precio);
        Producto producto = new Producto(
          nombre, descripcion, pre, img);
        producto.validateAndSave();
    }
    
    public static void add(){
        
        Gson g = new Gson();
        
        Producto p = g.fromJson(params.get("body"), Producto.class);
        p.urlImg = p.urlImg.equals("") ? Producto.IMG_DEFAULT : p.urlImg;
        p.validateAndSave();
        
        renderJSON(p);
        
    }

    public static void blank(){
        List<SubTipo> tipoProductos = new ArrayList<>();
        render(tipoProductos);
    }

}
