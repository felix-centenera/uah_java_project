/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.allsafe.ui;

import com.allsafe.model.ClienteEmpresa;
import com.allsafe.model.ClienteParticular;
import com.allsafe.model.Direccion;
import com.allsafe.model.Inventario;
import com.allsafe.model.Producto;
import com.allsafe.model.TarjetaDeCredito;
import com.allsafe.model.Usuario;
import com.allsafe.service.InventoryServices;
import com.allsafe.service.Login;
import com.allsafe.service.RandomHomeProductos;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

/**
 *
 * @author felixcentenera
 */

public class WindowsProductManagingInfo extends javax.swing.JFrame  {

//    private Home principal;
    private  Producto producto;
    private WindowsAdminProductMngtSearch principal;
    private Usuario user;
    private int opinion=0;
    Login miservicioDeLogin = Login.getInstance();
    /**
     * Creates new form Home
     */
//    public WindowsProduct() {
//        initComponents();
//        createHomePageProductos();
//        createHomePage();
//    }
    
    /** Creates new form WindowProduct */
    public WindowsProductManagingInfo(WindowsAdminProductMngtSearch ventana, Producto producto) {
        //Ocultamos la ventana principal
        principal = ventana;
        principal.setVisible(false);
   
        this.producto = producto;
        initComponents();
        this.setVisible(true);
        createWindowsProductPage();
        
    }
    
   public void createWindowsProductPage() {
        try {
            //jLabelImg.setSize(130, 100);
            //Set ICONS HWINDOWSPRODUCT
            jLabelHomeIcon4.setIcon(new javax.swing.ImageIcon("Icons/png/AllSafe.png"));
            //jButtonHomeIcon4.setIcon(new javax.swing.ImageIcon("Icons/png/search.png"));
            //jButtonLogin.setIcon(new javax.swing.ImageIcon("Icons/png/user.png"))
            jLabelTimeline8.setIcon(new javax.swing.ImageIcon("Icons/png/TimelineCoversA.jpg"));
            jLabelTimeline7.setIcon(new javax.swing.ImageIcon("Icons/png/TimelineCoversB.jpg"));
            jButtonHomeIconsGround8.setIcon(new javax.swing.ImageIcon("Icons/png/arrowUp.png"));
            jButtonHomeIconsGround7.setIcon(new javax.swing.ImageIcon("Icons/png/ArrowDown.png"));
            jButtonHomeIconsGround5.setIcon(new javax.swing.ImageIcon("Icons/png/home.png"));
            jButtonHomeIconsGround6.setIcon(new javax.swing.ImageIcon("Icons/png/mail.png"));
            jButtonHomeIconsGround9.setIcon(new javax.swing.ImageIcon("Icons/png/back.png"));
            
            //SET BOTTON HOME PAGE.

            // Set image of the producto
            jLabel3Product.setSize(250,180);
            //ImageIcon imagen = new ImageIcon(principal.RandomProductsHome.get(0).getFotografia());
            ImageIcon imagen = new ImageIcon(producto.getFotografia());
            ImageIcon   imgRedimensionada = new ImageIcon(imagen.getImage().getScaledInstance(jLabel3Product.getWidth(),jLabel3Product.getHeight(), 1));
            jLabel3Product.setIcon(new javax.swing.ImageIcon(producto.getFotografia()));
            jLabel3Product.setIcon(imgRedimensionada);
            // Set the title of the product
            jTextFieldProductoTitulo.setText(producto.getTitulo());
            // Set   the Caracteristicas of the product
            jTextFieldProductoCaracteristicas.setText(producto.getCaracteristicas());
            // Set the Categoria of the product
            jTextFieldProductoCategoria.setText(producto.getCategoria());
            
            jTextFieldProductoPathImg.setText(producto.getFotografia());
            
            
            // Set the Precio of the product
            jFormattedTextFieldProductoPrecio.setValue(producto.getPrecio());
            jFormattedTextFieldProductoStock.setValue(producto.getStock());
            
            
            // Set title of the producto 
            //jLabel1Calificacion.
            jPanel5Opiniones.setVisible(false);
            if (!producto.getArrayOpiniones().isEmpty()){
                jPanel5Opiniones.setVisible(true);
                int opcion =  producto.getOpiniones(opinion).getCalificacion();
                switch (opcion) {
                case 0 : jLabel1Calificacion.setIcon(new javax.swing.ImageIcon("Icons/png/zeroStars.png"));
                    break;
                case 1 : jLabel1Calificacion.setIcon(new javax.swing.ImageIcon("Icons/png/oneStars.png"));
                    break;
                case 2 : jLabel1Calificacion.setIcon(new javax.swing.ImageIcon("Icons/png/twoStars.png"));
                    break;
                case 3: jLabel1Calificacion.setIcon(new javax.swing.ImageIcon("Icons/png/threeStars.png"));
                    break;
                case 4: jLabel1Calificacion.setIcon(new javax.swing.ImageIcon("Icons/png/fourStars.png"));
                    break;
                case 5: jLabel1Calificacion.setIcon(new javax.swing.ImageIcon("Icons/png/fiveStars.png"));
                    break;
                 }
                      
                  jTextArea2Comentarios.setText(producto.getOpiniones(opinion).getComentario());
                  jTextField2NameClient.setText(producto.getOpiniones(opinion).getCliente());
                  jTextFieldFechaCom.setText((String) producto.getOpiniones(opinion).getFecha().format(DateTimeFormatter.ISO_DATE));
            }
            
            } 
        catch (Exception e) {
            System.out.println("Error: " + e.toString()); 
            opinion=0;
            createWindowsProductPage();
        }
    }

    // ********************************************************************************************************************


//método comprobar login. Método antiguo te devuelve a la home si no has hecho login.
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
    
 //método comprobar login
private boolean checkLogin(){
    boolean operationAccepted=false;
    if (user == null){
//        operationAccepted=miservicioDeLogin.checkLogin();
//        if (operationAccepted == false){
//            System.out.println("INFO: No puedes realizar esa acción te mando al login TODO MANDAR AL LOGIN");
//            return false;
//        }
        //return true;
        System.out.println("INFO: No puedes realizar esa acción te mando al login TODO MANDAR AL LOGIN");
        return false;
    }
     else{
        operationAccepted=miservicioDeLogin.checkLogin(user.getClave(),user.getCorreo(),user.getToken()); 
        System.out.println("INFO: Voy a comprobar el token");
        if (operationAccepted == false){
            System.out.println("INFO: No puedes realizar esa acción te mando al login TODO MANDAR AL LOGIN");
            return false;
        }
        return true;
    }
}


private boolean checkLoginInterfaz(){
    boolean operationAccepted=false;
    if (user == null){
        System.out.println("INFO: No hay  devuelvo falso para que pintes interfaz de usuario visitante");
        return false;
    }
     else{
        operationAccepted=miservicioDeLogin.checkLogin(user.getClave(),user.getCorreo(),user.getToken()); 
        System.out.println("INFO: Voy a comprobar el token");
        if (operationAccepted == false){
            System.out.println("INFO: No hay  devuelvo treu para que pintes interfaz de usuario registrado");
            return false;
        }
        return true;
    }
}

 public  void  SetUsuario(Usuario user) {
        this.user = user;
        
 }
 // ********************************************************************************************************************
 

    
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
        jPanel7 = new javax.swing.JPanel();
        jTextFieldProductoTitulo = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        jTextFieldProductoCaracteristicas = new javax.swing.JTextField();
        jFormattedTextFieldProductoPrecio = new javax.swing.JFormattedTextField();
        jPanel5Opiniones = new javax.swing.JPanel();
        jLabel1Calificacion = new javax.swing.JLabel();
        jTextField2NameClient = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea2Comentarios = new javax.swing.JTextArea();
        jTextFieldFechaCom = new javax.swing.JTextField();
        jFormattedTextFieldProductoStock = new javax.swing.JFormattedTextField();
        jTextFieldProductoPathImg = new javax.swing.JTextField();
        jComboBoxCategoria = new javax.swing.JComboBox<>();
        jTextFieldProductoCategoria = new javax.swing.JTextField();
        jPanel10 = new javax.swing.JPanel();
        jLabel3Product = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
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

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));

        jTextFieldProductoTitulo.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        jTextFieldProductoTitulo.setText("Titulo");
        jTextFieldProductoTitulo.setBorder(null);
        jTextFieldProductoTitulo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldProductoTituloActionPerformed(evt);
            }
        });

        jTextFieldProductoCaracteristicas.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jTextFieldProductoCaracteristicas.setText("Caracteristicas");
        jTextFieldProductoCaracteristicas.setBorder(null);
        jTextFieldProductoCaracteristicas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldProductoCaracteristicasActionPerformed(evt);
            }
        });

        jFormattedTextFieldProductoPrecio.setBackground(new java.awt.Color(255, 153, 0));
        jFormattedTextFieldProductoPrecio.setBorder(null);
        jFormattedTextFieldProductoPrecio.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(java.text.NumberFormat.getCurrencyInstance())));
        jFormattedTextFieldProductoPrecio.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N

        jPanel5Opiniones.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5Opiniones.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel1Calificacion.setIcon(new javax.swing.ImageIcon("/Users/felixcentenera/Documents/Learning/GISI/2ºCuatrimestre/Programación/uah_java_project/uahproject/Icons/png/zeroStars.png")); // NOI18N

        jTextField2NameClient.setText("jTextField2");
        jTextField2NameClient.setBorder(null);

        jTextArea2Comentarios.setColumns(20);
        jTextArea2Comentarios.setLineWrap(true);
        jTextArea2Comentarios.setRows(5);
        jScrollPane2.setViewportView(jTextArea2Comentarios);

        jTextFieldFechaCom.setText("jTextField2");
        jTextFieldFechaCom.setBorder(null);

        javax.swing.GroupLayout jPanel5OpinionesLayout = new javax.swing.GroupLayout(jPanel5Opiniones);
        jPanel5Opiniones.setLayout(jPanel5OpinionesLayout);
        jPanel5OpinionesLayout.setHorizontalGroup(
            jPanel5OpinionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5OpinionesLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel5OpinionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jTextFieldFechaCom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField2NameClient, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel5OpinionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel1Calificacion)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 409, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(33, Short.MAX_VALUE))
        );
        jPanel5OpinionesLayout.setVerticalGroup(
            jPanel5OpinionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5OpinionesLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel1Calificacion)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 103, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jTextField2NameClient, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldFechaCom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jFormattedTextFieldProductoStock.setBackground(new java.awt.Color(255, 153, 0));
        jFormattedTextFieldProductoStock.setBorder(null);
        jFormattedTextFieldProductoStock.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter()));
        jFormattedTextFieldProductoStock.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N

        jTextFieldProductoPathImg.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jTextFieldProductoPathImg.setText("PathImage");
        jTextFieldProductoPathImg.setBorder(null);

        jComboBoxCategoria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Componentes", "Ordenadores", "Móviles y telefonía", "TV, audio y foto", "Consolas y videojuegos" }));
        jComboBoxCategoria.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
                jComboBoxCategoriaCaretPositionChanged(evt);
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
            }
        });
        jComboBoxCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxCategoriaActionPerformed(evt);
            }
        });

        jTextFieldProductoCategoria.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jTextFieldProductoCategoria.setText("Categoria");
        jTextFieldProductoCategoria.setBorder(null);
        jTextFieldProductoCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldProductoCategoriaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextFieldProductoPathImg, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jFormattedTextFieldProductoStock, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel5Opiniones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldProductoCaracteristicas, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldProductoTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 377, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jFormattedTextFieldProductoPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jTextFieldProductoCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jComboBoxCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(84, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTextFieldProductoTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldProductoCaracteristicas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldProductoCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextFieldProductoPathImg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addComponent(jFormattedTextFieldProductoPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jFormattedTextFieldProductoStock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel5Opiniones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));

        jLabel3Product.setIcon(new javax.swing.ImageIcon("/Users/felixcentenera/Documents/Learning/GISI/2ºCuatrimestre/Programación/uah_java_project/uahproject/Img/laptops/dell/dellXps13.png")); // NOI18N

        jButton1.setText("Registrar cambio");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(122, 122, 122)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3Product, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(97, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addComponent(jLabel3Product, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 1170, 470));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 240, 1240, 520));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelHomeIcon4.setIcon(new javax.swing.ImageIcon("/Users/felixcentenera/Documents/Learning/GISI/2ºCuatrimestre/Programación/uah_java_project/uahproject/Icons/png/AllSafe.png")); // NOI18N
        jPanel3.add(jLabelHomeIcon4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1240, 100));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelTimeline8.setIcon(new javax.swing.ImageIcon("/Users/felixcentenera/Documents/Learning/GISI/2ºCuatrimestre/Programación/uah_java_project/uahproject/Icons/png/TimelineCoversA.jpg")); // NOI18N
        jPanel4.add(jLabelTimeline8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -10, 660, 150));

        jLabelTimeline7.setIcon(new javax.swing.ImageIcon("/Users/felixcentenera/Documents/Learning/GISI/2ºCuatrimestre/Programación/uah_java_project/uahproject/Icons/png/TimelineCoversB.jpg")); // NOI18N
        jPanel4.add(jLabelTimeline7, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 0, 630, 140));

        getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 1240, 140));

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButtonHomeIconsGround5.setIcon(new javax.swing.ImageIcon("/Users/felixcentenera/Documents/Learning/GISI/2ºCuatrimestre/Programación/uah_java_project/uahproject/Icons/png/home.png")); // NOI18N
        jButtonHomeIconsGround5.setBorderPainted(false);
        jButtonHomeIconsGround5.setContentAreaFilled(false);
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
        jPanel6.add(jButtonHomeIconsGround6, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 0, 40, 40));

        getContentPane().add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 760, 1240, 50));

        pack();
    }// </editor-fold>//GEN-END:initComponents





    private JFrame getFrame(){
     return this;
    }
    
    private void jButtonHomeIconsGround9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonHomeIconsGround9ActionPerformed
        // TODO add your handling code here:
        this.dispose();
        principal.setVisible(true);
  
    }//GEN-LAST:event_jButtonHomeIconsGround9ActionPerformed

    /**
     * @param args the command line arguments
     */

private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
    // TODO add your handling code here:
    principal.setVisible(true);
}//GEN-LAST:event_formWindowClosed

    private void jButtonHomeIconsGround8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonHomeIconsGround8ActionPerformed
        ///TODO Execptio!!!!!
            opinion= opinion+1;
            createWindowsProductPage();
    }//GEN-LAST:event_jButtonHomeIconsGround8ActionPerformed

    private void jButtonHomeIconsGround7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonHomeIconsGround7ActionPerformed
        // TODO add your handling code here:
        opinion= opinion-1;
        createWindowsProductPage();
        //TODO Execptio!!!!!
    }//GEN-LAST:event_jButtonHomeIconsGround7ActionPerformed

    private void jTextFieldProductoCaracteristicasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldProductoCaracteristicasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldProductoCaracteristicasActionPerformed

    private void jTextFieldProductoTituloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldProductoTituloActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldProductoTituloActionPerformed

    private void jTextFieldProductoCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldProductoCategoriaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldProductoCategoriaActionPerformed

    private void jComboBoxCategoriaCaretPositionChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_jComboBoxCategoriaCaretPositionChanged
        // TODO add your handling code here:
        //comprobar que funciona
        
        jTextFieldProductoCategoria.setText((String) jComboBoxCategoria.getSelectedItem());
    }//GEN-LAST:event_jComboBoxCategoriaCaretPositionChanged

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        //InventoryServices.setProduct(titulo, caracteristicas, categoria, ERROR, fotografia, ABORT);
        if ( InventoryServices.setProduct(jTextFieldProductoTitulo.getText(), jTextFieldProductoCaracteristicas.getText(), jTextFieldProductoCategoria.getText(), ((Number) jFormattedTextFieldProductoPrecio.getValue()).intValue(), jTextFieldProductoPathImg.getText(), ( (Number) jFormattedTextFieldProductoStock.getValue()).intValue())) {
            System.out.println("INFO: El producto se ha modificado con exito");
            this.dispose();
            principal.setVisible(true);
        
        }
        
        else {
             System.out.println("INFO: El producto no se ha modificado con exito");
             this.dispose();
            principal.setVisible(true);
        
        }
        
        
        
        
       
        
        
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jComboBoxCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxCategoriaActionPerformed
        // TODO add your handling code here:
        jTextFieldProductoCategoria.setText((String) jComboBoxCategoria.getSelectedItem());
    }//GEN-LAST:event_jComboBoxCategoriaActionPerformed

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.Box.Filler filler1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButtonHomeIconsGround5;
    private javax.swing.JButton jButtonHomeIconsGround6;
    private javax.swing.JButton jButtonHomeIconsGround7;
    private javax.swing.JButton jButtonHomeIconsGround8;
    private javax.swing.JButton jButtonHomeIconsGround9;
    private javax.swing.JComboBox<String> jComboBoxCategoria;
    private javax.swing.JFormattedTextField jFormattedTextFieldProductoPrecio;
    private javax.swing.JFormattedTextField jFormattedTextFieldProductoStock;
    private javax.swing.JLabel jLabel1Calificacion;
    private javax.swing.JLabel jLabel3Product;
    private javax.swing.JLabel jLabelHomeIcon4;
    private javax.swing.JLabel jLabelTimeline7;
    private javax.swing.JLabel jLabelTimeline8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5Opiniones;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTextArea jTextArea2Comentarios;
    private javax.swing.JTextField jTextField2NameClient;
    private javax.swing.JTextField jTextFieldFechaCom;
    private javax.swing.JTextField jTextFieldProductoCaracteristicas;
    private javax.swing.JTextField jTextFieldProductoCategoria;
    private javax.swing.JTextField jTextFieldProductoPathImg;
    private javax.swing.JTextField jTextFieldProductoTitulo;
    // End of variables declaration//GEN-END:variables
}
