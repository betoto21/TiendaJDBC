package Conexion;

import Domain.Articulos;
import java.util.List;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author DANIEL FELIX
 */
public class ArticulosDAO{
    
    private static final String SQL_SELECT = "select * from tblArticulo";
    private static final String SQL_INSERT = "execute SP_INSERT_ARTICULO ?,?,?,?,?,? ";
    private static final String SQL_UPDATE = "execute SP_UPDATE_ARTICULO ?,?,?,?,?,?";
    private static final String SQL_DELETE = "execute SP_DELETE_ARTICULO ?";

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
        Articulos articulo = art;
        CallableStatement a = null;
        try {
            conexion = Conexion.getConexion();
            a = conexion.prepareCall(SQL_INSERT);
            a.setInt(1, articulo.getIdArticulo());
            a.setString(2, articulo.getNombre());
            a.setDouble(3, articulo.getPrecio());
            a.setInt(4, articulo.getIdTipoArticulo());
            a.setString(5, articulo.getMarca());
            a.setString(6, articulo.getDescripcion());
            a.execute();
            ResultSet r=a.getResultSet();
            JOptionPane.showMessageDialog(null, "se agrego correctamente");
            } catch (SQLException ex) {
            ex.printStackTrace();
        }finally{
            try {
                a.close();
                Conexion.close(conexion);
            } catch (SQLException ex) {
                
            }
        }

        
    }

    public void modificar(Articulos art) {
        Connection conexion = null;
        PreparedStatement preparar = null;
        Articulos articulo = art;
        CallableStatement a = null;
        try {
            conexion = Conexion.getConexion();
            a = conexion.prepareCall(SQL_UPDATE);
            a.setInt(1,articulo.getIdArticulo());
            a.setString(2, articulo.getNombre());
            a.setDouble(3,articulo.getPrecio());
            a.setInt(4, articulo.getIdTipoArticulo());
            a.setString(5, articulo.getMarca());
            a.setString(6, articulo.getDescripcion());
            a.execute();
            JOptionPane x = new JOptionPane();
            x.showMessageDialog(null, "Se Modifico correctamente ");
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally{
            try {
                a.close();
                Conexion.close(conexion);
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    public void eliminar(Articulos art) {
        Connection conexion = null;
        PreparedStatement preparar = null;
        Articulos articulo = art;
        CallableStatement a = null;
        try {
            //iniciamos la conexion
            conexion = Conexion.getConexion();
            a = conexion.prepareCall(SQL_DELETE);
            a.setInt(1, articulo.getIdArticulo());
            a.execute();
            JOptionPane x = new JOptionPane();
            x.showMessageDialog(null, "Se Elimino correctamente ");
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally{
            try {
                a.close();
                Conexion.close(conexion);
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    

    

   

    
    
    
}
