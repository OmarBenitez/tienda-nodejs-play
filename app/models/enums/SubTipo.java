package models.enums;

/**
 * @author Zacht
 */
public enum SubTipo {
    
    COMPUTO(TipoProducto.ELECTRONICA, "Tv's"),
    VIDEOJUEGOS(TipoProducto.ELECTRONICA, "Audio");
    
    public TipoProducto papa;
    
    public String descripcion;

    private SubTipo(TipoProducto papa, String descripcion) {
        this.papa = papa;
        this.descripcion = descripcion;
    }
    
}
