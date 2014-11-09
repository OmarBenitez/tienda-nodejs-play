package models.enums;

/**
 * @author Zacht
 */

public enum TipoProducto {

    LINEABLANCA("Linea Blanca"),
    ELECTRONICA("Electronica"),
    ROPA("Ropa");

    private final String descripcion;

    private TipoProducto (String descripcion){
        this.descripcion = descripcion;
    }

    public String getDescripcion(){
        return descripcion;
    }
}
