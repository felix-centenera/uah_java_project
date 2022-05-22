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
import com.allsafe.service.InventoryServices;
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
import javax.swing.ListModel;

/**
 *
 * @author felixcentenera
 */

public class WindowsAdminProductMngtSearch extends javax.swing.JFrame  {

    private WindowsAdminProductMngt principal;
    private WindowsProduct secundariaProductos;
    private  Producto producto;
    private Usuario user;
    private Producto productMgmt;
    //private int opinion=0;
    private int numberOfUserPages=0;
    Login miservicioDeLogin = Login.getInstance();
    // just for mock delete after test:
    UserData userData = UserData.getInstance();
    
    
    ArrayList<Producto> listOfProductos;
    
    /**
     * Creates new form Home
     */
//    public WindowsProduct() {
//        initComponents();
//        createHomePageProductos();
//        createHomePage();
//    }
    
    
    
     public  void  SetlistOfProductos(ArrayList<Producto> listOfProductos) {
        this.listOfProductos = listOfProductos;
        
 }
 
//  public  Usuario  GetUsuario() {
//        return  user;  
// }
    
    /** Creates new form WindowProduct */
    public WindowsAdminProductMngtSearch(WindowsAdminProductMngt ventana) {
        //Ocultamos la ventana principal
        principal = ventana;
        principal.setVisible(false);
        //user = u;
        //this.producto =producto;
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
            jLabelProductSelected.setVisible(false);
        
            
            
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
           
                //ArrayList<String> listOfKeys  = UsersServices.getUser();
                //int sizeUserData=listOfKeys.size();
                //listOfProductos
                
                
                int sizeProductData=listOfProductos.size();
                
                
                
                
                System.out.println(numberOfUserPages);
                numberOfUserPages = numberOfUserPages +i;
                System.out.println(numberOfUserPages);
                jPanelUsersFound.setVisible(true);
                switch (sizeProductData) {
                case 1 : 
                    try {
                        System.out.println("caso1");
                    jButtonUser1.setVisible(true);
                   // jButtonUser1.setText(listOfKeys.get(numberOfUserPages));
                    jButtonUser1.setText(listOfProductos.get(numberOfUserPages).getTitulo());
                    }
                    catch (Exception e) {
                        System.out.println("Error: No hay mas productos que mostrar " + e.toString()); 
                        SetNumberOfUserPages0();
                        System.out.println("Voy a poner los productos a 0");
                        printUsers(0);
                        
                        //createWindowsProductPage();
                    }
                    break;
                case 2 :
                    try {
                        System.out.println("caso2");
                    jButtonUser1.setVisible(true);
                    jButtonUser1.setText(listOfProductos.get(numberOfUserPages).getTitulo());
                    jButtonUser2.setVisible(true);
                    jButtonUser2.setText(listOfProductos.get(numberOfUserPages + 1).getTitulo());
                    }
                    catch (Exception e) {
                        System.out.println("Error: No hay mas producto que mostrar " + e.toString()); 
                        System.out.println("Voy a poner los producto a 0");
                        SetNumberOfUserPages0();
                        printUsers(0);
                        //createWindowsProductPage();
                    }
                    
                    break;
                case 3:
                    try {
                        System.out.println("caso3");
                    jButtonUser1.setVisible(true);
                    jButtonUser1.setText(listOfProductos.get(numberOfUserPages).getTitulo());
                    jButtonUser2.setVisible(true);
                    jButtonUser2.setText(listOfProductos.get(numberOfUserPages + 1 ).getTitulo());
                    jButtonUser3.setVisible(true);
                    jButtonUser3.setText(listOfProductos.get(numberOfUserPages + 2 ).getTitulo());
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
                    jButtonUser1.setText(listOfProductos.get(numberOfUserPages).getTitulo());
                    jButtonUser2.setVisible(true);
                    jButtonUser2.setText(listOfProductos.get(numberOfUserPages +1 ).getTitulo());
                    jButtonUser3.setVisible(true);
                    jButtonUser3.setText(listOfProductos.get(numberOfUserPages + 2).getTitulo());
                    jButtonUser4.setVisible(true);
                    jButtonUser4.setText(listOfProductos.get(numberOfUserPages + 3).getTitulo());
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
                    jButtonUser1.setText(listOfProductos.get(numberOfUserPages).getTitulo());
                    jButtonUser2.setVisible(true);
                    jButtonUser2.setText(listOfProductos.get(numberOfUserPages + 1).getTitulo());
                    jButtonUser3.setVisible(true);
                    jButtonUser3.setText(listOfProductos.get(numberOfUserPages + 2).getTitulo());
                    jButtonUser4.setVisible(true);
                    jButtonUser4.setText(listOfProductos.get(numberOfUserPages + 3 ).getTitulo());
                    jButtonUser5.setVisible(true);
                    jButtonUser5.setText(listOfProductos.get(numberOfUserPages + 4 ).getTitulo());
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
                    jButtonUser1.setText(listOfProductos.get(numberOfUserPages).getTitulo());
                    jButtonUser2.setVisible(true);
                    jButtonUser2.setText(listOfProductos.get(numberOfUserPages + 1).getTitulo());
                    jButtonUser3.setVisible(true);
                    jButtonUser3.setText(listOfProductos.get(numberOfUserPages + 2 ).getTitulo()); 
                    jButtonUser4.setVisible(true);
                    jButtonUser4.setText(listOfProductos.get(numberOfUserPages + 3 ).getTitulo());
                    jButtonUser5.setVisible(true);
                    jButtonUser5.setText(listOfProductos.get(numberOfUserPages + 4 ).getTitulo());
                    jButtonUser6.setVisible(true);
                    jButtonUser6.setText(listOfProductos.get(numberOfUserPages + 5 ).getTitulo());
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
                    jButtonUser1.setText(listOfProductos.get(numberOfUserPages).getTitulo());
                    jButtonUser2.setVisible(true);
                    jButtonUser2.setText(listOfProductos.get(numberOfUserPages + 1 ).getTitulo());
                    jButtonUser3.setVisible(true);
                    jButtonUser3.setText(listOfProductos.get(numberOfUserPages + 2).getTitulo()); 
                    jButtonUser4.setVisible(true);
                    jButtonUser4.setText(listOfProductos.get(numberOfUserPages + 3).getTitulo());
                    jButtonUser5.setVisible(true);
                    jButtonUser5.setText(listOfProductos.get(numberOfUserPages + 4 ).getTitulo());
                    jButtonUser6.setVisible(true);
                    jButtonUser6.setText(listOfProductos.get(numberOfUserPages + 5 ).getTitulo());
                    jButtonUser7.setVisible(true);
                    jButtonUser7.setText(listOfProductos.get(numberOfUserPages + 6).getTitulo());
                    }
                    catch (Exception e) {
                        System.out.println("Error: No hay mas usuarios que mostrar " + e.toString()); 
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
                            System.out.println(numberOfUserPages);
                    jButtonUser1.setVisible(true);
                    jButtonUser1.setText(listOfProductos.get(numberOfUserPages).getTitulo());
                    jButtonUser2.setVisible(true);
                    jButtonUser2.setText(listOfProductos.get(numberOfUserPages + 1 ).getTitulo());
                    jButtonUser3.setVisible(true);
                    jButtonUser3.setText(listOfProductos.get(numberOfUserPages + 2).getTitulo()); 
                    jButtonUser4.setVisible(true);
                    jButtonUser4.setText(listOfProductos.get(numberOfUserPages + 3).getTitulo());
                    jButtonUser5.setVisible(true);
                    jButtonUser5.setText(listOfProductos.get(numberOfUserPages + 4 ).getTitulo());
                    jButtonUser6.setVisible(true);
                    jButtonUser6.setText(listOfProductos.get(numberOfUserPages + 5 ).getTitulo());
                    jButtonUser7.setVisible(true);
                    jButtonUser7.setText(listOfProductos.get(numberOfUserPages + 6).getTitulo());
                    jButtonUser8.setVisible(true);
                    jButtonUser8.setText(listOfProductos.get(numberOfUserPages + 7).getTitulo());
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
        jSeparator4 = new javax.swing.JSeparator();
        jPanel8 = new javax.swing.JPanel();
        jLabel2UserMail1 = new javax.swing.JLabel();
        jButtonSearch = new javax.swing.JButton();
        jButtonUserDelete = new javax.swing.JButton();
        jButtonUserInfo = new javax.swing.JButton();
        jLabelProduct = new javax.swing.JLabel();
        jTextFieldSearchUser = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        jComboBox1 = new javax.swing.JComboBox<>();
        jComboBoxCategoria = new javax.swing.JComboBox<>();
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
        jLabelProductSelected = new javax.swing.JLabel();
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

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));
        jPanel8.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        jLabel2UserMail1.setText("Titulo producto");

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

        jLabelProduct.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        jLabelProduct.setText("producto");

        jTextFieldSearchUser.setForeground(new java.awt.Color(204, 204, 204));
        jTextFieldSearchUser.setText("Ingrese el titulo del producto");
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

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "relevancia", "precio mayor", "precio menor" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jComboBoxCategoria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Componentes", "Ordenadores", "Móviles y telefonía", "TV, audio y foto", "Consolas y videojuegos" }));
        jComboBoxCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxCategoriaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addComponent(jLabel2UserMail1)
                                .addGap(35, 35, 35)
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextFieldSearchUser, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButtonUserDelete)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonUserInfo)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jComboBoxCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(23, 23, 23)
                        .addComponent(jButtonSearch)))
                .addContainerGap(148, Short.MAX_VALUE))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabelProduct)
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonUserDelete)
                    .addComponent(jButtonUserInfo)
                    .addComponent(jButtonSearch)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBoxCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(13, Short.MAX_VALUE))
        );

        jLabel3.setText("Buscar Producto");

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

        jLabelProductSelected.setIcon(new javax.swing.ImageIcon("/Users/felixcentenera/Documents/Learning/GISI/2ºCuatrimestre/Programación/uah_java_project/uahproject/Img/laptops/dell/dellXps13.png")); // NOI18N

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(391, 391, 391))
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel7Layout.createSequentialGroup()
                            .addGap(562, 562, 562)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                            .addGap(24, 24, 24)
                            .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(215, 215, 215)
                        .addComponent(jLabelProductSelected, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 133, Short.MAX_VALUE)
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                        .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(jLabelProductSelected, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(75, 75, 75))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jPanelUsersFound, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(56, 56, 56))))
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

    private void jButtonSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSearchActionPerformed
        // TODO add your handling code here:
        jLabelProductSelected.setVisible(false);
        //jTextFieldSearchUser.getText(); ||  (jTextFieldSearchUser.getText().contains(""))
        // InventoryServices.orderByStarts();
        
        
        //System.out.println(InventoryServices.orderByStarts().get(0) + "que voy");
        
//        System.out.println(InventoryServices.orderByStarts());
//        System.out.println(InventoryServices.orderByPrice());   jComboBoxCategoria
//        
        //
        
        if (jTextFieldSearchUser.getText().contains("Ingrese el titulo del producto")) {
            
            try {
                jLabelProduct.setText("Producto");
                if (jComboBox1.getSelectedItem().equals("relevancia")) {
                    //System.out.println(InventoryServices.orderByStarts());
                    listOfProductos= InventoryServices.orderByStarts((String) jComboBoxCategoria.getSelectedItem());
           
                    if(!listOfProductos.isEmpty() ) {
                            SetNumberOfUserPages0();
                            printUsers(0);
                    }  
                    else {
                        System.out.println("No han encontrado resultados");
                        jPanelUsersFound.setVisible(false);
                    } 
                }   

                else if (jComboBox1.getSelectedItem().equals("precio mayor")) {
                    //System.out.println(InventoryServices.orderByHighPrice());
                    listOfProductos= InventoryServices.orderByHighPrice( (String) jComboBoxCategoria.getSelectedItem()  );
                    if(!listOfProductos.isEmpty() ) {
                            SetNumberOfUserPages0();
                            printUsers(0);
                    }  
                    else {
                        System.out.println("No han encontrado resultados");
                        jPanelUsersFound.setVisible(false);
                    }
                }  

                else if (jComboBox1.getSelectedItem().equals("precio menor")) {
                    //System.out.println(InventoryServices.orderByLowtPrice());
                    listOfProductos=InventoryServices.orderByLowtPrice((String) jComboBoxCategoria.getSelectedItem());                    
                    if(!listOfProductos.isEmpty() ) {
                            SetNumberOfUserPages0();
                            printUsers(0);
                    }  
                    else {
                        System.out.println("No han encontrado resultados");
                        jPanelUsersFound.setVisible(false);
                    }
                }  
                
            }
            catch (Exception e){
                System.out.println("Error: El producto no existe: " + e.toString()); 
                jPanelUsersFound.setVisible(false);
             }
        }
        
        else {
            
            try {
                jLabelProduct.setText("Producto");
                if (jComboBox1.getSelectedItem().equals("relevancia")) {
                    //System.out.println(InventoryServices.orderByStarts());
                    listOfProductos= InventoryServices.orderByStarts(jTextFieldSearchUser.getText(), (String) jComboBoxCategoria.getSelectedItem());
           
                    if(!listOfProductos.isEmpty() ) {
                            SetNumberOfUserPages0();
                            printUsers(0);
                    }  
                    else {
                        System.out.println("No han encontrado resultados");
                        jPanelUsersFound.setVisible(false);
                    } 
                }   

                else if (jComboBox1.getSelectedItem().equals("precio mayor")) {
                    //System.out.println(InventoryServices.orderByHighPrice());
                    listOfProductos= InventoryServices.orderByHighPrice(jTextFieldSearchUser.getText(), (String) jComboBoxCategoria.getSelectedItem()  );
                    if(!listOfProductos.isEmpty() ) {
                            SetNumberOfUserPages0();
                            printUsers(0);
                    }  
                    else {
                        System.out.println("No han encontrado resultados");
                        jPanelUsersFound.setVisible(false);
                    }
                    
                    
                }  

                else if (jComboBox1.getSelectedItem().equals("precio menor")) {
                    //System.out.println(InventoryServices.orderByLowtPrice());
                    listOfProductos=InventoryServices.orderByLowtPrice(jTextFieldSearchUser.getText(),(String) jComboBoxCategoria.getSelectedItem());  
                    if(!listOfProductos.isEmpty() ) {
                            SetNumberOfUserPages0();
                            printUsers(0);
                    }  
                    else {
                        System.out.println("No han encontrado resultados");
                        jPanelUsersFound.setVisible(false);
                    }
                }  
                
            }
            catch (Exception e){
                System.out.println("Error: El producto no existe: " + e.toString());
                jPanelUsersFound.setVisible(false);
             }
        
        
        
        
        }        
//        if (jTextFieldSearchUser.getText().contains("Ingrese su nombre de usuario")  ){
//            try {
//             //if null 
//             jLabelMailUser.setText("mail");
//             SetNumberOfUserPages0();
//             printUsers(0);
//               
//            }
//            catch (Exception e){
//                System.out.println("Error: No se ha podido realizar la accion: " + e.toString()); 
//
//            }
//        }
//        else {
//         try {
//            jPanelUsersFound.setVisible(false); 
//            productMgmt =  UsersServices.getUser(jTextFieldSearchUser.getText());
//            jTextFieldSearchUser.setText("Ingrese su nombre de usuario");
//            jLabelMailUser.setText(productMgmt.getCorreo());
//            }
//            catch (Exception e){
//                System.out.println("Error: El usuario no existe: " + e.toString()); 
//            }
//        }     
    }//GEN-LAST:event_jButtonSearchActionPerformed

    private void jButtonUserInfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonUserInfoActionPerformed
        // TODO add your handling code here:
          if (jLabelProduct.getText() != "Producto"){
              WindowsProductManagingInfo windowsroductmanagingnnfo = new WindowsProductManagingInfo(this , productMgmt);
             // System.out.println("este es el producto que voy a pasar" + productMgmt);
              
         }
        else {
            System.out.println("INFO: No se ha seleeccionado ningún producto");
        }
        jLabelProduct.setText("Producto");
        jPanelUsersFound.setVisible(false);
       
        
//        if (jLabelMailUser.getText() != "mail"){
//            if(!productMgmt.isAdministrador()){
//                WindowsMyAccount windowsMyAccount = new WindowsMyAccount(this , productMgmt);
//                jLabelMailUser.setText("mail");
//            }
//            else {
//                WindowsMyAccountAdmin windowsMyAccountAdmin = new WindowsMyAccountAdmin(this , productMgmt);
//                jLabelMailUser.setText("mail");
//            }
//        }
//        else {
//            System.out.println("INFO: No se ha seleeccionado ningún usuario");
//        }
    }//GEN-LAST:event_jButtonUserInfoActionPerformed

    private void jButtonUser1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonUser1ActionPerformed
        // TODO add your handling code here:
        // jButtonUser1.setText(listOfProductos.get(numberOfUserPages).getTitulo());
        
        productMgmt = InventoryServices.getProducto(jButtonUser1.getText());
        jLabelProduct.setText(productMgmt.getTitulo());
        jLabelProductSelected.setVisible(true);
        jLabelProductSelected.setIcon(new javax.swing.ImageIcon(productMgmt.getFotografia()));
        
    }//GEN-LAST:event_jButtonUser1ActionPerformed

    private void jButtonUser2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonUser2ActionPerformed
        // TODO add your handling code here:
//        productMgmt =  UsersServices.getUser(jButtonUser2.getText());
//        jLabelProduct.setText(productMgmt.getCorreo());
        
        
        productMgmt = InventoryServices.getProducto(jButtonUser2.getText());
        jLabelProduct.setText(productMgmt.getTitulo());
        jLabelProductSelected.setVisible(true);
        jLabelProductSelected.setIcon(new javax.swing.ImageIcon(productMgmt.getFotografia()));
        
        
        
        
    }//GEN-LAST:event_jButtonUser2ActionPerformed

    private void jButtonUser3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonUser3ActionPerformed
        // TODO add your handling code here:
//        productMgmt =  UsersServices.getUser(jButtonUser3.getText());
//        jLabelProduct.setText(productMgmt.getCorreo());

        productMgmt = InventoryServices.getProducto(jButtonUser3.getText());
        jLabelProduct.setText(productMgmt.getTitulo());
        jLabelProductSelected.setVisible(true);
        jLabelProductSelected.setIcon(new javax.swing.ImageIcon(productMgmt.getFotografia()));
    }//GEN-LAST:event_jButtonUser3ActionPerformed

    private void jButtonUser4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonUser4ActionPerformed
        // TODO add your handling code here:
//        productMgmt =  UsersServices.getUser(jButtonUser4.getText());
//        jLabelProduct.setText(productMgmt.getCorreo());
//        
        
        productMgmt = InventoryServices.getProducto(jButtonUser4.getText());
        jLabelProduct.setText(productMgmt.getTitulo());
        jLabelProductSelected.setVisible(true);
        jLabelProductSelected.setIcon(new javax.swing.ImageIcon(productMgmt.getFotografia()));
        
    }//GEN-LAST:event_jButtonUser4ActionPerformed

    private void jButtonUser5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonUser5ActionPerformed
        // TODO add your handling code here:
         productMgmt = InventoryServices.getProducto(jButtonUser5.getText());
        jLabelProduct.setText(productMgmt.getTitulo());
        jLabelProductSelected.setVisible(true);
        jLabelProductSelected.setIcon(new javax.swing.ImageIcon(productMgmt.getFotografia()));
    }//GEN-LAST:event_jButtonUser5ActionPerformed

    private void jButtonUser6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonUser6ActionPerformed
        // TODO add your handling code here:
         productMgmt = InventoryServices.getProducto(jButtonUser6.getText());
        jLabelProduct.setText(productMgmt.getTitulo());
        jLabelProductSelected.setVisible(true);
        jLabelProductSelected.setIcon(new javax.swing.ImageIcon(productMgmt.getFotografia()));
    }//GEN-LAST:event_jButtonUser6ActionPerformed

    private void jButtonUser7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonUser7ActionPerformed
        // TODO add your handling code here:
         productMgmt = InventoryServices.getProducto(jButtonUser7.getText());
        jLabelProduct.setText(productMgmt.getTitulo());
        jLabelProductSelected.setVisible(true);
        jLabelProductSelected.setIcon(new javax.swing.ImageIcon(productMgmt.getFotografia()));
    }//GEN-LAST:event_jButtonUser7ActionPerformed

    private void jButtonUser8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonUser8ActionPerformed
        // TODO add your handling code here:
         productMgmt = InventoryServices.getProducto(jButtonUser8.getText());
        jLabelProduct.setText(productMgmt.getTitulo());
        jLabelProductSelected.setVisible(true);
        jLabelProductSelected.setIcon(new javax.swing.ImageIcon(productMgmt.getFotografia()));
    }//GEN-LAST:event_jButtonUser8ActionPerformed

    
    
    private void jTextFieldSearchUserMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextFieldSearchUserMousePressed
        // TODO add your handling code here:
        if(jTextFieldSearchUser.getText().equals("Ingrese el situtlo del producto")){
            jTextFieldSearchUser.setText("");
            jTextFieldSearchUser.setForeground(Color.black);
        }
    }//GEN-LAST:event_jTextFieldSearchUserMousePressed

    private void jTextFieldSearchUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldSearchUserActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldSearchUserActionPerformed

    private void jButtonUserDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonUserDeleteActionPerformed
        // TODO add your handling code here:
        
         if (jLabelProduct.getText() != "Producto"){
             if (InventoryServices.deleteProduct(jLabelProduct.getText())) {
                 System.out.println("INFO: El producto se ha eliminado del inventario");
             
             }
             else {
                 System.out.println("El producto no se ha eliminado del inventario");
             }
         }
        else {
            System.out.println("INFO: No se ha seleeccionado ningún producto");
        }
        jLabelProduct.setText("Producto");
        jPanelUsersFound.setVisible(false);
        jLabelProductSelected.setVisible(false);
           
 
        
        
    }//GEN-LAST:event_jButtonUserDeleteActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jComboBoxCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxCategoriaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxCategoriaActionPerformed

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.Box.Filler filler1;
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
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBoxCategoria;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2UserMail1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabelHomeIcon4;
    private javax.swing.JLabel jLabelProduct;
    private javax.swing.JLabel jLabelProductSelected;
    private javax.swing.JLabel jLabelTimeline7;
    private javax.swing.JLabel jLabelTimeline8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanelUsersFound;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JTextField jTextFieldSearchUser;
    // End of variables declaration//GEN-END:variables
}
