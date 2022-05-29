/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.allsafe.ui;

import com.allsafe.mock.SalesData;
import com.allsafe.mock.UserData;
import com.allsafe.model.Producto;
import com.allsafe.model.Usuario;
import com.allsafe.model.Venta;
import com.allsafe.service.Login;
import com.allsafe.service.SalesDataService;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.*;
import javax.swing.JFrame;
import javax.swing.JOptionPane;


/**
 *
 * @author felixcentenera
 */

public class WindowsAdminSalesSearch extends javax.swing.JFrame  {

    private Home principal;
    private WindowsProduct secundariaProductos;
    private  Producto producto;
    private WindowsAdmin adm;
    private Usuario user;
    private int opinion=0;
    Login miservicioDeLogin = Login.getInstance();
    // just for mock delete after test:
    UserData userData = UserData.getInstance();
    /**
     * Creates new form Home
     * @param ventana3
     * @param user
     */
    public WindowsAdminSalesSearch(WindowsAdmin ventana3, Usuario user){
        adm = ventana3;
        ventana3.setVisible(false);
        initComponents();
        this.setVisible(true);
        this.user = user;
        createWindowsProductPage();
    
    }
    
/**
* Nos permite crear la interfaz WindowsProductPage con todos lo elementos necesarios de forma dinámica.
*/
    private void createWindowsProductPage() {
        try {
            jLabelHomeIcon4.setIcon(new javax.swing.ImageIcon("Icons/png/AllSafe.png"));
            jLabelTimeline8.setIcon(new javax.swing.ImageIcon("Icons/png/TimelineCoversA.jpg"));
            jLabelTimeline7.setIcon(new javax.swing.ImageIcon("Icons/png/TimelineCoversB.jpg"));
            jButtonHomeIconsGround8.setIcon(new javax.swing.ImageIcon("Icons/png/arrowUp.png"));
            jButtonHomeIconsGround7.setIcon(new javax.swing.ImageIcon("Icons/png/ArrowDown.png"));
            jButtonHomeIconsGround5.setIcon(new javax.swing.ImageIcon("Icons/png/home.png"));
            jButtonHomeIconsGround6.setIcon(new javax.swing.ImageIcon("Icons/png/mail.png"));
            jButtonHomeIconsGround9.setIcon(new javax.swing.ImageIcon("Icons/png/back.png"));
            jLabelTipFormatted.setVisible(false);
            
            
        } 
        catch (Exception e) {
            System.out.println("Error: " + e.toString()); 
            opinion=0;
            createWindowsProductPage();
        }
    }

    // ********************************************************************************************************************


//método comprobar login
//private boolean checkLogin(){
//    boolean operationAccepted=false;
//    if (user == null){
//        this.dispose();
//        principal.setVisible(true);
//        System.out.println("INFO: No puedes realizar esa acción te mando al login TODO MANDAR AL LOGIN");
//        return false;
//    }
//     else{
//        operationAccepted=miservicioDeLogin.checkLogin(user.getClave(),user.getCorreo(),user.getToken()); 
//        System.out.println("INFO: Voy a comprobar el token");
//        if (operationAccepted == false){
//            this.dispose();
//            principal.setVisible(true);
//            System.out.println("INFO: No puedes realizar esa acción te mando al login TODO MANDAR AL LOGIN");
//            return false;
//        }
//        return true;
//    }
//}

// public  void  SetUsuario(Usuario user) {
//        this.user = user;
//        
// }
 // ********************************************************************************************************************
 
private JFrame getFrame(){
     return this;
    }

    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSeparator1 = new javax.swing.JSeparator();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 32767));
        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel112 = new javax.swing.JLabel();
        jSeparator4123 = new javax.swing.JSeparator();
        jPanel5 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        JButtomBuscar = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jTextFieldFindID = new javax.swing.JTextField();
        JTextDate = new javax.swing.JFormattedTextField();
        jLabelTipFormatted = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabelHomeIcon4 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabelTimeline8 = new javax.swing.JLabel();
        jLabelTimeline7 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jButtonHomeIconsGround5 = new javax.swing.JButton();
        jButtonHomeIconsGround7 = new javax.swing.JButton();
        jButtonHomeIconsGround8 = new javax.swing.JButton();
        jButtonHomeIconsGround9 = new javax.swing.JButton();
        jButtonHomeIconsGround6 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(6, 40, 73));
        jPanel1.setToolTipText("");
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel112.setFont(new java.awt.Font("Roboto Black", 0, 18)); // NOI18N
        jLabel112.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel112.setText("AllSafe Cibersecurity");

        jSeparator4123.setForeground(new java.awt.Color(51, 51, 51));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel1.setText("Buscar por Fecha:");

        JButtomBuscar.setText("Buscar");
        JButtomBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JButtomBuscarActionPerformed(evt);
            }
        });

        jButton2.setText("Ver todas las compras");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel4.setText("Buscar por ID:");

        jTextFieldFindID.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextFieldFindIDMouseClicked(evt);
            }
        });

        JTextDate.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("dd/MM/yyyy:HH:mm"))));
        JTextDate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JTextDateMouseClicked(evt);
            }
        });

        jLabelTipFormatted.setForeground(new java.awt.Color(204, 204, 204));
        jLabelTipFormatted.setText("Introduzca la fecha en el siguiente formato: dd/MM/yyyy:HH:mm");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(JTextDate, javax.swing.GroupLayout.PREFERRED_SIZE, 357, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(24, 24, 24)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabelTipFormatted, javax.swing.GroupLayout.PREFERRED_SIZE, 482, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextFieldFindID, javax.swing.GroupLayout.PREFERRED_SIZE, 361, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(129, 129, 129)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(130, 130, 130)
                        .addComponent(JButtomBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(47, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(JTextDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelTipFormatted)
                .addGap(33, 33, 33)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldFindID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(JButtomBuscar))
                .addGap(55, 55, 55))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel112, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSeparator4123, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(314, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel112, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator4123, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(64, 64, 64)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(91, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 40, 1030, 470));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 240, 1240, 520));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel3.add(jLabelHomeIcon4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1240, 100));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel4.add(jLabelTimeline8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -10, 660, 150));
        jPanel4.add(jLabelTimeline7, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 0, 630, 140));

        getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 1240, 140));

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButtonHomeIconsGround5.setIcon(new javax.swing.ImageIcon("/Users/felixcentenera/Documents/Learning/GISI/2ºCuatrimestre/Programación/uah_java_project/uahproject/Icons/png/home.png")); // NOI18N
        jButtonHomeIconsGround5.setBorderPainted(false);
        jButtonHomeIconsGround5.setContentAreaFilled(false);
        jButtonHomeIconsGround5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonHomeIconsGround5ActionPerformed(evt);
            }
        });
        jPanel6.add(jButtonHomeIconsGround5, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 0, 40, 40));

        jButtonHomeIconsGround7.setIcon(new javax.swing.ImageIcon("/Users/felixcentenera/Documents/Learning/GISI/2ºCuatrimestre/Programación/uah_java_project/uahproject/Icons/png/ArrowDown.png")); // NOI18N
        jButtonHomeIconsGround7.setBorderPainted(false);
        jButtonHomeIconsGround7.setContentAreaFilled(false);
        jButtonHomeIconsGround7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonHomeIconsGround7ActionPerformed(evt);
            }
        });
        jPanel6.add(jButtonHomeIconsGround7, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 0, 40, 40));

        jButtonHomeIconsGround8.setIcon(new javax.swing.ImageIcon("/Users/felixcentenera/Documents/Learning/GISI/2ºCuatrimestre/Programación/uah_java_project/uahproject/Icons/png/arrowUp.png")); // NOI18N
        jButtonHomeIconsGround8.setBorderPainted(false);
        jButtonHomeIconsGround8.setContentAreaFilled(false);
        jButtonHomeIconsGround8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonHomeIconsGround8ActionPerformed(evt);
            }
        });
        jPanel6.add(jButtonHomeIconsGround8, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 0, 40, 40));

        jButtonHomeIconsGround9.setIcon(new javax.swing.ImageIcon("/Users/felixcentenera/Documents/Learning/GISI/2ºCuatrimestre/Programación/uah_java_project/uahproject/Icons/png/back.png")); // NOI18N
        jButtonHomeIconsGround9.setBorderPainted(false);
        jButtonHomeIconsGround9.setContentAreaFilled(false);
        jButtonHomeIconsGround9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonHomeIconsGround9ActionPerformed(evt);
            }
        });
        jPanel6.add(jButtonHomeIconsGround9, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 0, 40, 40));

        jButtonHomeIconsGround6.setIcon(new javax.swing.ImageIcon("/Users/felixcentenera/Documents/Learning/GISI/2ºCuatrimestre/Programación/uah_java_project/uahproject/Icons/png/mail.png")); // NOI18N
        jButtonHomeIconsGround6.setBorderPainted(false);
        jButtonHomeIconsGround6.setContentAreaFilled(false);
        jButtonHomeIconsGround6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonHomeIconsGround6ActionPerformed(evt);
            }
        });
        jPanel6.add(jButtonHomeIconsGround6, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 0, 40, 40));

        getContentPane().add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 760, 1240, 50));

        pack();
    }// </editor-fold>//GEN-END:initComponents





//    private JFrame getFrame(){
//     return this;
//    }
    
    private void jButtonHomeIconsGround9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonHomeIconsGround9ActionPerformed
        // TODO add your handling code here:
        this.dispose();
        
        //Se comprueba la instancia que nos ha llamado, para generar el retorno correctamente.
        if (principal !=null) {
            principal.setVisible(true);
        }
        else if (adm != null){
          adm.setVisible(true);
        }
        else{
            System.out.println("INFO: No podemos volver");
            
        
        }
    }//GEN-LAST:event_jButtonHomeIconsGround9ActionPerformed

    /**
     * @param args the command line arguments
     */

private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed

}//GEN-LAST:event_formWindowClosed

    private void jButtonHomeIconsGround8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonHomeIconsGround8ActionPerformed

    }//GEN-LAST:event_jButtonHomeIconsGround8ActionPerformed

    private void jButtonHomeIconsGround7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonHomeIconsGround7ActionPerformed

    }//GEN-LAST:event_jButtonHomeIconsGround7ActionPerformed

    private void jTextFieldFindIDMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextFieldFindIDMouseClicked
        // TODO add your handling code here:
        jTextFieldFindID.setText("");
    }//GEN-LAST:event_jTextFieldFindIDMouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        /**
        * OBJ:Se encarga de pasar a WindowsAdminSalesShowAllProducts todos las venta que hay disponible en el inventario.
        * PRE: El Inventario debe haber sido creado antes y inicializazo
        */
        SalesData sales = SalesData.getInstance();

        ArrayList<String> ArrayKeys = SalesDataService.getAllSales();
        WindowsAdminSalesShowAllProducts ventana1 = new WindowsAdminSalesShowAllProducts(this , user , ArrayKeys);

    }//GEN-LAST:event_jButton2ActionPerformed

    private void JButtomBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JButtomBuscarActionPerformed
        /**
        * OBJ:Buscar dada una fecha si hay alguna venta que contenga dicha
        * fecha PRE:SalesData ha sido inicializado y instanciado void --> new
        * JFrame
        */

        try{
            if(jTextFieldFindID.getText().equals("")){//Inserte ID.
                System.out.println("############################################################################################################");
                //Cogemos la fecha nuestra
                String localDateStr = JTextDate.getText();
                DateTimeFormatter formatoCorto = DateTimeFormatter.ofPattern("dd/MM/yyyy:HH:mm");
                LocalDateTime localDate= LocalDateTime.parse(localDateStr, formatoCorto);
                System.out.println(localDate);

                //                LocalDateTime localDate = fecha2.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
                //
                //                System.out.println(localDate);
                //                DateTimeFormatter formatoCorto = DateTimeFormatter.ofPattern("dd/MM/yyyy:HH:mm");

                //System.out.println(localDate.format(formatoCorto));
                //boolean i = SalesDataService.IsLocalDateTimeInDDBB(localDate);

                //System.out.println("INFO: Se ha encontrado el producto" + i);
                //if(i == true){

                    ArrayList<String> ArrayKeys = SalesDataService.getSalesFounded(localDate);
                    System.out.println("INFO: Venta encontrada");
                    System.out.println("Estoy aqui" + ArrayKeys.toString());

                    System.out.println(ArrayKeys.size());

                    if(!ArrayKeys.isEmpty()){
                        WindowsAdminSalesShowAllProducts ventana1 = new WindowsAdminSalesShowAllProducts(this , user , ArrayKeys);
                    }else{
                        JOptionPane.showMessageDialog(null, "No se han encontrado datos en el registro","ErrorMessage", JOptionPane.ERROR_MESSAGE);
                        System.out.println("INFO: No se ha encontrado en el registor los datos");
                    }
                }else{
                    System.out.println("INFO: Vamos a buscar por ID de compra.");
                    String ID = jTextFieldFindID.getText();

                    if(SalesData.getInstance().getSalesDataHashMap().keySet().contains(ID)){
                        WindowsAdminSalesShowOneSale ventanaNueva = new WindowsAdminSalesShowOneSale(this , user , SalesData.getInstance().getSalesDataHashMap().get(ID));
                    }else if(ID.equals("")){
                        SalesData sales = SalesData.getInstance();
                        ArrayList<String> ArrayKeys = SalesDataService.getAllSales();
                        WindowsAdminSalesShowAllProducts ventana1 = new WindowsAdminSalesShowAllProducts(this , user , ArrayKeys);
                    }else{
                        JOptionPane.showMessageDialog(null, "La Fecha nos es correcta","ErrorMessage", JOptionPane.ERROR_MESSAGE);
                        System.out.println("INFO: No se ha encontrado en el registor los datos");
                    }

                }

                //        try{
                    //            if(jTextFieldFindID.getText().equals("")){//Inserte ID.
                        //                System.out.println("############################################################################################################");
                        //                //Cogemos la fecha nuestra
                        //                Date fecha2 = (Date) jSpinnerDate.getValue();
                        //                LocalDateTime localDate = fecha2.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
                        //                DateTimeFormatter formatoCorto = DateTimeFormatter.ofPattern("dd/MM/yyyy:HH:mm");
                        //
                        //                System.out.println("-------------" + SalesData.getInstance().getSalesDataHashMap().get(SalesData.getInstance().getSalesDataHashMap().keySet().toArray()[0]).getDateConfirmedSale().format(formatoCorto));
                        //
                        //                System.out.println(localDate.format(formatoCorto));
                        //                boolean i = SalesDataService.IsLocalDateTimeInDDBB(localDate.format(formatoCorto));
                        //                System.out.println(i);
                        //                if(i == true){
                            //
                            //                    Venta venta = SalesDataService.getSalesFounded(localDate.format(formatoCorto));
                            //                    System.out.println("INFO: Venta encontrada");
                            //                    System.out.println(venta.toString());
                            //                    //Cogemos y llamamos al constructor de WindowsAdminSalesShowOneSale para ver las caracteristicas del producto
                            //
                            //                    WindowsAdminSalesShowOneSale ventanaNueva = new WindowsAdminSalesShowOneSale(this , user , venta);
                            //
                            //                }else{
                            //                    JOptionPane.showMessageDialog(null, "Este es un mensaje de Advertencia","ErrorMesage, fecha incorrecta intentelo de nuevo", JOptionPane.ERROR_MESSAGE);
                            //                    System.out.println("INFO: No se ha encontrado en el registor los datos");
                            //
                            //
                            //
                            //                }
                        //            }else{
                        //                System.out.println("INFO: Vamos a buscar por fecha de  compra.");
                        //                String ID = jTextFieldFindID.getText();
                        //
                        //                if(SalesData.getInstance().getSalesDataHashMap().keySet().contains(ID)){
                            //                    WindowsAdminSalesShowOneSale ventanaNueva = new WindowsAdminSalesShowOneSale(this , user , SalesData.getInstance().getSalesDataHashMap().get(ID));
                            //                }else if(ID.equals("")){
                            //                    SalesData sales = SalesData.getInstance();
                            //                    ArrayList<String> ArrayKeys = SalesDataService.getAllSales();
                            //                    WindowsAdminSalesShowAllProducts ventana1 = new WindowsAdminSalesShowAllProducts(this , user , ArrayKeys);
                            //                }else{
                            //                    JOptionPane.showMessageDialog(null, "Este es un mensaje de Advertencia","ErrorMesage, fecha incorrecta intentelo de nuevo", JOptionPane.ERROR_MESSAGE);
                            //                    System.out.println("INFO: No se ha encontrado en el registor los datos");
                            //                }
                        //
                        //            }

                }catch(Exception e){
                    JOptionPane.showMessageDialog(null, "No se ha encontrar ninguna coincidencia, utilice otro rango.","Información para el usuario.", JOptionPane.INFORMATION_MESSAGE);
                    System.out.println("INFO: El Usuario ha metido un fecha incorrecta  ###" + e.toString());

                }
                finally{
                jLabelTipFormatted.setVisible(false);
        }
        

    }//GEN-LAST:event_JButtomBuscarActionPerformed

    private void JTextDateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JTextDateMouseClicked
        // TODO add your handling code here:
        jLabelTipFormatted.setVisible(true);
        
        
    }//GEN-LAST:event_JTextDateMouseClicked

    private void jButtonHomeIconsGround5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonHomeIconsGround5ActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(null, "Si lo necesita, puede ponerse en contacto con nosotros en el 900-123-123, estaremos encantados de atenderle.","Información para el usuario", JOptionPane.INFORMATION_MESSAGE);

    }//GEN-LAST:event_jButtonHomeIconsGround5ActionPerformed

    private void jButtonHomeIconsGround6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonHomeIconsGround6ActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(null, "Si lo necesita, puede ponerse en contacto con nosotros por mail escribiendo a supportAllSafe@allsafe.com, estaremos encantados de atenderle.","Información para el usuario", JOptionPane.INFORMATION_MESSAGE);

    }//GEN-LAST:event_jButtonHomeIconsGround6ActionPerformed

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JButtomBuscar;
    private javax.swing.JFormattedTextField JTextDate;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.Box.Filler filler1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButtonHomeIconsGround5;
    private javax.swing.JButton jButtonHomeIconsGround6;
    private javax.swing.JButton jButtonHomeIconsGround7;
    private javax.swing.JButton jButtonHomeIconsGround8;
    private javax.swing.JButton jButtonHomeIconsGround9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel112;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabelHomeIcon4;
    private javax.swing.JLabel jLabelTimeline7;
    private javax.swing.JLabel jLabelTimeline8;
    private javax.swing.JLabel jLabelTipFormatted;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator4123;
    private javax.swing.JTextField jTextFieldFindID;
    // End of variables declaration//GEN-END:variables
}
