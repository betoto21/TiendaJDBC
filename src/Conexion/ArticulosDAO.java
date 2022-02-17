package Conexion;

import Domain.Articulos;
import java.util.List;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author DANIEL FELIX
 */
public class ArticulosDAO{
    
    private static final String SQL_SELECT = "select * from tblArticulo";
    private static final String SQL_INSERT = "insert into tblArticulo(IDarticulo, Nombre, precio, IDtipoArt, marca, Descripcion) values (?, ?, ?, ?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE tblArticulo SET Nombre = ? ,precio = ? , IDtipoArt = ? , marca = ? , Descripcion = ? WHERE IDarticulo = ?";
    private static final String SQL_DELETE = "DELETE from tblArticulo WHERE IDarticulo = ? ";

    public ArticulosDAO() {
    }
    
    public List<Articulos> seleccionarTodo() {
        Connection conexion = null;
        PreparedStatement preparar = null;
        ResultSet resultado = null;
        Articulos articulo = null;
        List<Articulos> articulos = new ArrayList();
        
        try {
            //iniciamos la conexion
            conexion = Conexion.getConexion();
            preparar = conexion.prepareStatement(SQL_SELECT);
            resultado = preparar.executeQuery();
            // Se pregunta si hay mas por añadir
            while(resultado.next()){
                //obtenemos el resultado de la BD y las asignamos a una variable
                int IdArticulo = resultado.getInt("IDarticulo");
                String Nombre = resultado.getString("Nombre");
                double precio = resultado.getDouble("precio");
                int IdTipoArticulo = resultado.getInt("IDtipoArt");
                String Marca = resultado.getString("marca");
                String descripcion = resultado.getString("Descripcion");
                //Creamos un nuevo articulo
                articulo = new Articulos(IdArticulo,Nombre,precio,IdTipoArticulo,Marca,descripcion);
                //añadimos el articulo ala lista
                articulos.add(articulo);
            }    
        } catch (SQLException ex) {
            ex.printStackTrace();
            //el finally siempre entra aunque haya algun error
        } finally{
            try {
                //cerramos las conexiones en orden inversa de como las abrimos
                Conexion.close(resultado);
                Conexion.close(preparar);
                Conexion.close(conexion);
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            
        }
        return articulos;
    }

    public void insertar(Articulos art) {
        Connection conexion = null;
        PreparedStatement preparar = null;
        Articulos articulo = null;
        
        try {
            //iniciamos la conexion
            conexion = Conexion.getConexion();
            preparar = conexion.prepareStatement(SQL_INSERT);
            preparar.setInt(1, art.getIdArticulo());
            preparar.setString(2, art.getNombre());
            preparar.setDouble(3, art.getPrecio());
            preparar.setInt(4, art.getIdTipoArticulo());
            preparar.setString(5, art.getMarca());
            preparar.setString(6, art.getDescripcion());
            
            preparar.executeUpdate();
            
            JOptionPane x = new JOptionPane();
            x.showMessageDialog(null, "Se agrego correctamente ");
        
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally{
            try {
                Conexion.close(preparar);
                Conexion.close(conexion);
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    public void modificar(Articulos art) {
        Connection conexion = null;
        PreparedStatement preparar = null;
        Articulos articulo = null;
        
        try {
            //iniciamos la conexion
            conexion = Conexion.getConexion();
            preparar = conexion.prepareStatement(SQL_UPDATE);
            int id = art.getIdArticulo();
            preparar.setString(1, art.getNombre());
            preparar.setDouble(2, art.getPrecio());
            preparar.setInt(3, art.getIdTipoArticulo());
            preparar.setString(4, art.getMarca());
            preparar.setString(5, art.getDescripcion());
            preparar.setInt(6, art.getIdArticulo());
            
            preparar.executeUpdate();
            
            JOptionPane x = new JOptionPane();
            x.showMessageDialog(null, "Se Modifico correctamente ");
            
            
        
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally{
            try {
                Conexion.close(preparar);
                Conexion.close(conexion);
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
            
        
    }

    public void eliminar(Articulos art) {
        Connection conexion = null;
        PreparedStatement preparar = null;
        Articulos articulo = null;
        
        try {
            //iniciamos la conexion
            conexion = Conexion.getConexion();
            preparar = conexion.prepareStatement(SQL_DELETE);
            int id = art.getIdArticulo();
            preparar.setInt(1, id);
            preparar.executeUpdate();
            JOptionPane x = new JOptionPane();
            x.showMessageDialog(null, "Se Elimino correctamente ");
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally{
            try {
                Conexion.close(preparar);
                Conexion.close(conexion);
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        
    }

    

    

   

    
    
    
}
