/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.allsafe.ui;

import com.allsafe.mock.UserData;
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
import com.allsafe.service.SalesDataService;
import com.allsafe.service.UsersServices;
import java.awt.Color;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.ListModel;

/**
 *
 * @author felixcentenera
 */

public class WindowsUserShoppingCart extends javax.swing.JFrame  {

    private Home principal;
    private WindowsProduct secundariaProductos;
    private  Producto producto;
    private Usuario user;
   
    //private Usuario userMgmt;
    private Producto productMgmt;
    //private int opinion=0;
    private int numberOfUserPages=0;
    Login miservicioDeLogin = Login.getInstance();
    // just for mock delete after test:
    UserData userData = UserData.getInstance();
    
    /**
     * Creates new form Home
     */
//    public WindowsProduct() {
//        initComponents();
//        createHomePageProductos();
//        createHomePage();
//    }
    
    /** Creates new form WindowProduct */
    public WindowsUserShoppingCart(Home ventana, Usuario u) {
        //Ocultamos la ventana principal
        principal = ventana;
        principal.setVisible(false);
        user = u;
        this.producto =producto;
        initComponents();
        this.setVisible(true);
        createWindowsProductPage();
        
    }
    
       public WindowsUserShoppingCart(WindowsProduct ventana, Usuario u) {
        //Ocultamos la ventana principal
        secundariaProductos = ventana;
        secundariaProductos.setVisible(false);
        user = u;
        this.producto =producto;
        initComponents();
        this.setVisible(true);
        createWindowsProductPage();
        
    }
    
//     public WindowsAdminUserMngt(WindowsProduct ventana2, Usuario u, Home ventana1) {
//        //Ocultamos la ventana principal
//        secundariaProductos = ventana2;
//        principal = ventana1;
//        secundariaProductos.setVisible(false);
//        user = u;
//        initComponents();
//        this.setVisible(true);
//        createWindowsProductPage();
//    }
//    

/**
* Nos permite crear la interfaz createWindowsProductPage con todos lo elementos necesarios de forma dinámica.
*/ 
    private void createWindowsProductPage() {
        try {
            //jLabelImg.setSize(130, 100);
            //Set ICONS HWINDOWSPRODUCT
            jLabelHomeIcon4.setIcon(new javax.swing.ImageIcon("Icons/png/AllSafe.png"));
            //jButtonHomeIcon4.setIcon(new javax.swing.ImageIcon("Icons/png/search.png"));
            //jButtonHomeIcon1.setIcon(new javax.swing.ImageIcon("Icons/png/shopping-cart.png"));
            //jButtonHomeIcon2.setIcon(new javax.swing.ImageIcon("Icons/png/user.png"));
            jLabelTimeline8.setIcon(new javax.swing.ImageIcon("Icons/png/TimelineCoversA.jpg"));
            jLabelTimeline7.setIcon(new javax.swing.ImageIcon("Icons/png/TimelineCoversB.jpg"));
            jButtonHomeIconsGround8.setIcon(new javax.swing.ImageIcon("Icons/png/arrowUp.png"));
            jButtonHomeIconsGround7.setIcon(new javax.swing.ImageIcon("Icons/png/ArrowDown.png"));
            jButtonHomeIconsGround5.setIcon(new javax.swing.ImageIcon("Icons/png/home.png"));
            jButtonHomeIconsGround6.setIcon(new javax.swing.ImageIcon("Icons/png/mail.png"));
            jButtonHomeIconsGround9.setIcon(new javax.swing.ImageIcon("Icons/png/back.png"));
            
            jPanelUsersFound.setVisible(false);
            jButtonUser1.setVisible(false);        
            jButtonUser2.setVisible(false);
            jButtonUser3.setVisible(false);
            jButtonUser4.setVisible(false);
            jButtonUser5.setVisible(false);
            jButtonUser6.setVisible(false);
            jButtonUser7.setVisible(false);
            jButtonUser8.setVisible(false);
            jLabelEmptyCarrito.setVisible(false);
            
            
            if (!UsersServices.getObjectShoppingCart(user).isEmpty()){
                printUsers(0);
            }
            else{
                jLabelEmptyCarrito.setVisible(true);
            
            }
            
            
            //SET BOTTON HOME PAGE.
         
        } 
        catch (Exception e) {
            System.out.println("Error: " + e.toString()); 
            //opinion=0;
            createWindowsProductPage();
        }
    }
    
    public  void  SetNumberOfUserPages0() {
        this.numberOfUserPages = 0;
 }
    
    
/**
* Nos permite mostrar los productos interfaz  con todos lo elementos necesarios de forma dinámica.
* Estos productos están recogidos en un ArrayList Producto listOfKeys, mediante el parametro i mostraremos
* los productos que comiencen en la posición i.
* * @param i
*/  
    private void printUsers(int i){
        
                jPanelUsersFound.setVisible(true);
                jButtonUser1.setVisible(false);        
                jButtonUser2.setVisible(false);
                jButtonUser3.setVisible(false);
                jButtonUser4.setVisible(false);
                jButtonUser5.setVisible(false);
                jButtonUser6.setVisible(false);
                jButtonUser7.setVisible(false);
                jButtonUser8.setVisible(false);
                
                
               // UsersServices.TypeUser(user.getCorreo(), user.getClave());
           
                //ArrayList<String> listOfKeys  = UsersServices.getUser();
                String clase = user.getClass().getSimpleName();
  
           
                ArrayList<Producto> listOfKeys  = UsersServices.getObjectShoppingCart(user);
                //listOfKeys.size();
                int sizeUserData=listOfKeys.size();
                System.out.println(numberOfUserPages);
                numberOfUserPages = numberOfUserPages +i;
                System.out.println(numberOfUserPages);
                jPanelUsersFound.setVisible(true);
                switch (sizeUserData) {
                case 1 : 
                    try {
                        System.out.println("caso1");
                    jButtonUser1.setVisible(true);
                    jButtonUser1.setText(listOfKeys.get(numberOfUserPages).getTitulo());
                    
                    jLabelTotal.setText("Total: " + SalesDataService.SumTotal(listOfKeys) + " €");
                    
                    
                    
                    }
                    catch (Exception e) {
                        System.out.println("Error: No hay mas productos que mostrar " + e.toString()); 
                        SetNumberOfUserPages0();
                        System.out.println("Voy a poner los user a 0");
                        printUsers(0);
                        
                        
                        
                        
                    }
                    break;
                case 2 :
                    try {
                        System.out.println("caso2");
                    jButtonUser1.setVisible(true);
                    jButtonUser1.setText(listOfKeys.get(numberOfUserPages).getTitulo());
                    jButtonUser2.setVisible(true);
                    jButtonUser2.setText(listOfKeys.get(numberOfUserPages+1).getTitulo());
                    jLabelTotal.setText("Total: " + SalesDataService.SumTotal(listOfKeys) + " €");
                    
                    
                    }
                    catch (Exception e) {
                        System.out.println("Error: No hay mas productos que mostrar " + e.toString()); 
                        System.out.println("Voy a poner los productos en indice  0");
                        SetNumberOfUserPages0();
                        printUsers(0);
                        //createWindowsProductPage();
                    }
                    
                    break;
                case 3:
                    try {
                        System.out.println("caso3");
                    jButtonUser1.setVisible(true);
                    jButtonUser1.setText(listOfKeys.get(numberOfUserPages).getTitulo());
                    jButtonUser2.setVisible(true);
                    jButtonUser2.setText(listOfKeys.get(numberOfUserPages+1).getTitulo());
                    jButtonUser3.setVisible(true);
                    jButtonUser3.setText(listOfKeys.get(numberOfUserPages+2).getTitulo());
                    jLabelTotal.setText("Total: " + SalesDataService.SumTotal(listOfKeys) + " €");
                    
                    
                    }
                    catch (Exception e) {
                        System.out.println("Error: No hay mas usuarios que mostrar " + e.toString()); 
                        SetNumberOfUserPages0();
                        printUsers(0);
                        System.out.println("Voy a poner los user a 0");
                        //createWindowsProductPage();
                    }
                    break;
                case 4:
                    try {
                        System.out.println("caso4");
                    jButtonUser1.setVisible(true);
                    jButtonUser1.setText(listOfKeys.get(numberOfUserPages).getTitulo());
                    jButtonUser2.setVisible(true);
                    jButtonUser2.setText(listOfKeys.get(numberOfUserPages+1).getTitulo());
                    jButtonUser3.setVisible(true);
                    jButtonUser3.setText(listOfKeys.get(numberOfUserPages+2).getTitulo());
                    jButtonUser4.setVisible(true);
                    jButtonUser4.setText(listOfKeys.get(numberOfUserPages+3).getTitulo());
                    jLabelTotal.setText("Total: " + SalesDataService.SumTotal(listOfKeys) + " €");
                    
                    
                    }
                    catch (Exception e) {
                        System.out.println("Error: No hay mas usuarios que mostrar " + e.toString()); 
                        SetNumberOfUserPages0();
                        printUsers(0);
                        System.out.println("Voy a poner los user a 0");
                        //createWindowsProductPage();
                    }
                    
                    break;
                case 5:
                    try {
                        System.out.println("caso5");
                    jButtonUser1.setVisible(true);
                    jButtonUser1.setText(listOfKeys.get(numberOfUserPages).getTitulo());
                    jButtonUser2.setVisible(true);
                    jButtonUser2.setText(listOfKeys.get(numberOfUserPages+1).getTitulo());
                    jButtonUser3.setVisible(true);
                    jButtonUser3.setText(listOfKeys.get(numberOfUserPages+2).getTitulo());
                    jButtonUser4.setVisible(true);
                    jButtonUser4.setText(listOfKeys.get(numberOfUserPages+3).getTitulo());
                    jButtonUser5.setVisible(true);
                    jButtonUser5.setText(listOfKeys.get(numberOfUserPages+4).getTitulo());
                    jLabelTotal.setText("Total: " + SalesDataService.SumTotal(listOfKeys) + " €");
                    
                    }
                    catch (Exception e) {
                        System.out.println("Error: No hay mas usuarios que mostrar " + e.toString()); 
                        SetNumberOfUserPages0();
                        printUsers(0);
                        //createWindowsProductPage();
                    }
                    break;
                case 6:
                    try {
                        System.out.println("caso6");
                    jButtonUser1.setVisible(true);
                    jButtonUser1.setText(listOfKeys.get(numberOfUserPages).getTitulo());
                    jButtonUser2.setVisible(true);
                    jButtonUser2.setText(listOfKeys.get(numberOfUserPages+1).getTitulo());
                    jButtonUser3.setVisible(true);
                    jButtonUser3.setText(listOfKeys.get(numberOfUserPages+2).getTitulo());
                    jButtonUser4.setVisible(true);
                    jButtonUser4.setText(listOfKeys.get(numberOfUserPages+3).getTitulo());
                    jButtonUser5.setVisible(true);
                    jButtonUser5.setText(listOfKeys.get(numberOfUserPages+4).getTitulo());
                    jButtonUser6.setVisible(true);
                    jButtonUser6.setText(listOfKeys.get(numberOfUserPages+5).getTitulo());
                    jLabelTotal.setText("Total: " + SalesDataService.SumTotal(listOfKeys) + " €");
                    }
                    catch (Exception e) {
                        System.out.println("Error: No hay mas usuarios que mostrar " + e.toString()); 
                        SetNumberOfUserPages0();
                        printUsers(0);
                        //createWindowsProductPage();
                    }
                    break;
                case 7:
                    try {
                        System.out.println("caso7");
                    jButtonUser1.setVisible(true);
                    jButtonUser1.setText(listOfKeys.get(numberOfUserPages).getTitulo());
                    jButtonUser2.setVisible(true);
                    jButtonUser2.setText(listOfKeys.get(numberOfUserPages+1).getTitulo());
                    jButtonUser3.setVisible(true);
                    jButtonUser3.setText(listOfKeys.get(numberOfUserPages+2).getTitulo());
                    jButtonUser4.setVisible(true);
                    jButtonUser4.setText(listOfKeys.get(numberOfUserPages+3).getTitulo());
                    jButtonUser5.setVisible(true);
                    jButtonUser5.setText(listOfKeys.get(numberOfUserPages+4).getTitulo());
                    jButtonUser6.setVisible(true);
                    jButtonUser6.setText(listOfKeys.get(numberOfUserPages+5).getTitulo());
                    jButtonUser7.setVisible(true);
                    jButtonUser7.setText(listOfKeys.get(numberOfUserPages+6).getTitulo());
                    jLabelTotal.setText("Total: " + SalesDataService.SumTotal(listOfKeys) + " €");
                    }
                    catch (Exception e) {
                        System.out.println("Error: No hay mas productos que mostrar " + e.toString()); 
                        SetNumberOfUserPages0();
                        printUsers(0);
                        //createWindowsProductPage();
                    }
                    break;
                default:
                    System.out.println("somos 8 o mas  "  );   
                    try {
                            System.out.println("caso8");
                            System.out.println("somos 8 o mas  y estamos haciendolo bien"  );   
                            System.out.println("la i es: " + i + "y i +1 es= " + i +1 ); 
                            System.out.println(listOfKeys);
                    jButtonUser1.setVisible(true);
                    jButtonUser1.setText(listOfKeys.get(numberOfUserPages).getTitulo());
                    jButtonUser2.setVisible(true);
                    jButtonUser2.setText(listOfKeys.get(numberOfUserPages+1).getTitulo());
                    jButtonUser3.setVisible(true);
                    jButtonUser3.setText(listOfKeys.get(numberOfUserPages+2).getTitulo());
                    jButtonUser4.setVisible(true);
                    jButtonUser4.setText(listOfKeys.get(numberOfUserPages+3).getTitulo());
                    jButtonUser5.setVisible(true);
                    jButtonUser5.setText(listOfKeys.get(numberOfUserPages+4).getTitulo());
                    jButtonUser6.setVisible(true);
                    jButtonUser6.setText(listOfKeys.get(numberOfUserPages+5).getTitulo());
                    jButtonUser7.setVisible(true);
                    jButtonUser7.setText(listOfKeys.get(numberOfUserPages+6).getTitulo());
                    jButtonUser8.setVisible(true);
                    jButtonUser8.setText(listOfKeys.get(numberOfUserPages+7).getTitulo());
                    jLabelTotal.setText("Total: " + SalesDataService.SumTotal(listOfKeys) + " €");      
                    }
                    catch (Exception e) {
                         System.out.println("somos 8 o mas  y estamos dando error"  );       
                        System.out.println("Error: No hay mas usuarios que mostrar " + e.toString()); 
                        SetNumberOfUserPages0();
                        //createWindowsProductPage();
                        printUsers(0);
                    }
                    break;
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
        jButton8 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jButtonUserDelete = new javax.swing.JButton();
        jButtonUserInfo = new javax.swing.JButton();
        jLabelProductlSelected = new javax.swing.JLabel();
        jPanelUsersFound = new javax.swing.JPanel();
        jButtonUser1 = new javax.swing.JButton();
        jButtonUser2 = new javax.swing.JButton();
        jButtonUser3 = new javax.swing.JButton();
        jButtonUser8 = new javax.swing.JButton();
        jButtonUser4 = new javax.swing.JButton();
        jButtonUser5 = new javax.swing.JButton();
        jButtonUser6 = new javax.swing.JButton();
        jButtonUser7 = new javax.swing.JButton();
        jLabelTotal = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabelEmptyCarrito = new javax.swing.JLabel();
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

        jButton8.setText("jButton2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(6, 40, 73));
        jPanel1.setToolTipText("");
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Roboto Black", 0, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("AllSafe Cibersecurity");
        jPanel7.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(435, 6, 293, -1));

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));
        jPanel8.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true));

        jButtonUserDelete.setText("Eliminar");
        jButtonUserDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonUserDeleteActionPerformed(evt);
            }
        });

        jButtonUserInfo.setText("Información");
        jButtonUserInfo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonUserInfoActionPerformed(evt);
            }
        });

        jLabelProductlSelected.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        jLabelProductlSelected.setText("Selecciona un producto");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabelProductlSelected, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jButtonUserInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 112, Short.MAX_VALUE)
                .addComponent(jButtonUserDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabelProductlSelected)
                .addGap(35, 35, 35)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonUserInfo)
                    .addComponent(jButtonUserDelete))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        jPanel7.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(36, 44, -1, -1));

        jPanelUsersFound.setBackground(new java.awt.Color(255, 255, 255));
        jPanelUsersFound.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true));
        jPanelUsersFound.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButtonUser1.setText("jButtonUser1");
        jButtonUser1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonUser1ActionPerformed(evt);
            }
        });
        jPanelUsersFound.add(jButtonUser1, new org.netbeans.lib.awtextra.AbsoluteConstraints(72, 18, 217, 41));

        jButtonUser2.setText("jButtonUser2");
        jButtonUser2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonUser2ActionPerformed(evt);
            }
        });
        jPanelUsersFound.add(jButtonUser2, new org.netbeans.lib.awtextra.AbsoluteConstraints(72, 71, 217, 41));

        jButtonUser3.setText("jButtonUser3");
        jButtonUser3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonUser3ActionPerformed(evt);
            }
        });
        jPanelUsersFound.add(jButtonUser3, new org.netbeans.lib.awtextra.AbsoluteConstraints(72, 118, 217, 40));

        jButtonUser8.setText("jButtonUser8");
        jButtonUser8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonUser8ActionPerformed(evt);
            }
        });
        jPanelUsersFound.add(jButtonUser8, new org.netbeans.lib.awtextra.AbsoluteConstraints(72, 367, 217, 40));

        jButtonUser4.setText("jButtonUser4");
        jButtonUser4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonUser4ActionPerformed(evt);
            }
        });
        jPanelUsersFound.add(jButtonUser4, new org.netbeans.lib.awtextra.AbsoluteConstraints(72, 164, 217, 40));

        jButtonUser5.setText("jButtonUser5");
        jButtonUser5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonUser5ActionPerformed(evt);
            }
        });
        jPanelUsersFound.add(jButtonUser5, new org.netbeans.lib.awtextra.AbsoluteConstraints(72, 210, 220, 40));

        jButtonUser6.setText("jButtonUser6");
        jButtonUser6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonUser6ActionPerformed(evt);
            }
        });
        jPanelUsersFound.add(jButtonUser6, new org.netbeans.lib.awtextra.AbsoluteConstraints(72, 262, 217, 40));

        jButtonUser7.setText("jButtonUser7");
        jButtonUser7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonUser7ActionPerformed(evt);
            }
        });
        jPanelUsersFound.add(jButtonUser7, new org.netbeans.lib.awtextra.AbsoluteConstraints(72, 314, 217, 41));

        jLabelTotal.setText("Total:");
        jPanelUsersFound.add(jLabelTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 430, 150, 20));

        jPanel7.add(jPanelUsersFound, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 10, 355, 450));

        jButton1.setText("Comprar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel7.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(36, 230, 160, 40));

        jButton2.setText("Vaciar carrito");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel7.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 230, 159, 40));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabelEmptyCarrito.setFont(new java.awt.Font("Noteworthy", 0, 18)); // NOI18N
        jLabelEmptyCarrito.setText("El carrito esta vacío. Echale un vistazo a nuestras últimas ofertas.");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabelEmptyCarrito, javax.swing.GroupLayout.PREFERRED_SIZE, 462, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 38, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabelEmptyCarrito, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 14, Short.MAX_VALUE))
        );

        jPanel7.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(36, 342, -1, 60));

        jPanel1.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 30, 1140, 470));

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
        else if (secundariaProductos != null){
          secundariaProductos.setVisible(true);
        }
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
            //opinion= opinion+1;
            //createWindowsProductPage();
            printUsers(-1);
    }//GEN-LAST:event_jButtonHomeIconsGround8ActionPerformed

    private void jButtonHomeIconsGround7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonHomeIconsGround7ActionPerformed
        // TODO add your handling code here:
        //opinion= opinion-1;
        //createWindowsProductPage();
        //TODO Execptio!!!!!
        printUsers(1);
    }//GEN-LAST:event_jButtonHomeIconsGround7ActionPerformed

    private void jButtonUser1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonUser1ActionPerformed
        // TODO add your handling code here:
        //productMgmt =  UsersServices.getUser(jButtonUser1.getText());
        jLabelProductlSelected.setText(jButtonUser1.getText());
    }//GEN-LAST:event_jButtonUser1ActionPerformed

    private void jButtonUser2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonUser2ActionPerformed
        // TODO add your handling code here:
        jLabelProductlSelected.setText(jButtonUser2.getText());
    }//GEN-LAST:event_jButtonUser2ActionPerformed

    private void jButtonUser3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonUser3ActionPerformed
        // TODO add your handling code here:
       jLabelProductlSelected.setText(jButtonUser3.getText());
    }//GEN-LAST:event_jButtonUser3ActionPerformed

    private void jButtonUser4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonUser4ActionPerformed
        // TODO add your handling code here:
        jLabelProductlSelected.setText(jButtonUser4.getText());
    }//GEN-LAST:event_jButtonUser4ActionPerformed

    private void jButtonUser5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonUser5ActionPerformed
        // TODO add your handling code here:
        jLabelProductlSelected.setText(jButtonUser5.getText());
    }//GEN-LAST:event_jButtonUser5ActionPerformed

    private void jButtonUser6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonUser6ActionPerformed
        // TODO add your handling code here:
        jLabelProductlSelected.setText(jButtonUser6.getText());
    }//GEN-LAST:event_jButtonUser6ActionPerformed

    private void jButtonUser7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonUser7ActionPerformed
        // TODO add your handling code here:
        jLabelProductlSelected.setText(jButtonUser7.getText());
    }//GEN-LAST:event_jButtonUser7ActionPerformed

    private void jButtonUser8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonUser8ActionPerformed
        // TODO add your handling code here:
       jLabelProductlSelected.setText(jButtonUser8.getText());
    }//GEN-LAST:event_jButtonUser8ActionPerformed

    private void jButtonUserDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonUserDeleteActionPerformed
        // TODO add your handling code here:
         if (jLabelProductlSelected.getText() != "Selecciona un producto"){
             ArrayList<Producto> listOfKeys  = UsersServices.getObjectShoppingCart(user);
             boolean found = false;
             int i=0;
             while (!found){
                 System.out.println("ESTOY BUSCANDO EL PRODUCTO EN " + jLabelProductlSelected.getText() );
                 
               if (  listOfKeys.get(i).getTitulo() == jLabelProductlSelected.getText() ) {
                  found = true;
                  if (UsersServices.deleteObjectShoppingCart(user, listOfKeys.get(i))) {
                      System.out.println("INFO El procuto ha podido ser eliminado");
                  }
                  else {
                      System.out.println("ERROR El producto no ha podido ser eliminado");
                  }
               }
               i++;
             }  
         }
        else {
            System.out.println("INFO: No se ha seleccionado ningún producto");
            JOptionPane.showMessageDialog(null, "No se ha seleccionado ningún producto","Información para el usuario", JOptionPane.INFORMATION_MESSAGE);
        }
        createWindowsProductPage();
        jLabelProductlSelected.setText("Selecciona un producto");
    }//GEN-LAST:event_jButtonUserDeleteActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        if (UsersServices.cleanShoppingCart(user)){
            System.out.println("INFO: Se ha limpiado el carrito");
            JOptionPane.showMessageDialog(null, "Se ha limpiado el carrito","Información para el usuario", JOptionPane.INFORMATION_MESSAGE);
        }
        else {
            System.out.println("ERROR: no ha podido limpiarse el carrito");
            JOptionPane.showMessageDialog(null, "No ha podido limpiarse el carrito, contacte con nosotros","Información para el usuario", JOptionPane.WARNING_MESSAGE);
        
        }
        createWindowsProductPage();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButtonUserInfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonUserInfoActionPerformed
        // TODO add your handling code here:
        // TODO show info of the producto new jframe or show info in the screen:
        if (jLabelProductlSelected.getText() != "Selecciona un producto"){
             ArrayList<Producto> listOfKeys  = UsersServices.getObjectShoppingCart(user);
             boolean found = false;
             int i=0;
             while (!found){
                 System.out.println("ESTOY BUSCANDO EL PRODUCTO EN " + jLabelProductlSelected.getText() );
                 
               if (  listOfKeys.get(i).getTitulo() == jLabelProductlSelected.getText() ) {
                  found = true;
                  WindowsProductReportingInfo windowsproductFromShoppingCart = new WindowsProductReportingInfo(this , listOfKeys.get(i));
//                  if (UsersServices.deleteObjectShoppingCart(user, listOfKeys.get(i))) {
//                      System.out.println("INFO El procuto ha podido ser eliminado");
//                  }
//                  else {
//                      System.out.println("ERROR El producto no ha podido ser eliminado");
//                  }  
               }
               i++;
             }  
         }
        else {
            System.out.println("INFO: No se ha seleeccionado ningún producto");
        }
        createWindowsProductPage();
        jLabelProductlSelected.setText("Selecciona un producto");
    }//GEN-LAST:event_jButtonUserInfoActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        //Comprobar stock carrito:
        
//        if (!UsersServices.getObjectShoppingCart(user).isEmpty()){
//                printUsers(0);
//            }
//            else{
//                jLabelEmptyCarrito.setVisible(true);
//            
//            }
        
//     int options = JOptionPane.YES_NO_OPTION;   
//     int result = JOptionPane.showConfirmDialog(this, "La compra lleva unos gastos de envío de 5 euros, acepta la compra" ,"Condiciones de compra", options, 3);
//     if (result == JOptionPane.YES_OPTION){
//         System.out.println("hola mundo");
//     }
//     
    String[] options = new String[] {"Yes", "No"};
    int response = JOptionPane.showOptionDialog(null, "La compra lleva asociados unos gastos de envío de 5 euros. ¿Acepta los términos?", "Condiciones de compra", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
    
    if (response == 0){
        System.out.println("INFO: Procedemos con el proceso de compra"); 
             if (!UsersServices.getObjectShoppingCart(user).isEmpty()){
                 
                //if (jFormattedTCNumero.getText().length() == 16 
                // fecha.isAfter(LocalDate.now()
                if (UsersServices.checkDateCreditCard(user)) {
                 
                            if (SalesDataService.Sales(user)) {
                                //SAVE INVENTORY DATA
                                InventoryServices.saveInventoryData();
                                SalesDataService.saveSalesData();
                                System.out.println("La compra se ha realizado con exito, procedemos a vaciar el carrito");
                                JOptionPane.showMessageDialog(null, "La compra se ha realizado con exito, procedemos a vaciar el carrito","Información para el usuario", JOptionPane.INFORMATION_MESSAGE);
                                if (UsersServices.cleanShoppingCart(user)){
                                System.out.println("INFO: Se ha limpiado el carrito");
                                 }
                                 else {
                                    System.out.println("ERROR: no ha podido limpiarse el carrito");

                                    }
                            createWindowsProductPage();
                            }
                            
                           else {
                            System.out.println("INFO: No se puede continuar el proceso de compra");
                            JOptionPane.showMessageDialog(null, "La compra no se puede realizar, no hay stock suficiente hay un problema en el servicio de venta.","Información para el usuario", JOptionPane.WARNING_MESSAGE);
                            }
                            
                }      
                            
                else {
                    System.out.println("INFO: No se puede continuar el proceso de compra, la tarjeta esta caducada");
                    JOptionPane.showMessageDialog(null, "No se puede continuar el proceso de compra, la tarjeta esta caducada, por favor actualicela desde su cuenta de usuario","Información para el usuario", JOptionPane.WARNING_MESSAGE);
                        
                }
                
                
             }
             else{
                 JOptionPane.showMessageDialog(null, "El carrito no tiene nada, echa un vistazo en nuestro catálogo ;) ","Información para el usuario", JOptionPane.INFORMATION_MESSAGE);
             }
    }
    
    
    
    
    else {
        System.out.println("INFO: Al no aceptar las condiciones de compra, interrumpimos la compra");
        JOptionPane.showMessageDialog(null, "El proceso de compra no ha continuado ya que no se han aceptado las condiciones de compra.","Información para el usuario", JOptionPane.INFORMATION_MESSAGE);
    }
        
              
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButtonHomeIconsGround5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonHomeIconsGround5ActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(null, "Si lo necesita, puede ponerse en contacto con nosotros en el 900-123-123, estaremos encantados de atenderle.","Información para el usuario", JOptionPane.INFORMATION_MESSAGE);

    }//GEN-LAST:event_jButtonHomeIconsGround5ActionPerformed

    private void jButtonHomeIconsGround6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonHomeIconsGround6ActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(null, "Si lo necesita, puede ponerse en contacto con nosotros por mail escribiendo a supportAllSafe@allsafe.com, estaremos encantados de atenderle.","Información para el usuario", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_jButtonHomeIconsGround6ActionPerformed

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.Box.Filler filler1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButtonHomeIconsGround5;
    private javax.swing.JButton jButtonHomeIconsGround6;
    private javax.swing.JButton jButtonHomeIconsGround7;
    private javax.swing.JButton jButtonHomeIconsGround8;
    private javax.swing.JButton jButtonHomeIconsGround9;
    private javax.swing.JButton jButtonUser1;
    private javax.swing.JButton jButtonUser2;
    private javax.swing.JButton jButtonUser3;
    private javax.swing.JButton jButtonUser4;
    private javax.swing.JButton jButtonUser5;
    private javax.swing.JButton jButtonUser6;
    private javax.swing.JButton jButtonUser7;
    private javax.swing.JButton jButtonUser8;
    private javax.swing.JButton jButtonUserDelete;
    private javax.swing.JButton jButtonUserInfo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelEmptyCarrito;
    private javax.swing.JLabel jLabelHomeIcon4;
    private javax.swing.JLabel jLabelProductlSelected;
    private javax.swing.JLabel jLabelTimeline7;
    private javax.swing.JLabel jLabelTimeline8;
    private javax.swing.JLabel jLabelTotal;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanelUsersFound;
    private javax.swing.JSeparator jSeparator1;
    // End of variables declaration//GEN-END:variables
}
