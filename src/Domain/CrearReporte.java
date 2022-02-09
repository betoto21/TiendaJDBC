package Domain;

import Conexion.ArticulosDAO;
import Conexion.TiposDeArticulosDAO;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class CrearReporte {

    private static final String ruta = System.getProperty("user.home") + "/Desktop/Reporte.pdf";
    public CrearReporte() {
    }
    
    public void imprimirPDF(){
        ArticulosDAO articulo = new ArticulosDAO();
        TiposDeArticulosDAO tipos = new TiposDeArticulosDAO();
        List<Articulos> articulos = articulo.seleccionarTodo();
        List<TiposDeArticulos> Tipo = tipos.seleccionarTodo();
        Document documento = new Document();
        String texto = "Se ha credo el reporte";
        String separador = "\n \n \n";
        try {
            PdfWriter.getInstance(documento, new FileOutputStream(ruta));
            Paragraph parrafo = new Paragraph();
            parrafo.add(texto + separador);
            documento.open();
            documento.add(parrafo);
            PdfPTable Articulos = new PdfPTable(6);
            PdfPTable tipo = new PdfPTable(3);
            Articulos.addCell("ID Articulo");
            Articulos.addCell("Nombre");
            Articulos.addCell("Precio");
            Articulos.addCell("ID Tipo Articulo");
            Articulos.addCell("Marca");
            Articulos.addCell("Descripcion");
            //tabla de tipos
            tipo.addCell("ID Tipo Articulo");
            tipo.addCell("Nombre");
            tipo.addCell("Descripcion");
            //llenado de tabla de articulos
            for (int i = 0; i < articulos.size(); i++) {
                Articulos nuevo = articulos.get(i);
                String Id = Integer.toString(nuevo.getIdArticulo());
                String Nombre = nuevo.getNombre();
                String Precio = Double.toString(nuevo.getPrecio());
                String IdTipo = Integer.toString(nuevo.getIdTipoArticulo());
                String Marca = nuevo.getMarca();
                String Descripcion = nuevo.getDescripcion();
                Articulos.addCell(Id);
                Articulos.addCell(Nombre);
                Articulos.addCell(Precio);
                Articulos.addCell(IdTipo);
                Articulos.addCell(Marca);
                Articulos.addCell(Descripcion);
            }
            //llenado de Tipos
            for (int i = 0; i < Tipo.size(); i++) {
                TiposDeArticulos x = Tipo.get(i);
                String Id = Integer.toString(x.getIdArticulo());
                String Nombre = x.getNombre();
                String Descripcion = x.getDescripcion();
                tipo.addCell(Id);
                tipo.addCell(Nombre);
                tipo.addCell(Descripcion);
            }
            documento.add(Articulos);
            Paragraph nuevo = new Paragraph();
            nuevo.add(separador);
            documento.add(nuevo);
            documento.add(tipo);
            
            documento.close();
            JOptionPane x = new JOptionPane();
            x.showMessageDialog(null, "Se imprimio el archivo en " + ruta);
            
            
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (DocumentException ex) {
           ex.printStackTrace();
        }
        
    }
}
