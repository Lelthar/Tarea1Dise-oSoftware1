/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import UI.UIgui;
import comunes.DTOAlgoritmos;
import comunes.DTOGenerarFrase;
import comunes.Resultado;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

/**
 *
 * @author Rigo-PC
 */
public class GUI extends javax.swing.JFrame {
    
    private ArrayList<Integer> escritura;
    private ArrayList<Integer> algoritmos;
    private DefaultListModel<String> modelEscritura;
    private DefaultListModel<String> modelAlgoritmos;
    private UIgui Uigui;
    
    /**
     * Creates new form GUI
     */
    public GUI() {
        initComponents();
        modelEscritura = new DefaultListModel<>();
        modelAlgoritmos = new DefaultListModel<>();
        escritura = new ArrayList<>();
        algoritmos = new ArrayList<>();
        Uigui = new UIgui();
        cargarAlgoritmosGUI();
        cargarAlfabetosGUI();
    }
    
    /**
     * metodo que carga los algoritmos disponibles al GUI
     */
    public void cargarAlgoritmosGUI(){
        DefaultListModel<String> model = new DefaultListModel<>(); 
        ArrayList<String> algorimos = Uigui.obtenerAlgoritmos(); 
        for (int i=0;i<algorimos.size();i++) {
           model.addElement(algorimos.get(i));
        }
        
        this.lbAlgoritmoE.setModel(model);
    }
    
    /**
     * Metodo para cargar los alfabetos existentes
     */
    public void cargarAlfabetosGUI(){
        ArrayList<String> algorimos = Uigui.obtenerAlfabetos();
        for (int i=0;i<algorimos.size();i++) {
           this.cbAlfabeto.addItem(algorimos.get(i));
        }
    }
    
    /**
     * Metodo que trabaja la forma de mostrar el resultado.
     * @param elDTO
     */
   public void procesarResultados(DTOAlgoritmos elDTO){
       this.Resultados.setText("");
       String texto="";
       String fechaHora = "Fecha y hora: ";
       String fraseOriginal = "Frase original: ";
       
       texto += (fechaHora+elDTO.getFechaHora()+"\n");
       texto += (fraseOriginal+elDTO.getDatosEntrada().get(0)+"\n\n");
       texto += "Resultados: \n";
       for(Resultado resultado : elDTO.getResultadoAlgoritmo()){
           texto += resultado.getNombreAlgoritmo()+"("+resultado.getTipoOperacion()+"):\n";
           texto += resultado.getResultadoAlgoritmo()+" \n\n";
       }
       this.Resultados.setText(texto);
   }
   
   /**
    * 
     * @param elDto
    */
   public void enviarPeticion(DTOAlgoritmos elDto){

       DTOAlgoritmos dtoRespuesta = Uigui.procesarPeticion(elDto);
       
       if(dtoRespuesta!=null){
            if(dtoRespuesta.getRespuesta().equals("OK")){
                procesarResultados(dtoRespuesta);
            }else{
                JOptionPane.showMessageDialog(this, "No se puedo realizar operación."+dtoRespuesta.getRespuesta());
            }
       }else{
           JOptionPane.showMessageDialog(this, "Respuesta null.");
       }
        
   }
   
   public void enviarGenerarFrase(DTOGenerarFrase elDto){
       
       DTOGenerarFrase dtoRespuesta = Uigui.procesarGenerarFrase(elDto);
       
       if(dtoRespuesta!=null){
            this.Resultados.setText("");
            String texto="";
            texto += "Frase Generada: \n";
            texto += dtoRespuesta.getResultado();
            this.Resultados.setText(texto);
       }else{
           JOptionPane.showMessageDialog(this, "Respuesta null.");
       }
   }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        buttonGroup4 = new javax.swing.ButtonGroup();
        buttonGroup5 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        vFaseOrigen = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Resultados = new javax.swing.JTextArea();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        cbAlfabeto = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        modoCodificar = new javax.swing.JRadioButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        lbAlgoritmoE = new javax.swing.JList<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        lbAlgoritmoS = new javax.swing.JList<>();
        jPanel3 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        lbSalidasE = new javax.swing.JList<>();
        jScrollPane5 = new javax.swing.JScrollPane();
        lbSalidasS = new javax.swing.JList<>();
        jLabel7 = new javax.swing.JLabel();
        jButtonEjecutar = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jTextField_largoFrase = new javax.swing.JTextField();
        jComboBox_tipoFrase = new javax.swing.JComboBox<>();
        jButton_generarFrase = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 204, 255));

        jPanel1.setBackground(new java.awt.Color(153, 255, 153));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Ingrese una frase/texto:");

        vFaseOrigen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vFaseOrigenActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Resultado:");

        Resultados.setEditable(false);
        Resultados.setColumns(20);
        Resultados.setRows(5);
        jScrollPane1.setViewportView(Resultados);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 333, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(vFaseOrigen)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING))
                .addGap(0, 10, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(vFaseOrigen, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel2.setBackground(new java.awt.Color(153, 255, 153));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Alfabeto:");

        cbAlfabeto.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Algoritmo:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Modo Codificación:");

        modoCodificar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        modoCodificar.setText("Codificar");
        modoCodificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modoCodificarActionPerformed(evt);
            }
        });

        lbAlgoritmoE.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "A", "B", "C" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        lbAlgoritmoE.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbAlgoritmoEMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(lbAlgoritmoE);

        lbAlgoritmoS.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbAlgoritmoSMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(lbAlgoritmoS);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbAlfabeto, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(modoCodificar)
                .addGap(93, 93, 93))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cbAlfabeto, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 103, Short.MAX_VALUE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(modoCodificar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(153, 255, 153));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Tipo de Escritura:");

        lbSalidasE.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "TXT", "PDF", "XML" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        lbSalidasE.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbSalidasEMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(lbSalidasE);

        lbSalidasS.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbSalidasSMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(lbSalidasS);

        jLabel7.setText("Seleccionados:");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(34, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addGap(120, 120, 120))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addGap(4, 4, 4)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 95, Short.MAX_VALUE)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jButtonEjecutar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButtonEjecutar.setText("Ejecutar");
        jButtonEjecutar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEjecutarActionPerformed(evt);
            }
        });

        jPanel4.setBackground(new java.awt.Color(153, 255, 153));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setText("Generar Frase:");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setText("Tamaño:");

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel10.setText("Tipo:");

        jComboBox_tipoFrase.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jComboBox_tipoFrase.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0", "1", "2" }));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jTextField_largoFrase)
                        .addComponent(jComboBox_tipoFrase, 0, 150, Short.MAX_VALUE)))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField_largoFrase, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addGap(25, 25, 25)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jComboBox_tipoFrase, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jButton_generarFrase.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton_generarFrase.setText("Generar");
        jButton_generarFrase.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_generarFraseActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(154, 154, 154)
                .addComponent(jButtonEjecutar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton_generarFrase)
                .addGap(84, 84, 84))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonEjecutar)
                    .addComponent(jButton_generarFrase))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void vFaseOrigenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vFaseOrigenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_vFaseOrigenActionPerformed

    private void modoCodificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modoCodificarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_modoCodificarActionPerformed

    private void jButtonEjecutarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEjecutarActionPerformed
        // TODO add your handling code here:
        //elControlador = new Controlador();
        //Enviar Datos
        String frase = vFaseOrigen.getText();
        int alfabeto = cbAlfabeto.getSelectedIndex();
        boolean modo = modoCodificar.isSelected();
    
        if (!algoritmos.isEmpty()) {
            if(!frase.isEmpty()){
                DTOAlgoritmos elDTO = new DTOAlgoritmos();

                SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");  
                Date date = new Date();

                elDTO.setFechaHora(formatter.format(date));
                
                ArrayList<Object> datosEntrada = new ArrayList<>();
                datosEntrada.add(frase);
                datosEntrada.add(23); // Modificar para que se haga desde la interfaz grafica
                
                elDTO.setDatosEntrada(datosEntrada);
                elDTO.setModoAlgoritmo(modo);
                elDTO.setAlgoritmosSeleccionados(algoritmos);

                elDTO.setSalidasSeleccionadas(escritura);
                
                elDTO.setNumeroAlfabeto(alfabeto);
                
                enviarPeticion(elDTO);
                
            } else {
                JOptionPane.showMessageDialog(this, "Necesita escribir un frase para realizar la operación.");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Necesita seleccionar al menos un algoritmo para realizar la operación.");
        }
        
    }//GEN-LAST:event_jButtonEjecutarActionPerformed

    private void lbSalidasEMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbSalidasEMouseClicked
        // TODO add your handling code here:
        
        int pos = this.lbSalidasE.getAnchorSelectionIndex();
        String tipo = this.lbSalidasE.getSelectedValue();
        if(!escritura.contains(pos)){
            escritura.add(pos);
            modelEscritura.addElement(tipo);
            this.lbSalidasS.setModel(modelEscritura);           
        } 
       
           
    }//GEN-LAST:event_lbSalidasEMouseClicked

    private void lbAlgoritmoEMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbAlgoritmoEMouseClicked
        // TODO add your handling code here:
        
        int pos = this.lbAlgoritmoE.getAnchorSelectionIndex();
        String tipo = this.lbAlgoritmoE.getSelectedValue();
        if(!algoritmos.contains(pos)){
            algoritmos.add(pos);
            modelAlgoritmos.addElement(tipo);
            this.lbAlgoritmoS.setModel(modelAlgoritmos);
        }
       
        
    }//GEN-LAST:event_lbAlgoritmoEMouseClicked

    private void lbSalidasSMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbSalidasSMouseClicked
        // TODO add your handling code here:
        if ( !this.escritura.isEmpty() ) {
             int pos = this.lbSalidasS.getAnchorSelectionIndex();
            String tipo = this.lbSalidasS.getSelectedValue();
            modelEscritura.removeElement(tipo);
            escritura.remove(pos);
            this.lbSalidasS.setModel(modelEscritura);
        }
            //JOptionPane.showMessageDialog(this, ""); 
        
    }//GEN-LAST:event_lbSalidasSMouseClicked

    private void lbAlgoritmoSMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbAlgoritmoSMouseClicked
        // TODO add your handling code here:
        if (!algoritmos.isEmpty()) {
             int pos = this.lbAlgoritmoS.getAnchorSelectionIndex();
            String tipo = this.lbAlgoritmoS.getSelectedValue();
            modelAlgoritmos.removeElement(tipo);
            algoritmos.remove(pos);
            this.lbAlgoritmoS.setModel(modelAlgoritmos);
        }
       
    }//GEN-LAST:event_lbAlgoritmoSMouseClicked

    private void jButton_generarFraseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_generarFraseActionPerformed
        // TODO add your handling code here:
        int alfabeto = this.cbAlfabeto.getSelectedIndex();
        String largo = this.jTextField_largoFrase.getText();
        int tipoFrase = this.jComboBox_tipoFrase.getSelectedIndex();
        if(!largo.isEmpty()){
            DTOGenerarFrase generar = new DTOGenerarFrase();
            generar.setLargo(Integer.parseInt(largo));
            generar.setNumeroAlfabeto(alfabeto);
            generar.setTipo(tipoFrase);
            
            enviarGenerarFrase(generar);
            
        }else{
            JOptionPane.showMessageDialog(this, "Necesita escribir el largo de la frase para realizar la operación.");
        }
            
    }//GEN-LAST:event_jButton_generarFraseActionPerformed

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
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea Resultados;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.ButtonGroup buttonGroup4;
    private javax.swing.ButtonGroup buttonGroup5;
    private javax.swing.JComboBox<String> cbAlfabeto;
    private javax.swing.JButton jButtonEjecutar;
    private javax.swing.JButton jButton_generarFrase;
    private javax.swing.JComboBox<String> jComboBox_tipoFrase;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTextField jTextField_largoFrase;
    private javax.swing.JList<String> lbAlgoritmoE;
    private javax.swing.JList<String> lbAlgoritmoS;
    private javax.swing.JList<String> lbSalidasE;
    private javax.swing.JList<String> lbSalidasS;
    private javax.swing.JRadioButton modoCodificar;
    private javax.swing.JTextField vFaseOrigen;
    // End of variables declaration//GEN-END:variables
}
