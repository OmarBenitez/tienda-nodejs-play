
package models;

import com.google.code.morphia.annotations.Entity;
import play.modules.morphia.Model;

/**
 *
 * @author omar
 */
@Entity
public class Estado extends Model{
    
    public String clave;
    
    public String descripcion;
    
}
