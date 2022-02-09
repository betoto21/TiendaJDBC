
package Conexion;

import Domain.Articulos;
import Domain.TiposDeArticulos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class TiposDeArticulosDAO {
    
    private static final String SQL_SELECT = "select * from tblTipoArticulo";
    private static final String SQL_INSERT = "INSERT INTO tblTipoArticulo(IDtipoArt, Nombre, Descripcion) VALUES (?,?,?)";
    private static final String SQL_UPDATE = "UPDATE tblTipoArticulo set Nombre = ?, Descripcion = ? where IDtipoArt = ?";
    private static final String SQL_DELETE = "DELETE FROM tblTipoArticulo WHERE IDtipoArt = ?";

    public TiposDeArticulosDAO() {
    }
    
    public List<TiposDeArticulos> seleccionarTodo() {
        Connection conexion = null;
        PreparedStatement preparar = null;
        ResultSet resultado = null;
        TiposDeArticulos articulo = null;
        List<TiposDeArticulos> articulos = new ArrayList();
        
        try {
            //iniciamos la conexion
            conexion = Conexion.getConexion();
            preparar = conexion.prepareStatement(SQL_SELECT);
            resultado = preparar.executeQuery();
            // Se pregunta si hay mas por añadir
            while(resultado.next()){
                //obtenemos el resultado de la BD y las asignamos a una variable
                int idTipo = resultado.getInt("IDtipoArt");
                String Nombre = resultado.getString("Nombre");
                String Descripcion = resultado.getString("Descripcion");
                //Creamos un nuevo tipo de articulo
                TiposDeArticulos nuevo = new TiposDeArticulos(idTipo, Nombre, Descripcion);
                //añadimos el articulo ala lista
                articulos.add(nuevo);
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
    
    public void insertar(TiposDeArticulos tipo){
        Connection conexion = null;
        PreparedStatement preparar = null;
        Articulos articulo = null;
        
        try {
            conexion = Conexion.getConexion();
            preparar = conexion.prepareStatement(SQL_INSERT);
            preparar.setInt(1, tipo.getIdArticulo());
            preparar.setString(2, tipo.getNombre());
            preparar.setString(3, tipo.getDescripcion());
            
            preparar.executeUpdate();
            JOptionPane x = new JOptionPane();
            x.showMessageDialog(null, "Se agrego correctamente ");
        } catch (SQLException ex) {
            Logger.getLogger(TiposDeArticulosDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            try {
                Conexion.close(preparar);
                Conexion.close(conexion);
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
    
    public void modificar(TiposDeArticulos tipo){
        Connection conexion = null;
        PreparedStatement preparar = null;
        Articulos articulo = null;
        try {
            conexion = Conexion.getConexion();
            preparar = conexion.prepareStatement(SQL_UPDATE);
            preparar.setString(1, tipo.getNombre());
            preparar.setString(2, tipo.getDescripcion());
            preparar.setInt(3, tipo.getIdArticulo());
            preparar.executeUpdate();
            JOptionPane x = new JOptionPane();
            x.showMessageDialog(null, "Se Modifico correctamente ");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }finally{
            try {
                Conexion.close(preparar);
                Conexion.close(conexion);
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        
    }
    
    public void eliminar(TiposDeArticulos tipo){
        Connection conexion = null;
        PreparedStatement preparar = null;
        Articulos articulo = null;
        
        try {
            conexion = Conexion.getConexion();
            preparar = conexion.prepareStatement(SQL_DELETE);
            int id = tipo.getIdArticulo();
            preparar.setInt(1, id);
            preparar.executeUpdate();
            JOptionPane x = new JOptionPane();
            x.showMessageDialog(null, "Se Elimino correctamente ");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }finally{
            try {
                Conexion.close(preparar);
                Conexion.close(conexion);
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        
    }
}
