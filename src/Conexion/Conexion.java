package Conexion;

import java.sql.*;

/**
 *
 * @author DANIEL FELIX
 */
public class Conexion {
    //test del push y los comits
        //Solo se debe de camibar esto (DESKTOP-83PV3G4)por lo que les
        //sale al abrir el sql management y agregar el usuario = pruebas Contraseña= pruebas
        //con los permisos de owner y todo lo demas deberia de funcionar bien
    private final static String SQL_URL = "jdbc:sqlserver://DESKTOP-83PV3G4;databaseName=Tienda_BDA;user=pruebas;password=pruebas";
    
    public static Connection getConexion() throws SQLException{
        return DriverManager.getConnection(SQL_URL);
    }
    
   public static void close(ResultSet rs) throws SQLException{
       rs.close();
   }
   
   public static void close(Statement st) throws SQLException{
       st.close();
   }
   
   public static void close(PreparedStatement st) throws SQLException{
       st.close();
   }
   
   public static void close(Connection cn) throws SQLException{
       cn.close();
   }
}
