/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.allsafe.ui;

import com.allsafe.mock.UserData;
import com.allsafe.model.ClienteParticular;
import com.allsafe.model.Direccion;
import com.allsafe.model.Inventario;
import com.allsafe.model.Producto;
import com.allsafe.model.TarjetaDeCredito;
import com.allsafe.model.Usuario;
import com.allsafe.service.Login;
import com.allsafe.service.RandomHomeProductos;
import com.allsafe.service.UsersServices;
import java.awt.Color;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
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

public class WindowsAdminUserMngt extends javax.swing.JFrame  {

    private WindowsAdmin principal;
    private WindowsProduct secundariaProductos;
    private  Producto producto;
    private Usuario user;
    private Usuario userMgmt;
    private int numberOfUserPages=0;
    Login miservicioDeLogin = Login.getInstance();
    UserData userData = UserData.getInstance();
    
    
// ********************************************************************************************************************    
    /** Creates new form WindowProduct */
    public WindowsAdminUserMngt(WindowsAdmin ventana, Usuario u) {
        //Ocultamos la ventana principal
        principal = ventana;
        principal.setVisible(false);
        user = u;
        this.producto =producto;
        initComponents();
        this.setVisible(true);
        createWindowsProductPage();
        
    }
  // ********************************************************************************************************************
    
    
    
// ********************************************************************************************************************
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
            
            
            jButtonUser1.setVisible(false);        
            jButtonUser2.setVisible(false);
            jButtonUser3.setVisible(false);
            jButtonUser4.setVisible(false);
            jButtonUser5.setVisible(false);
            jButtonUser6.setVisible(false);
            jButtonUser7.setVisible(false);
            jButtonUser8.setVisible(false);
            jPanelUsersFound.setVisible(false);
           
            //SET BOTTON HOME PAGE.
         
        } 
        catch (Exception e) {
            System.out.println("Error: " + e.toString()); 
            //opinion=0;
            createWindowsProductPage();
        }
    }
 
// ********************************************************************************************************************

// ********************************************************************************************************************    
    public  void  SetNumberOfUserPages0() {
        this.numberOfUserPages = 0;
 }
// ********************************************************************************************************************    
    
  
// ********************************************************************************************************************    
 /**
* Nos permite mostrar los usuarios en la interfaz  con todos lo elementos necesarios de forma dinámica.
* Estos usuarios están recogidos en un ArrayList,con las claves (key) de los Usuarios, listOfKeys, mediante el parametro i mostraremos
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
           
                ArrayList<String> listOfKeys  = UsersServices.getUser();
                int sizeUserData=listOfKeys.size();
                //System.out.println(numberOfUserPages);
                numberOfUserPages = numberOfUserPages +i;
                //System.out.println(numberOfUserPages);
                jPanelUsersFound.setVisible(true);
                switch (sizeUserData) {
                case 1 : 
                    try {
                        //System.out.println("caso1");
                    jButtonUser1.setVisible(true);
                    jButtonUser1.setText(listOfKeys.get(numberOfUserPages));
                    }
                    catch (Exception e) {
                        System.out.println("INFO: No hay mas usuarios que mostrar " + e.toString()); 
                        SetNumberOfUserPages0();
                        System.out.println("INFO: Voy a poner el recorrido de los usuarios a 0");
                        printUsers(0);
                        
                        //createWindowsProductPage();
                    }
                    break;
                case 2 :
                    try {
                        //System.out.println("caso2");
                    jButtonUser1.setVisible(true);
                    jButtonUser1.setText(listOfKeys.get(numberOfUserPages));
                    jButtonUser2.setVisible(true);
                    jButtonUser2.setText(listOfKeys.get(numberOfUserPages+1));
                    }
                    catch (Exception e) {
                        System.out.println("INFO: No hay mas usuarios que mostrar " + e.toString()); 
                        System.out.println("INFO: Voy a poner el recorrido de los usuarios a 0");
                        SetNumberOfUserPages0();
                        printUsers(0);
                        //createWindowsProductPage();
                    }
                    
                    break;
                case 3:
                    try {
                        //System.out.println("caso3");
                    jButtonUser1.setVisible(true);
                    jButtonUser1.setText(listOfKeys.get(numberOfUserPages));
                    jButtonUser2.setVisible(true);
                    jButtonUser2.setText(listOfKeys.get(numberOfUserPages+1));
                    jButtonUser3.setVisible(true);
                    jButtonUser3.setText(listOfKeys.get(numberOfUserPages+2));
                    }
                    catch (Exception e) {
                        System.out.println("INFO: No hay mas usuarios que mostrar " + e.toString()); 
                        SetNumberOfUserPages0();
                        printUsers(0);
                        System.out.println("INFO: Voy a poner el recorrido de los usuarios a 0");
                        //createWindowsProductPage();
                    }
                    break;
                case 4:
                    try {
                        //System.out.println("caso4");
                    jButtonUser1.setVisible(true);
                    jButtonUser1.setText(listOfKeys.get(numberOfUserPages));
                    jButtonUser2.setVisible(true);
                    jButtonUser2.setText(listOfKeys.get(numberOfUserPages+1));
                    jButtonUser3.setVisible(true);
                    jButtonUser3.setText(listOfKeys.get(numberOfUserPages+2));
                    jButtonUser4.setVisible(true);
                    jButtonUser4.setText(listOfKeys.get(numberOfUserPages+3));
                    }
                    catch (Exception e) {
                        System.out.println("INFO: No hay mas usuarios que mostrar " + e.toString()); 
                        SetNumberOfUserPages0();
                        printUsers(0);
                        System.out.println("INFO: Voy a poner el recorrido de los usuarios a 0");
                        //createWindowsProductPage();
                    }
                    
                    break;
                case 5:
                    try {
                        //System.out.println("caso5");
                    jButtonUser1.setVisible(true);
                    jButtonUser1.setText(listOfKeys.get(numberOfUserPages));
                    jButtonUser2.setVisible(true);
                    jButtonUser2.setText(listOfKeys.get(numberOfUserPages+1));
                    jButtonUser3.setVisible(true);
                    jButtonUser3.setText(listOfKeys.get(numberOfUserPages+2));
                    jButtonUser4.setVisible(true);
                    jButtonUser4.setText(listOfKeys.get(numberOfUserPages+3));
                    jButtonUser5.setVisible(true);
                    jButtonUser5.setText(listOfKeys.get(numberOfUserPages+4));
                    }
                    catch (Exception e) {
                        System.out.println("INFO: No hay mas usuarios que mostrar " + e.toString()); 
                        SetNumberOfUserPages0();
                        printUsers(0);
                        System.out.println("INFO: Voy a poner el recorrido de los usuarios a 0");
                        //createWindowsProductPage();
                    }
                    break;
                case 6:
                    try {
                        //System.out.println("caso6");
                    jButtonUser1.setVisible(true);
                    jButtonUser1.setText(listOfKeys.get(numberOfUserPages));
                    jButtonUser2.setVisible(true);
                    jButtonUser2.setText(listOfKeys.get(numberOfUserPages+1));
                    jButtonUser3.setVisible(true);
                    jButtonUser3.setText(listOfKeys.get(numberOfUserPages+2));
                    jButtonUser4.setVisible(true);
                    jButtonUser4.setText(listOfKeys.get(numberOfUserPages+3));
                    jButtonUser5.setVisible(true);
                    jButtonUser5.setText(listOfKeys.get(numberOfUserPages+4));
                    jButtonUser6.setVisible(true);
                    jButtonUser6.setText(listOfKeys.get(numberOfUserPages+5));
                    }
                    catch (Exception e) {
                        System.out.println("INFO: No hay mas usuarios que mostrar " + e.toString()); 
                        SetNumberOfUserPages0();
                        printUsers(0);
                        System.out.println("INFO: Voy a poner el recorrido de los usuarios a 0");
                        //createWindowsProductPage();
                    }
                    break;
                case 7:
                    try {
                        //System.out.println("caso7");
                    jButtonUser1.setVisible(true);
                    jButtonUser1.setText(listOfKeys.get(numberOfUserPages));
                    jButtonUser2.setVisible(true);
                    jButtonUser2.setText(listOfKeys.get(numberOfUserPages+1));
                    jButtonUser3.setVisible(true);
                    jButtonUser3.setText(listOfKeys.get(numberOfUserPages+2));
                    jButtonUser4.setVisible(true);
                    jButtonUser4.setText(listOfKeys.get(numberOfUserPages+3));
                    jButtonUser5.setVisible(true);
                    jButtonUser5.setText(listOfKeys.get(numberOfUserPages+4));
                    jButtonUser6.setVisible(true);
                    jButtonUser6.setText(listOfKeys.get(numberOfUserPages+5));
                    jButtonUser7.setVisible(true);
                    jButtonUser7.setText(listOfKeys.get(numberOfUserPages+6));
                    }
                    catch (Exception e) {
                        System.out.println("INFO: No hay mas usuarios que mostrar " + e.toString()); 
                        SetNumberOfUserPages0();
                        printUsers(0);
                        System.out.println("INFO: Voy a poner el recorrido de los usuarios a 0");
                        //createWindowsProductPage();
                    }
                    break;
                default:
                    //System.out.println("Hay 8 o mas usuarios  "  );   
                    try {
                            //System.out.println("caso8");
                            //System.out.println("Hay 8 o mas"  );   
                            //System.out.println("la i es: " + i + "y i +1 es= " + i +1 ); 
                            //System.out.println(listOfKeys);
                    jButtonUser1.setVisible(true);
                    jButtonUser1.setText(listOfKeys.get(numberOfUserPages));
                    jButtonUser2.setVisible(true);
                    jButtonUser2.setText(listOfKeys.get(numberOfUserPages+1));
                    jButtonUser3.setVisible(true);
                    jButtonUser3.setText(listOfKeys.get(numberOfUserPages+2));
                    jButtonUser4.setVisible(true);
                    jButtonUser4.setText(listOfKeys.get(numberOfUserPages+3));
                    jButtonUser5.setVisible(true);
                    jButtonUser5.setText(listOfKeys.get(numberOfUserPages+4));
                    jButtonUser6.setVisible(true);
                    jButtonUser6.setText(listOfKeys.get(numberOfUserPages+5));
                    jButtonUser7.setVisible(true);
                    jButtonUser7.setText(listOfKeys.get(numberOfUserPages+6));
                    jButtonUser8.setVisible(true);
                    jButtonUser8.setText(listOfKeys.get(numberOfUserPages+7));
                    }
                    catch (Exception e) {
                        //System.out.println("Hay 8 o mas  y estamos dando error"  );       
                        System.out.println("INFO: No hay mas usuarios que mostrar " + e.toString()); 
                        SetNumberOfUserPages0();
                        //createWindowsProductPage();
                        printUsers(0);
                        System.out.println("INFO: Voy a poner el recorrido de los usuarios a 0");
                    }
                    break;
                }
    }

// ********************************************************************************************************************

// ********************************************************************************************************************
private JFrame getFrame(){
     return this;
    }
// ********************************************************************************************************************
 
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
        jButton8 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        jPanel5 = new javax.swing.JPanel();
        jLabel2UserMail = new javax.swing.JLabel();
        jLabel2UserPass = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jPasswordUserPass = new javax.swing.JPasswordField();
        jTextFieldUserMail = new javax.swing.JTextField();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel2UserMail1 = new javax.swing.JLabel();
        jButtonSearch = new javax.swing.JButton();
        jButtonUserDelete = new javax.swing.JButton();
        jButtonUserInfo = new javax.swing.JButton();
        jLabelMailUser = new javax.swing.JLabel();
        jTextFieldSearchUser = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        jPanelUsersFound = new javax.swing.JPanel();
        jButtonUser1 = new javax.swing.JButton();
        jButtonUser2 = new javax.swing.JButton();
        jButtonUser3 = new javax.swing.JButton();
        jButtonUser8 = new javax.swing.JButton();
        jButtonUser4 = new javax.swing.JButton();
        jButtonUser5 = new javax.swing.JButton();
        jButtonUser6 = new javax.swing.JButton();
        jButtonUser7 = new javax.swing.JButton();
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

        jLabel1.setFont(new java.awt.Font("Roboto Black", 0, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("AllSafe Cibersecurity");

        jSeparator4.setForeground(new java.awt.Color(51, 51, 51));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        jLabel2UserMail.setText("Usuario correo");

        jLabel2UserPass.setText("Clave");

        jButton1.setText("Registrar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jPasswordUserPass.setForeground(new java.awt.Color(204, 204, 204));
        jPasswordUserPass.setText("********");
        jPasswordUserPass.setBorder(null);
        jPasswordUserPass.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPasswordUserPassMousePressed(evt);
            }
        });

        jTextFieldUserMail.setForeground(new java.awt.Color(204, 204, 204));
        jTextFieldUserMail.setText("Ingrese su nombre de usuario");
        jTextFieldUserMail.setBorder(null);
        jTextFieldUserMail.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jTextFieldUserMailMousePressed(evt);
            }
        });
        jTextFieldUserMail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldUserMailActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2UserMail)
                    .addComponent(jLabel2UserPass))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextFieldUserMail, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPasswordUserPass, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2UserMail)
                    .addComponent(jTextFieldUserMail, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jPasswordUserPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2UserPass))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1)
                .addContainerGap())
        );

        jLabel2.setText("Añadir administrador");

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));
        jPanel8.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        jLabel2UserMail1.setText("Usuario correo");

        jButtonSearch.setText("Buscar");
        jButtonSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSearchActionPerformed(evt);
            }
        });

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

        jLabelMailUser.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        jLabelMailUser.setText("mail");

        jTextFieldSearchUser.setForeground(new java.awt.Color(204, 204, 204));
        jTextFieldSearchUser.setText("Ingrese su nombre de usuario");
        jTextFieldSearchUser.setBorder(null);
        jTextFieldSearchUser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jTextFieldSearchUserMousePressed(evt);
            }
        });
        jTextFieldSearchUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldSearchUserActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButtonUserDelete)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonUserInfo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonSearch)
                .addGap(15, 15, 15))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(17, 17, 17))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addComponent(jLabelMailUser, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addComponent(jLabel2UserMail1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                                .addComponent(jTextFieldSearchUser, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(6, 6, 6))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2UserMail1)
                    .addComponent(jTextFieldSearchUser, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelMailUser)
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonUserDelete)
                    .addComponent(jButtonUserInfo)
                    .addComponent(jButtonSearch))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        jLabel3.setText("Buscar usuario");

        jPanelUsersFound.setBackground(new java.awt.Color(255, 255, 255));
        jPanelUsersFound.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true));

        jButtonUser1.setText("jButtonUser1");
        jButtonUser1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonUser1ActionPerformed(evt);
            }
        });

        jButtonUser2.setText("jButtonUser2");
        jButtonUser2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonUser2ActionPerformed(evt);
            }
        });

        jButtonUser3.setText("jButtonUser3");
        jButtonUser3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonUser3ActionPerformed(evt);
            }
        });

        jButtonUser8.setText("jButtonUser8");
        jButtonUser8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonUser8ActionPerformed(evt);
            }
        });

        jButtonUser4.setText("jButtonUser4");
        jButtonUser4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonUser4ActionPerformed(evt);
            }
        });

        jButtonUser5.setText("jButtonUser5");
        jButtonUser5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonUser5ActionPerformed(evt);
            }
        });

        jButtonUser6.setText("jButtonUser6");
        jButtonUser6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonUser6ActionPerformed(evt);
            }
        });

        jButtonUser7.setText("jButtonUser7");
        jButtonUser7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonUser7ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelUsersFoundLayout = new javax.swing.GroupLayout(jPanelUsersFound);
        jPanelUsersFound.setLayout(jPanelUsersFoundLayout);
        jPanelUsersFoundLayout.setHorizontalGroup(
            jPanelUsersFoundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelUsersFoundLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanelUsersFoundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButtonUser1, javax.swing.GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE)
                    .addComponent(jButtonUser2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonUser3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonUser4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonUser5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonUser6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonUser7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonUser8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(139, 139, 139))
        );
        jPanelUsersFoundLayout.setVerticalGroup(
            jPanelUsersFoundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelUsersFoundLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButtonUser1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonUser2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonUser3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonUser4)
                .addGap(24, 24, 24)
                .addComponent(jButtonUser5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonUser6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonUser7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonUser8)
                .addContainerGap(42, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap(440, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(391, 391, 391))
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(407, 407, 407)
                        .addComponent(jLabel3))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPanel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanelUsersFound, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(126, 126, 126))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(45, 45, 45)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanelUsersFound, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(52, 52, 52))
        );

        jPanel1.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 40, 1150, 470));

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
// ********************************************************************************************************************



// ********************************************************************************************************************    
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
// ********************************************************************************************************************
   
    
    
// ********************************************************************************************************************    
    /**
     * @param args the command line arguments
     */
private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
    // TODO add your handling code here:
    principal.setVisible(true);
}//GEN-LAST:event_formWindowClosed
// ********************************************************************************************************************


// ********************************************************************************************************************
    private void jButtonHomeIconsGround8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonHomeIconsGround8ActionPerformed
        ///TODO Execptio!!!!!
            //opinion= opinion+1;
            //createWindowsProductPage();
            printUsers(-1);
    }//GEN-LAST:event_jButtonHomeIconsGround8ActionPerformed
// ********************************************************************************************************************
    
    
// ********************************************************************************************************************    
    private void jButtonHomeIconsGround7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonHomeIconsGround7ActionPerformed
        // TODO add your handling code here:
        //opinion= opinion-1;
        //createWindowsProductPage();
        //TODO Execptio!!!!!
        printUsers(1);
    }//GEN-LAST:event_jButtonHomeIconsGround7ActionPerformed
// ********************************************************************************************************************
    
    
// ********************************************************************************************************************    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        if( !jTextFieldUserMail.getText().equals("Ingrese su nombre de usuario") && !jTextFieldUserMail.getText().equals("")   ){
            UsersServices.addAdmin(jPasswordUserPass.getText(), jTextFieldUserMail.getText()); 
            jPasswordUserPass.setText("");
            jTextFieldUserMail.setText("");
            //SAVE USER DATA:
            UsersServices.saveUserData();
            
//            System.out.println("Usuarios pedidos directamente:" + UsersServices.getUser());
//            System.out.println("Usuarios pedidos por servicio:" + UsersServices.getUser());
        }
        else {
            System.out.println("INFO: DEBE Añadir un usuario");
            JOptionPane.showMessageDialog(null, "Debe Añadir un nombre de usuario","Información para el usuario", JOptionPane.INFORMATION_MESSAGE);
        
        }
        jPanelUsersFound.setVisible(false);
        
    }//GEN-LAST:event_jButton1ActionPerformed

    
// ********************************************************************************************************************    
    private void jPasswordUserPassMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPasswordUserPassMousePressed
        // TODO add your handling code here:
        if(String.valueOf(jPasswordUserPass.getPassword()).equals("********")){
            jPasswordUserPass.setText("");
            jPasswordUserPass.setForeground(Color.black);

        }
        if(jTextFieldUserMail.getText().isEmpty()){
            jTextFieldUserMail.setText("Ingrese su nombre de usuario");
            jTextFieldUserMail.setForeground(Color.gray);
        }
    }//GEN-LAST:event_jPasswordUserPassMousePressed
// ********************************************************************************************************************
    
    
// ********************************************************************************************************************    
    private void jTextFieldUserMailMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextFieldUserMailMousePressed
        // TODO add your handling code here:
        if(jTextFieldUserMail.getText().equals("Ingrese su nombre de usuario")){
            jTextFieldUserMail.setText("");
            jTextFieldUserMail.setForeground(Color.black);
        }
        if(String.valueOf(jPasswordUserPass.getPassword()).isEmpty()){
            jPasswordUserPass.setText("********");
            jPasswordUserPass.setForeground(Color.gray);
        }
    }//GEN-LAST:event_jTextFieldUserMailMousePressed
// ********************************************************************************************************************

    
// ********************************************************************************************************************    
    private void jTextFieldUserMailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldUserMailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldUserMailActionPerformed

// ********************************************************************************************************************    
 
    
// ********************************************************************************************************************    
    private void jButtonSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSearchActionPerformed
        // TODO add your handling code here:
        //jTextFieldSearchUser.getText(); ||  (jTextFieldSearchUser.getText().contains(""))
        
        if (jTextFieldSearchUser.getText().contains("Ingrese su nombre de usuario")  ){
            try {
             //if null 
             jLabelMailUser.setText("mail");
             SetNumberOfUserPages0();
             printUsers(0);
               
            }
            catch (Exception e){
                System.out.println("Error: No se ha podido realizar la accion: " + e.toString()); 
            }
        }
        else {
         try {
            jPanelUsersFound.setVisible(false); 
            userMgmt =  UsersServices.getUser(jTextFieldSearchUser.getText());
            jTextFieldSearchUser.setText("Ingrese su nombre de usuario");
            jLabelMailUser.setText(userMgmt.getCorreo());
            JOptionPane.showMessageDialog(null, "Se ha encontrado y seleccionado al usuario buscado","Información para el usuario", JOptionPane.INFORMATION_MESSAGE);
            }
            catch (Exception e){
                System.out.println("INFO: El usuario no existe: " + e.toString());
                JOptionPane.showMessageDialog(null, "No se ha encontrado al usuario buscado","Información para el usuario", JOptionPane.WARNING_MESSAGE);
            }
        }     
    }//GEN-LAST:event_jButtonSearchActionPerformed
// ********************************************************************************************************************
    
    
// ********************************************************************************************************************    
    private void jButtonUserInfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonUserInfoActionPerformed
        // TODO add your handling code here:
        if (jLabelMailUser.getText() != "mail"){
            if(!userMgmt.isAdministrador()){
                WindowsMyAccount windowsMyAccount = new WindowsMyAccount(this , userMgmt);
                jLabelMailUser.setText("mail");
            }
            else {
                WindowsMyAccountAdmin windowsMyAccountAdmin = new WindowsMyAccountAdmin(this , userMgmt);
                jLabelMailUser.setText("mail");
            }
        }
        else {
            System.out.println("INFO: No se ha seleccionado ningún usuario");
            JOptionPane.showMessageDialog(null, "No se ha seleccionado ningún usuario","Información para el usuario", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_jButtonUserInfoActionPerformed
// ********************************************************************************************************************
    
    
// ********************************************************************************************************************    
    private void jButtonUser1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonUser1ActionPerformed
        // TODO add your handling code here:
        userMgmt =  UsersServices.getUser(jButtonUser1.getText());
        jLabelMailUser.setText(userMgmt.getCorreo());
        JOptionPane.showMessageDialog(null, "Se ha seleccionado un usuario, puede comprobar su información o eliminarlo","Información para el usuario", JOptionPane.INFORMATION_MESSAGE);  
        
    }//GEN-LAST:event_jButtonUser1ActionPerformed
// ********************************************************************************************************************
    
    
// ********************************************************************************************************************     
    private void jButtonUser2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonUser2ActionPerformed
        // TODO add your handling code here:
        userMgmt =  UsersServices.getUser(jButtonUser2.getText());
        jLabelMailUser.setText(userMgmt.getCorreo());
        JOptionPane.showMessageDialog(null, "Se ha seleccionado un usuario, puede comprobar su información o eliminarlo","Información para el usuario", JOptionPane.INFORMATION_MESSAGE);  
    }//GEN-LAST:event_jButtonUser2ActionPerformed
// ********************************************************************************************************************
    
    
// ********************************************************************************************************************    
    private void jButtonUser3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonUser3ActionPerformed
        // TODO add your handling code here:
        userMgmt =  UsersServices.getUser(jButtonUser3.getText());
        jLabelMailUser.setText(userMgmt.getCorreo());
        JOptionPane.showMessageDialog(null, "Se ha seleccionado un usuario, puede comprobar su información o eliminarlo","Información para el usuario", JOptionPane.INFORMATION_MESSAGE);  
    }//GEN-LAST:event_jButtonUser3ActionPerformed
// ********************************************************************************************************************
    
    
// ********************************************************************************************************************    
    private void jButtonUser4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonUser4ActionPerformed
        // TODO add your handling code here:
        userMgmt =  UsersServices.getUser(jButtonUser4.getText());
        jLabelMailUser.setText(userMgmt.getCorreo());
        JOptionPane.showMessageDialog(null, "Se ha seleccionado un usuario, puede comprobar su información o eliminarlo","Información para el usuario", JOptionPane.INFORMATION_MESSAGE);  
    }//GEN-LAST:event_jButtonUser4ActionPerformed
// ********************************************************************************************************************
    
    
// ********************************************************************************************************************    
    private void jButtonUser5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonUser5ActionPerformed
        // TODO add your handling code here:
        userMgmt =  UsersServices.getUser(jButtonUser5.getText());
        jLabelMailUser.setText(userMgmt.getCorreo());
        JOptionPane.showMessageDialog(null, "Se ha seleccionado un usuario, puede comprobar su información o eliminarlo","Información para el usuario", JOptionPane.INFORMATION_MESSAGE);  
    }//GEN-LAST:event_jButtonUser5ActionPerformed
// ********************************************************************************************************************
    
    
// ********************************************************************************************************************
    private void jButtonUser6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonUser6ActionPerformed
        // TODO add your handling code here:
        userMgmt =  UsersServices.getUser(jButtonUser6.getText());
        jLabelMailUser.setText(userMgmt.getCorreo());
        JOptionPane.showMessageDialog(null, "Se ha seleccionado un usuario, puede comprobar su información o eliminarlo","Información para el usuario", JOptionPane.INFORMATION_MESSAGE);  
    }//GEN-LAST:event_jButtonUser6ActionPerformed
// ********************************************************************************************************************
    
    
    
 // ********************************************************************************************************************   
    private void jButtonUser7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonUser7ActionPerformed
        // TODO add your handling code here:
        userMgmt =  UsersServices.getUser(jButtonUser7.getText());
        jLabelMailUser.setText(userMgmt.getCorreo());
        JOptionPane.showMessageDialog(null, "Se ha seleccionado un usuario, puede comprobar su información o eliminarlo","Información para el usuario", JOptionPane.INFORMATION_MESSAGE);  
    }//GEN-LAST:event_jButtonUser7ActionPerformed
// ********************************************************************************************************************
    
    
    
// ********************************************************************************************************************    
    private void jButtonUser8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonUser8ActionPerformed
        // TODO add your handling code here:
        userMgmt =  UsersServices.getUser(jButtonUser8.getText());
        jLabelMailUser.setText(userMgmt.getCorreo());
        JOptionPane.showMessageDialog(null, "Se ha seleccionado un usuario, puede comprobar su información o eliminarlo","Información para el usuario", JOptionPane.INFORMATION_MESSAGE);  
    }//GEN-LAST:event_jButtonUser8ActionPerformed
// ********************************************************************************************************************
    
    
// ********************************************************************************************************************    
    private void jTextFieldSearchUserMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextFieldSearchUserMousePressed
        // TODO add your handling code here:
        if(jTextFieldSearchUser.getText().equals("Ingrese su nombre de usuario")){
            jTextFieldSearchUser.setText("");
            jTextFieldSearchUser.setForeground(Color.black);
        }
    }//GEN-LAST:event_jTextFieldSearchUserMousePressed
// ********************************************************************************************************************
    
    
// ********************************************************************************************************************    
    private void jTextFieldSearchUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldSearchUserActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldSearchUserActionPerformed
// ********************************************************************************************************************
    
    
    
// ********************************************************************************************************************    
    private void jButtonUserDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonUserDeleteActionPerformed
        // TODO add your handling code here:
         if (jLabelMailUser.getText() != "mail"){
             if (UsersServices.deleteUser(jLabelMailUser.getText())) {
                 //SAVE USER DATA:
                 UsersServices.saveUserData();
                 System.out.println("INFO: El usuario se ha eliminado con exito");
                 JOptionPane.showMessageDialog(null, "El usuario se ha eliminado con exito","Información para el usuario", JOptionPane.INFORMATION_MESSAGE);             
             }
             else {
                 System.out.println("INFO: El usuario no ha podido ser eliminado");
                 JOptionPane.showMessageDialog(null, "El usuario no ha podido ser eliminado, contacte con nosostros","Información para el usuario", JOptionPane.WARNING_MESSAGE);
             }
         }
        else {
            System.out.println("INFO: No se ha seleccionado ningún usuario");
            JOptionPane.showMessageDialog(null, "No se ha seleccionado ningún usuario","Información para el usuario", JOptionPane.INFORMATION_MESSAGE);
        }
        jLabelMailUser.setText("mail");
        jPanelUsersFound.setVisible(false);
           
    }//GEN-LAST:event_jButtonUserDeleteActionPerformed
// ********************************************************************************************************************
    
    
// ********************************************************************************************************************    
    private void jButtonHomeIconsGround6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonHomeIconsGround6ActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(null, "Si lo necesita, puede ponerse en contacto con nosotros por mail escribiendo a supportAllSafe@allsafe.com, estaremos encantados de atenderle.","Información para el usuario", JOptionPane.INFORMATION_MESSAGE);

    }//GEN-LAST:event_jButtonHomeIconsGround6ActionPerformed
// ********************************************************************************************************************
    
    
// ********************************************************************************************************************    
    private void jButtonHomeIconsGround5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonHomeIconsGround5ActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(null, "Si lo necesita, puede ponerse en contacto con nosotros en el 900-123-123, estaremos encantados de atenderle.","Información para el usuario", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_jButtonHomeIconsGround5ActionPerformed
// ********************************************************************************************************************
 
    
// ********************************************************************************************************************    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.Box.Filler filler1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButtonHomeIconsGround5;
    private javax.swing.JButton jButtonHomeIconsGround6;
    private javax.swing.JButton jButtonHomeIconsGround7;
    private javax.swing.JButton jButtonHomeIconsGround8;
    private javax.swing.JButton jButtonHomeIconsGround9;
    private javax.swing.JButton jButtonSearch;
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
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel2UserMail;
    private javax.swing.JLabel jLabel2UserMail1;
    private javax.swing.JLabel jLabel2UserPass;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabelHomeIcon4;
    private javax.swing.JLabel jLabelMailUser;
    private javax.swing.JLabel jLabelTimeline7;
    private javax.swing.JLabel jLabelTimeline8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanelUsersFound;
    private javax.swing.JPasswordField jPasswordUserPass;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JTextField jTextFieldSearchUser;
    private javax.swing.JTextField jTextFieldUserMail;
    // End of variables declaration//GEN-END:variables
}
// ********************************************************************************************************************