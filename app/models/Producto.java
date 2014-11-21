package models;

import com.google.code.morphia.annotations.Entity;
import com.google.code.morphia.annotations.Reference;
import java.util.List;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import models.enums.SubTipo;
import play.data.validation.Required;
import play.modules.morphia.Model;

/**
 *
 * @author Beny
 */
@Entity
public class Producto extends Model {

    public final static String IMG_DEFAULT = "http://upload.wikimedia.org/wikipedia/commons/a/ac/No_image_available.svg";

    @Required
    public String clave;

    @Required
    public String nombre;

    @Required
    public String descripcion;

    @Required
    public Double precio;

    public String urlImg;

    @Enumerated(EnumType.ORDINAL)
    public SubTipo tipoProducto;

    @Reference
    public Oferta oferta;
    
    public Integer rating;

    /**
     * Constructor del Producto
     *
     * @param nombre nombre del producto
     * @param descripcion descripcion del producto
     * @param precio precio del producto
     * @param urlImg ruta de internet de donde agarrar la imagen
     */
    public Producto(String nombre, String descripcion, Double precio, String urlImg) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.urlImg = urlImg;
    }

    /**
     * Constructor vacio en donde se establecen las variables por default
     */
    public Producto() {
        this.urlImg = "http://upload.wikimedia.org/wikipedia/commons/a/ac/No_image_available.svg";
        this.rating = 5;
    }

    public static List<Producto> top10() {
        return Producto.find().order("-rating").limit(10).asList();
    }
}
