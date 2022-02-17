package Domain;

/**
 *
 * @author DANIEL FELIX
 */
public class Articulos {
    
    private int IdArticulo;
    private String Nombre;
    private double Precio;
    private int IdTipoArticulo;
    private String Marca;
    private String Descripcion;
    private String TipoNombre;

    //Para eliminar
    public Articulos(int IdArticulo) {    
        this.IdArticulo = IdArticulo;
    }

    //Este lo uso para crear nuevos articulos
    public Articulos(int IdArticulo, String Nombre, double Precio, int IdTipoArticulo, String Marca, String Descripcion) {
        this.IdArticulo = IdArticulo;
        this.Nombre = Nombre;
        this.Precio = Precio;
        this.IdTipoArticulo = IdTipoArticulo;
        this.Marca = Marca;
        this.Descripcion = Descripcion;
    }
    //Para solicitar con nombre de tipo de articulo
    public Articulos(int IdArticulo, String Nombre,String Marca, double Precio,  String TipoNombre) {
        this.IdArticulo = IdArticulo;
        this.Nombre = Nombre;
        this.Precio = Precio;
        this.Marca = Marca;
        this.TipoNombre = TipoNombre;
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

    public double getPrecio() {
        return Precio;
    }

    public void setPrecio(double Precio) {
        this.Precio = Precio;
    }

    public int getIdTipoArticulo() {
        return IdTipoArticulo;
    }

    public void setIdTipoArticulo(int IdTipoArticulo) {
        this.IdTipoArticulo = IdTipoArticulo;
    }

    public String getMarca() {
        return Marca;
    }

    public void setMarca(String Marca) {
        this.Marca = Marca;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    @Override
    public String toString() {
        return "Articulos{" + "IdArticulo=" + IdArticulo + ", Nombre=" + Nombre + ", Precio=" + Precio + ", IdTipoArticulo=" + IdTipoArticulo + ", Marca=" + Marca + ", Descripcion=" + Descripcion + ", TipoNombre=" + TipoNombre + '}';
    }

    
    
    
}
