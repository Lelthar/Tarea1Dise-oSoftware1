/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * FrServidor.java
 *
 * Created on 18-abr-2013, 20:18:02
 */
package vista;

import controlador.GestorFrase;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import servidor.Servidor;

/**
 *
 * @author M-01
 */
public class FrServidor extends javax.swing.JFrame {
    
    private Servidor miServidor;

    /** Creates new form FrServidor */
    public FrServidor() {
        initComponents();
        
    }
    
    public void agregarArchivoAlgoritmo(){
        JFileChooser fc = new JFileChooser();
        int codigo = fc.showOpenDialog(this);

        if (codigo == JFileChooser.APPROVE_OPTION && fc.getSelectedFile().getAbsolutePath().endsWith(".java")){
            
            int dialogButton = JOptionPane.YES_NO_OPTION;
            int dialogResult = JOptionPane.showConfirmDialog (null, "¿Seguro que desea agregar ese algoritmo?","Warning",dialogButton);
            if(dialogResult == JOptionPane.YES_OPTION){
              // Saving code here
              String nombreArchivo = fc.getSelectedFile().getName();
              
              //labelPath.setText( fc.getSelectedFile().getAbsolutePath() );
              if(this.miServidor.getControlador().getAlgoritmos().agregarAlgoritmo(fc.getSelectedFile().getAbsolutePath(), fc.getSelectedFile().getName())){
                  JOptionPane.showMessageDialog(this, "Se agregó la clase "+nombreArchivo.substring(0,nombreArchivo.indexOf('.')));
              } else {
                  JOptionPane.showMessageDialog(this, "La clase "+nombreArchivo.substring(0,nombreArchivo.indexOf('.'))+" ya existe. No se pudo agregar.");
              } 
            } 
            
        } else {
            JOptionPane.showMessageDialog(this, "Tiene que agregar una clase.");
        }
    }
    
    public void agregarArchivoAlfabeto(){
        JFileChooser fc = new JFileChooser();
        int codigo = fc.showOpenDialog(this);

        if (codigo == JFileChooser.APPROVE_OPTION && fc.getSelectedFile().getAbsolutePath().endsWith(".txt")){
            
            int dialogButton = JOptionPane.YES_NO_OPTION;
            int dialogResult = JOptionPane.showConfirmDialog (null, "¿Seguro que desea agregar ese archivo?","Warning",dialogButton);
            if(dialogResult == JOptionPane.YES_OPTION){
              // Saving code here
              String nombreArchivo = fc.getSelectedFile().getName();
              
              //labelPath.setText( fc.getSelectedFile().getAbsolutePath() );
              if(this.miServidor.getControlador().getGestorAlfabeto().agregarAlfabeto(fc.getSelectedFile().getAbsolutePath(), fc.getSelectedFile().getName())){
                  JOptionPane.showMessageDialog(this, "Se agregó el archivo "+nombreArchivo.substring(0,nombreArchivo.indexOf('.')));
              } else {
                  JOptionPane.showMessageDialog(this, "El archivo "+nombreArchivo.substring(0,nombreArchivo.indexOf('.'))+" no se pudo agregar.\nPorque ya existe o contiene caracteres repetidos");
              } 
            } 
            
        } else {
            JOptionPane.showMessageDialog(this, "Tiene que agregar un archivo .txt .");
        }
    }
    
    public void abrirBitacora() {
        String dir = new File (".").getAbsolutePath ();
        JFileChooser fc = new JFileChooser(dir+"/resultados");
        fc.setDialogTitle("Selección de archivo de bitácora");
        int codigo = fc.showOpenDialog(this);
        if (codigo == JFileChooser.APPROVE_OPTION && (fc.getSelectedFile().getAbsolutePath().endsWith(".txt")
               || fc.getSelectedFile().getAbsolutePath().endsWith(".pdf")
               || fc.getSelectedFile().getAbsolutePath().endsWith(".xml"))){
            try {
                
                Desktop desktop = Desktop.getDesktop();
                desktop.open(new File(fc.getSelectedFile().getAbsolutePath()));
                
            } catch (IOException ex) {
            }
        }
    }
    
    public void cargarAlgoritmos(){
        
        DefaultListModel<String> model = new DefaultListModel<>(); 
        ArrayList<String> algorimos = miServidor.getControlador().getAlgoritmos().getListaTipos(); 
        for (String algoritmo : algorimos) {
           model.addElement(algoritmo);
        }
        
        this.listaAlgoritmos.setModel(model);
    }
    
    public void cargarAlfabetos(){
        DefaultListModel<String> model = new DefaultListModel<>(); 
        ArrayList<String> alfabetos = miServidor.getControlador().obtenerAlfabetos(); 
        for (String alfabeto : alfabetos) {
           model.addElement(alfabeto);
        }
        
        this.listaAlfabetos.setModel(model);
    }
    
    public void eliminarAlgoritmo() {
        String tipo = this.listaAlgoritmos.getSelectedValue();
        
        int dialogButton = JOptionPane.YES_NO_OPTION;
        int dialogResult = JOptionPane.showConfirmDialog (null, "¿Seguro que desea eliminar ese algoritmo?","Warning",dialogButton);
        if(dialogResult == JOptionPane.YES_OPTION){
            if(miServidor.getControlador().getAlgoritmos().eliminarAlgoritmo(tipo)) {
                JOptionPane.showMessageDialog(this, "Se eliminó el algoritmo "+tipo);
                
            } else {
                JOptionPane.showMessageDialog(this, "No se pudo eliminar el algoritmo "+tipo);
            }
        }
    }
    
    public void eliminarAlfabeto() {
        String tipo = this.listaAlfabetos.getSelectedValue();
        
        int dialogButton = JOptionPane.YES_NO_OPTION;
        int dialogResult = JOptionPane.showConfirmDialog (null, "¿Seguro que desea eliminar ese alfabeto?","Warning",dialogButton);
        if(dialogResult == JOptionPane.YES_OPTION){
            if(miServidor.getControlador().getGestorAlfabeto().eliminarAlfabeto(tipo)) {
                JOptionPane.showMessageDialog(this, "Se eliminó el alfabeto "+tipo); 
            } else {
                JOptionPane.showMessageDialog(this, "No se pudo eliminar el alfabeto "+tipo);
            }
        }
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToolBar1 = new javax.swing.JToolBar();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButton_agregarAlfabeto = new javax.swing.JButton();
        jButton_eliminiarAlfabeto = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        listaAlfabetos = new javax.swing.JList<>();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jButton_agregarAlgorimo = new javax.swing.JButton();
        jButton_eliminarAlgoritmo = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        listaAlgoritmos = new javax.swing.JList<>();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jButton_verBitacora = new javax.swing.JButton();

        jToolBar1.setRollover(true);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setAutoRequestFocus(false);
        setBackground(new java.awt.Color(255, 204, 255));

        jPanel1.setBackground(new java.awt.Color(153, 255, 153));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Alfabetos:");

        jButton_agregarAlfabeto.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton_agregarAlfabeto.setText("Agregar Alfabeto");
        jButton_agregarAlfabeto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_agregarAlfabetoActionPerformed(evt);
            }
        });

        jButton_eliminiarAlfabeto.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton_eliminiarAlfabeto.setText("Eliminar Alfabeto");
        jButton_eliminiarAlfabeto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_eliminiarAlfabetoActionPerformed(evt);
            }
        });

        listaAlfabetos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listaAlfabetosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(listaAlfabetos);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton_agregarAlfabeto)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton_eliminiarAlfabeto))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(252, 252, 252)
                        .addComponent(jLabel1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton_agregarAlfabeto)
                    .addComponent(jButton_eliminiarAlfabeto)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 76, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel2.setBackground(new java.awt.Color(153, 255, 153));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Algortimos:");

        jButton_agregarAlgorimo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton_agregarAlgorimo.setText("Agregar Algoritmo");
        jButton_agregarAlgorimo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_agregarAlgorimoActionPerformed(evt);
            }
        });

        jButton_eliminarAlgoritmo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton_eliminarAlgoritmo.setText("Eliminar Algoritmo");
        jButton_eliminarAlgoritmo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_eliminarAlgoritmoActionPerformed(evt);
            }
        });

        jScrollPane2.setViewportView(listaAlgoritmos);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(250, 250, 250)
                        .addComponent(jLabel2))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton_agregarAlgorimo)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton_eliminarAlgoritmo)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton_agregarAlgorimo)
                    .addComponent(jButton_eliminarAlgoritmo)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(153, 255, 153));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Bitácora:");

        jButton_verBitacora.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton_verBitacora.setText("Ver Bitácora");
        jButton_verBitacora.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_verBitacoraActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(246, 246, 246)
                        .addComponent(jLabel3))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(225, 225, 225)
                        .addComponent(jButton_verBitacora)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(jButton_verBitacora)
                .addGap(0, 42, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_agregarAlfabetoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_agregarAlfabetoActionPerformed
        // TODO add your handling code here:
        agregarArchivoAlfabeto();
        cargarAlfabetos();
    }//GEN-LAST:event_jButton_agregarAlfabetoActionPerformed

    private void jButton_verBitacoraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_verBitacoraActionPerformed
        // TODO add your handling code here:
       abrirBitacora();
    }//GEN-LAST:event_jButton_verBitacoraActionPerformed

    private void jButton_agregarAlgorimoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_agregarAlgorimoActionPerformed
        // TODO add your handling code here:
        agregarArchivoAlgoritmo();
        cargarAlgoritmos();
    }//GEN-LAST:event_jButton_agregarAlgorimoActionPerformed

    private void jButton_eliminiarAlfabetoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_eliminiarAlfabetoActionPerformed
        // TODO add your handling code here:
        eliminarAlfabeto();
        cargarAlfabetos();
    }//GEN-LAST:event_jButton_eliminiarAlfabetoActionPerformed

    private void jButton_eliminarAlgoritmoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_eliminarAlgoritmoActionPerformed
        // TODO add your handling code here:
        eliminarAlgoritmo();
        cargarAlgoritmos();
    }//GEN-LAST:event_jButton_eliminarAlgoritmoActionPerformed

    private void listaAlfabetosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listaAlfabetosMouseClicked
        // TODO add your handling code here:
 
    }//GEN-LAST:event_listaAlfabetosMouseClicked

    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(FrServidor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(FrServidor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(FrServidor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(FrServidor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//
//            public void run() {
//                new FrServidor().setVisible(true);
//            }
//        });
//    }
    public static void main(String[] args) throws InstantiationException, IllegalAccessException {
        FrServidor fr = new FrServidor();
        fr.setVisible(true);
        
        fr.miServidor = new Servidor();
        fr.cargarAlgoritmos();
        fr.cargarAlfabetos();
        fr.miServidor.inicialiceServidor();
        
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_agregarAlfabeto;
    private javax.swing.JButton jButton_agregarAlgorimo;
    private javax.swing.JButton jButton_eliminarAlgoritmo;
    private javax.swing.JButton jButton_eliminiarAlfabeto;
    private javax.swing.JButton jButton_verBitacora;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JList<String> listaAlfabetos;
    private javax.swing.JList<String> listaAlgoritmos;
    // End of variables declaration//GEN-END:variables
}
