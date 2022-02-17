package Ventanas;

import Conexion.ArticulosDAO;
import Conexion.TiposDeArticulosDAO;
import Domain.Articulos;
import Reportes.CrearReporte;
import Domain.TiposDeArticulos;
import Ventanas.Articulos.AgregarArticulo;
import Ventanas.Articulos.EliminarArticulo;
import Ventanas.Articulos.ModificarArticulo;
import Ventanas.Tipos.AgregarTipo;
import Ventanas.Tipos.EliminarTipo;
import Ventanas.Tipos.ModificarTipo;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author DANIEL FELIX
 */
public class TablaPrincipal extends javax.swing.JFrame {

    public TablaPrincipal() throws InterruptedException {
        initComponents();
        this.setLocationRelativeTo(null);
        llenarArticulo();
    }

    public void llenarArticulo() {
        tblMostrar.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{ {},{},{},{}},
                new String[]{}
        ));
        ArticulosDAO x = new ArticulosDAO();
        List<Articulos> articulos = (List<Articulos>) x.seleccionarTodo();
        TiposDeArticulosDAO ti = new TiposDeArticulosDAO();
        List<TiposDeArticulos> tipos = ti.seleccionarTodo();
        DefaultTableModel modelo = (DefaultTableModel) tblMostrar.getModel();
        String NombreTipo = "";
        modelo.addColumn("ID Articulo");
        modelo.addColumn("Nombre del Articulo");
        modelo.addColumn("Precio");
        modelo.addColumn("Tipo de Articulo");
        modelo.addColumn("Marca");
        modelo.addColumn("Descripcion");
        while (tblMostrar.getRowCount() > 0) {
            modelo.removeRow(0);
        }
        for (int i = 0; i < articulos.size(); i++) {
            Articulos articulo = articulos.get(i);
            for (int j = 0; j < tipos.size(); j++) {
                TiposDeArticulos nu = tipos.get(j);
                if (articulo.getIdTipoArticulo() == nu.getIdArticulo()) {
                    NombreTipo = nu.getNombre();
                    break;
                }
            }
            String id = Integer.toString(articulo.getIdArticulo());
            String Nombre = articulo.getNombre();
            String Precio = new Double(articulo.getPrecio()).toString();
            String IdTipo = NombreTipo;
            String Marca = articulo.getMarca();
            String Descripcion = articulo.getDescripcion();
            modelo.addRow(new Object[]{id, Nombre, Precio, IdTipo, Marca, Descripcion});
        }
    }

    public void llenarTipo() {
        tblMostrar.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{ {},{},{},{}},
                new String[]{}
        ));
        TiposDeArticulosDAO x = new TiposDeArticulosDAO();
        List<TiposDeArticulos> articulos = x.seleccionarTodo();
        DefaultTableModel modelo = (DefaultTableModel) tblMostrar.getModel();
        modelo.addColumn("ID tipo");
        modelo.addColumn("Nombre");
        modelo.addColumn("Descripcion");
        while (modelo.getRowCount() > 0) {
            modelo.removeRow(0);
        }
        for (int i = 0; i < articulos.size(); i++) {
            TiposDeArticulos n = articulos.get(i);
            String id = Integer.toString(n.getIdArticulo());
            String Nombre = n.getNombre();
            String Descripcion = n.getDescripcion();
            modelo.addRow(new Object[]{id, Nombre, Descripcion});
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        GrupoDeTablas = new javax.swing.ButtonGroup();
        Filtro = new javax.swing.ButtonGroup();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblMostrar = new javax.swing.JTable();
        btnAgregar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        btnActucalizar = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        itemArticulo = new javax.swing.JRadioButtonMenuItem();
        itemTipo = new javax.swing.JRadioButtonMenuItem();
        jMenu3 = new javax.swing.JMenu();
        genPdf = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Tabla De Contenido");

        tblMostrar.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Title 1"
            }
        ));
        jScrollPane1.setViewportView(tblMostrar);

        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        btnModificar.setText("Modificar");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        btnActucalizar.setText("Actualizar");
        btnActucalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActucalizarActionPerformed(evt);
            }
        });

        jMenu1.setText("Mostrar Tabla");
        GrupoDeTablas.add(jMenu1);

        GrupoDeTablas.add(itemArticulo);
        itemArticulo.setSelected(true);
        itemArticulo.setText("Tabla de Productos");
        itemArticulo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemArticuloActionPerformed(evt);
            }
        });
        jMenu1.add(itemArticulo);

        GrupoDeTablas.add(itemTipo);
        itemTipo.setText("Tabla de Articulos");
        itemTipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemTipoActionPerformed(evt);
            }
        });
        jMenu1.add(itemTipo);

        jMenuBar1.add(jMenu1);

        jMenu3.setText("Generar Reporte");

        genPdf.setText("Generar PDF");
        genPdf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                genPdfActionPerformed(evt);
            }
        });
        jMenu3.add(genPdf);

        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45))
            .addGroup(layout.createSequentialGroup()
                .addGap(606, 606, 606)
                .addComponent(btnActucalizar, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(23, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 701, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnActucalizar)
                .addGap(22, 22, 22)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAgregar)
                    .addComponent(btnModificar)
                    .addComponent(btnEliminar)
                    .addComponent(btnSalir))
                .addGap(32, 32, 32))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        if (itemArticulo.isSelected()) {
//            AgregarArticulo y = new AgregarArticulo();
//            y.setVisible(true);
            AgregarArticulo n = new AgregarArticulo(this, true);
            n.setVisible(true);
            llenarArticulo();
        } else {
            AgregarTipo y = new AgregarTipo(this,true);
            y.setVisible(true);
            llenarTipo();
        }
        
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnActucalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActucalizarActionPerformed
        if (itemArticulo.isSelected()) {
            llenarArticulo();
        } else {
            llenarTipo();
        }
    }//GEN-LAST:event_btnActucalizarActionPerformed

    private void itemTipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemTipoActionPerformed
        llenarTipo();
    }//GEN-LAST:event_itemTipoActionPerformed

    private void itemArticuloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemArticuloActionPerformed
        llenarArticulo();
    }//GEN-LAST:event_itemArticuloActionPerformed

    private void genPdfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_genPdfActionPerformed
        CrearReporte x = new CrearReporte();
//        x.imprimirPDF();
//        x.genReporte();
        x.iniciar();
    }//GEN-LAST:event_genPdfActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        if (itemArticulo.isSelected()) {
            try {
                int fila = tblMostrar.getSelectedRow();
                String Id = String.valueOf(this.tblMostrar.getValueAt(fila, 0));
                String Nombre = String.valueOf(this.tblMostrar.getValueAt(fila, 1));
                String precio = String.valueOf(this.tblMostrar.getValueAt(fila, 2));
                String Marca = String.valueOf(this.tblMostrar.getValueAt(fila, 4));
                String Desc = String.valueOf(this.tblMostrar.getValueAt(fila, 5));
                ModificarArticulo x = new ModificarArticulo(this,true,Id, Nombre, precio, Marca, Desc);
                x.setVisible(true);
                llenarArticulo();
            } catch (Exception ex) {
                JOptionPane pan = new JOptionPane();
                pan.showMessageDialog(null, "Selecciona una fila primero");
            }
        } else {
            try {
                int fila = tblMostrar.getSelectedRow();
                String id = String.valueOf(this.tblMostrar.getValueAt(fila, 0));
                String Nombre = String.valueOf(this.tblMostrar.getValueAt(fila, 1));
                String Descripcion = String.valueOf(this.tblMostrar.getValueAt(fila, 2));
                ModificarTipo x = new ModificarTipo(this,true,id, Nombre, Descripcion);
                x.setVisible(true);
                llenarTipo();
            } catch (Exception ex) {
                JOptionPane pan = new JOptionPane();
                pan.showMessageDialog(null, "Selecciona una fila primero");
            }
        }
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        if (itemArticulo.isSelected()) {
            try {
                int fila = tblMostrar.getSelectedRow();
                String Id = String.valueOf(this.tblMostrar.getValueAt(fila, 0));
                String Nombre = String.valueOf(this.tblMostrar.getValueAt(fila, 1));
                String precio = String.valueOf(this.tblMostrar.getValueAt(fila, 2));
                String Marca = String.valueOf(this.tblMostrar.getValueAt(fila, 4));
                String Desc = String.valueOf(this.tblMostrar.getValueAt(fila, 5));
                EliminarArticulo x = new EliminarArticulo(this,true,Id, Nombre, precio, Marca, Desc);
                x.setVisible(true);
                llenarArticulo();
            } catch (Exception ex) {
                JOptionPane pan = new JOptionPane();
                pan.showMessageDialog(null, "Selecciona una fila primero");
            }
        } else {
            try {
                int fila = tblMostrar.getSelectedRow();
                String id = String.valueOf(this.tblMostrar.getValueAt(fila, 0));
                String Nombre = String.valueOf(this.tblMostrar.getValueAt(fila, 1));
                String Descripcion = String.valueOf(this.tblMostrar.getValueAt(fila, 2));
                EliminarTipo x = new EliminarTipo(this,true,id, Nombre, Descripcion);
                x.setVisible(rootPaneCheckingEnabled);
                llenarTipo();
            } catch (Exception ex) {
                JOptionPane pan = new JOptionPane();
                pan.showMessageDialog(null, "Selecciona una fila primero");
            }
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TablaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TablaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TablaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TablaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new TablaPrincipal().setVisible(true);
                } catch (InterruptedException ex) {
                    Logger.getLogger(TablaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup Filtro;
    private javax.swing.ButtonGroup GrupoDeTablas;
    private javax.swing.JButton btnActucalizar;
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JMenuItem genPdf;
    private javax.swing.JRadioButtonMenuItem itemArticulo;
    private javax.swing.JRadioButtonMenuItem itemTipo;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblMostrar;
    // End of variables declaration//GEN-END:variables
}
