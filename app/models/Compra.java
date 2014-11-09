package models;

import com.google.code.morphia.annotations.Entity;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import play.modules.morphia.Model;

/**
 *
 * @author omar
 */
@Entity
public class Compra extends Model {

    public Usuario usuario;

    public List<Producto> productos;

    public Date fecha;

    public Double total;

    public Double subTotal;

    public Double iva;

    public Compra(Usuario usuario, List<Producto> productos, Date fecha, Double total, Double subTotal, Double iva) {
        this.usuario = usuario;
        this.productos = productos;
        this.fecha = fecha;
        this.total = total;
        this.subTotal = subTotal;
        this.iva = iva;
    }

    public Compra() {
        this.productos = new ArrayList<Producto>();
    }

}
