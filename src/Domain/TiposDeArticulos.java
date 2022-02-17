package Domain;

/**
 *
 * @author DANIEL FELIX
 */
public class TiposDeArticulos {
    
    private int IdArticulo;
    private String Nombre;
    private String Descripcion;

    public TiposDeArticulos(int IdArticulo, String Nombre, String Descripcion) {
        this.IdArticulo = IdArticulo;
        this.Nombre = Nombre;
        this.Descripcion = Descripcion;
    }

    
    
    public int getIdArticulo() {
        return IdArticulo;
    }

    public void setIdArticulo(int IdArticulo) {
        this.IdArticulo = IdArticulo;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }
    
    
}
