package models.enums;

/**
 * @author Zacht
 */
public enum SubTipo {

    TVS(TipoProducto.ELECTRONICA, "Tv's"),
    COMPUTO(TipoProducto.ELECTRONICA, "Computadora"),
    VIDEOJUEGOS(TipoProducto.ELECTRONICA, "Video Juegos"),
    CAMARAS(TipoProducto.ELECTRONICA, "Camaras"),
    CDS(TipoProducto.ELECTRONICA, "CD's"),

    CAMISAS(TipoProducto.ROPA, "Caisas"),
    BLUSAS(TipoProducto.ROPA, "Blusas"),
    PANTALONES(TipoProducto.ROPA, "Pantalones"),
    SHORTS(TipoProducto.ROPA, "Shorts"),
    INTERIOR(TipoProducto.ROPA, "Ropa Interior"),

    COCINA(TipoProducto.LINEABLANCA, "Cocina"),
    LAVADO(TipoProducto.LINEABLANCA, "Lavado"),
    REFRIGERADOR(TipoProducto.LINEABLANCA, "Refrigeradores"),
    UTENSILIOS(TipoProducto.LINEABLANCA, "Utensilios"),
    MICROONDAS(TipoProducto.LINEABLANCA, "Microondas");


    public String descripcion;
    public TipoProducto papa;

    SubTipo (TipoProducto papa, String descripcion){
        this.papa = papa;
        this.descripcion = descripcion;
    }

}

