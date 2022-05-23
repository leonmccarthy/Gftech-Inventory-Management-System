/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gftech_sales;

import java.awt.Image;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Vector;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.DateFormatter;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author leon
 */
public class GFTECH_order_form extends javax.swing.JFrame {

    /**
     * Creates new form GFTECH_order_form
     */
    public GFTECH_order_form() {
        initComponents();
        scaleImage();
        loadcustomer();
        loadproduct();
        getToday();
        updateCombo();
        this.setLocationRelativeTo(null);
        setIcon();
        this.setTitle("GFTECH_System");
    }
    private void setIcon() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/images/GFTECH logo.jpg")));
    }
 
    public void scaleImage(){
        ImageIcon icon = new ImageIcon(getClass().getResource("/images/GFTECH logo.jpg"));
        Image img = icon.getImage();
        Image imgscale = img.getScaledInstance(jLabel_gftech_logo.getWidth(), jLabel_gftech_logo.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon fullscale = new ImageIcon(imgscale);
        jLabel_gftech_logo.setIcon(fullscale);
    }
    public void getToday(){
        String curr = "dd/MM/yyyy   HH:mm";
        DateTimeFormatter dft = DateTimeFormatter.ofPattern(curr);
        LocalDateTime now = LocalDateTime.now();
        jLabel_order_date_show.setText(dft.format(now));
    }
    
     public void loadcustomer(){
        try {
            Connection con = DriverManager.getConnection("jdbc:sqlite:gftech_db.db");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from gftech_customer");
            jTable_customers.setModel(DbUtils.resultSetToTableModel(rs));
            stmt.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
      public void loadproduct(){
        try {
            Connection con = DriverManager.getConnection("jdbc:sqlite:gftech_db.db");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from gftech_product");
            jTable_products.setModel(DbUtils.resultSetToTableModel(rs));
            stmt.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
       public void loadorder(){
        try {
            Connection con = DriverManager.getConnection("jdbc:sqlite:gftech_db.db");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from gftech_order");
            jTable_customers.setModel(DbUtils.resultSetToTableModel(rs));
            stmt.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
       private void update(){
           int newqty = oldqty - Integer.valueOf(jTextField_order_quantity.getText());
           try {
            Class.forName("org.sqlite.JDBC");
            Connection con = DriverManager.getConnection("jdbc:sqlite:gftech_db.db");
            Statement stmt = con.createStatement();
            String query = "update gftech_product set Quantity = '"+newqty+"' where ID ='"+productid+"'";
            stmt.executeUpdate(query);
            ResultSet rs = stmt.executeQuery("select * from gftech_product");
            jTable_products.setModel(DbUtils.resultSetToTableModel(rs));
            stmt.close();
            con.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error!!! "+ex);
        }

       }
       public void updateCombo(){
//        Connection con=null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        String query = "select * from gftech_user";
        try {
        Connection con = DriverManager.getConnection("jdbc:sqlite:gftech_db.db");
        pst = con.prepareStatement(query);
        rs = pst.executeQuery();
        while(rs.next()){
            jComboBox.addItem(rs.getString("Name"));
        }
        pst.close();
        con.close();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Error!!!"+ e);
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

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel_title = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel_gftech_logo = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel_customer_name = new javax.swing.JLabel();
        jButton_insert_order = new javax.swing.JButton();
        jLabel_order_date = new javax.swing.JLabel();
        jButton_home = new javax.swing.JButton();
        jButton_view_order = new javax.swing.JButton();
        jLabel_order_date_show = new javax.swing.JLabel();
        jLabel_order_name_show = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_customers = new javax.swing.JTable();
        jLabel_customerlist = new javax.swing.JLabel();
        jTextField_order_id = new javax.swing.JTextField();
        jLabel_order_id = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable_products = new javax.swing.JTable();
        jLabel_productlist = new javax.swing.JLabel();
        jTextField_order_price = new javax.swing.JTextField();
        jLabel_order_price = new javax.swing.JLabel();
        jTextField_order_quantity = new javax.swing.JTextField();
        jLabel_order_quantity = new javax.swing.JLabel();
        jButton_add_toorder = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable_order = new javax.swing.JTable();
        jButton_print = new javax.swing.JButton();
        jLabel_order_price1 = new javax.swing.JLabel();
        jLabel_order_total_show = new javax.swing.JLabel();
        jLabel_sold_by = new javax.swing.JLabel();
        jComboBox = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(175, 175, 175));

        jPanel2.setBackground(new java.awt.Color(254, 0, 0));
        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel2.setForeground(new java.awt.Color(255, 255, 255));

        jLabel_title.setFont(new java.awt.Font("Tahoma", 1, 28)); // NOI18N
        jLabel_title.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_title.setText("GFTECH INVESMENTS ORDER MANAGEMENT SYSTEM");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel_gftech_logo, javax.swing.GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel_gftech_logo, javax.swing.GroupLayout.DEFAULT_SIZE, 68, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel_title, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(406, 406, 406)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addComponent(jLabel_title, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPanel3.setOpaque(false);

        jLabel_customer_name.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel_customer_name.setForeground(new java.awt.Color(254, 0, 0));
        jLabel_customer_name.setText("Name:");

        jButton_insert_order.setBackground(new java.awt.Color(254, 0, 0));
        jButton_insert_order.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton_insert_order.setForeground(new java.awt.Color(255, 255, 255));
        jButton_insert_order.setText("ADD ORDER");
        jButton_insert_order.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton_insert_order.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_insert_orderActionPerformed(evt);
            }
        });

        jLabel_order_date.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel_order_date.setForeground(new java.awt.Color(254, 0, 0));
        jLabel_order_date.setText("Date:");

        jButton_home.setBackground(new java.awt.Color(254, 0, 0));
        jButton_home.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton_home.setForeground(new java.awt.Color(255, 255, 255));
        jButton_home.setText("HOME");
        jButton_home.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton_home.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_homeActionPerformed(evt);
            }
        });

        jButton_view_order.setBackground(new java.awt.Color(254, 0, 0));
        jButton_view_order.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton_view_order.setForeground(new java.awt.Color(255, 255, 255));
        jButton_view_order.setText("VIEW ORDERS");
        jButton_view_order.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton_view_order.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_view_orderActionPerformed(evt);
            }
        });

        jLabel_order_date_show.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel_order_date_show.setForeground(new java.awt.Color(0, 0, 0));

        jLabel_order_name_show.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel_order_name_show.setForeground(new java.awt.Color(0, 0, 0));
        jLabel_order_name_show.setText("Customer name");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel_order_date)
                            .addComponent(jLabel_customer_name))
                        .addGap(79, 79, 79)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel_order_name_show, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel_order_date_show, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(205, 205, 205)
                        .addComponent(jButton_view_order))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jButton_insert_order)))
                .addGap(84, 84, 84))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(137, 137, 137)
                .addComponent(jButton_home)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_order_name_show, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel_customer_name, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel_order_date_show, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel_order_date, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton_view_order, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_insert_order, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton_home, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10))
        );

        jTable_customers.setBackground(new java.awt.Color(175, 175, 175));
        jTable_customers.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTable_customers.setFont(new java.awt.Font("Dubai", 1, 15)); // NOI18N
        jTable_customers.setForeground(new java.awt.Color(0, 0, 0));
        jTable_customers.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Name", "Phone"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTable_customers.setRowHeight(20);
        jTable_customers.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable_customersMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable_customers);

        jLabel_customerlist.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel_customerlist.setForeground(new java.awt.Color(254, 0, 0));
        jLabel_customerlist.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_customerlist.setText("Customer list");

        jTextField_order_id.setFont(new java.awt.Font("Dubai", 0, 15)); // NOI18N

        jLabel_order_id.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel_order_id.setForeground(new java.awt.Color(254, 0, 0));
        jLabel_order_id.setText("ORDER ID:");

        jTable_products.setBackground(new java.awt.Color(175, 175, 175));
        jTable_products.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTable_products.setFont(new java.awt.Font("Dubai", 1, 15)); // NOI18N
        jTable_products.setForeground(new java.awt.Color(0, 0, 0));
        jTable_products.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Name", "Price", "Quantity", "Category"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTable_products.setRowHeight(20);
        jTable_products.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable_productsMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable_products);

        jLabel_productlist.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel_productlist.setForeground(new java.awt.Color(254, 0, 0));
        jLabel_productlist.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_productlist.setText("Product list");

        jTextField_order_price.setFont(new java.awt.Font("Dubai", 0, 15)); // NOI18N

        jLabel_order_price.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel_order_price.setForeground(new java.awt.Color(254, 0, 0));
        jLabel_order_price.setText("PRICE:");

        jTextField_order_quantity.setFont(new java.awt.Font("Dubai", 0, 15)); // NOI18N

        jLabel_order_quantity.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel_order_quantity.setForeground(new java.awt.Color(254, 0, 0));
        jLabel_order_quantity.setText("QUANTITY");

        jButton_add_toorder.setBackground(new java.awt.Color(254, 0, 0));
        jButton_add_toorder.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton_add_toorder.setForeground(new java.awt.Color(255, 255, 255));
        jButton_add_toorder.setText("ADD TO ORDER");
        jButton_add_toorder.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton_add_toorder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_add_toorderActionPerformed(evt);
            }
        });

        jTable_order.setFont(new java.awt.Font("Dubai", 1, 15)); // NOI18N
        jTable_order.setForeground(new java.awt.Color(0, 0, 0));
        jTable_order.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "No", "Product", "Price", "Quantity", "Total"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane3.setViewportView(jTable_order);

        jButton_print.setBackground(new java.awt.Color(254, 0, 0));
        jButton_print.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton_print.setForeground(new java.awt.Color(255, 255, 255));
        jButton_print.setText("PRINT");
        jButton_print.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton_print.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_printActionPerformed(evt);
            }
        });

        jLabel_order_price1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel_order_price1.setForeground(new java.awt.Color(254, 0, 0));
        jLabel_order_price1.setText("Sh.");

        jLabel_order_total_show.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel_order_total_show.setForeground(new java.awt.Color(0, 0, 0));
        jLabel_order_total_show.setText("Amount");

        jLabel_sold_by.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel_sold_by.setForeground(new java.awt.Color(254, 0, 0));
        jLabel_sold_by.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel_sold_by.setText("Sold by: ");

        jComboBox.setBackground(new java.awt.Color(254, 0, 0));
        jComboBox.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jComboBox.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel_customerlist, javax.swing.GroupLayout.PREFERRED_SIZE, 395, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 383, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(34, 34, 34)
                                .addComponent(jLabel_productlist, javax.swing.GroupLayout.PREFERRED_SIZE, 441, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 18, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel_sold_by)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 441, Short.MAX_VALUE)
                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                                .addContainerGap())))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jLabel_order_id)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextField_order_id, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel_order_price)
                        .addGap(37, 37, 37)
                        .addComponent(jTextField_order_price, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(66, 66, 66)
                        .addComponent(jLabel_order_quantity)
                        .addGap(35, 35, 35)
                        .addComponent(jTextField_order_quantity, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(54, 54, 54)
                        .addComponent(jButton_add_toorder)
                        .addGap(36, 36, 36))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 387, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(119, 119, 119)
                        .addComponent(jComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel_order_price1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel_order_total_show, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton_print)
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_customerlist, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel_productlist))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 232, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_order_id, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_order_id, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_add_toorder, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_order_quantity, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel_order_quantity, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_order_price, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel_order_price, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel_order_price1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton_print, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel_order_total_show, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel_sold_by, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_insert_orderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_insert_orderActionPerformed
        if(jTextField_order_id.getText().isEmpty()||jLabel_order_name_show.getText().isEmpty()||
                jLabel_order_date_show.getText().isEmpty()||jLabel_order_total_show.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Missing Information!!!");
        }else{
        try {
            Class.forName("org.sqlite.JDBC");
            Connection con = DriverManager.getConnection("jdbc:sqlite:gftech_db.db");
            Statement stmt = con.createStatement();
            String query = "insert into gftech_order (OrderID, CustName, OrderDate,  Amount, Soldby) values ('"+Integer.valueOf(jTextField_order_id.getText())+"', "
                    + "'"+jLabel_order_name_show.getText()+"', '"+jLabel_order_date_show.getText()+"', '"+Integer.valueOf(jLabel_order_total_show.getText())+"','"+jComboBox.getSelectedItem().toString()+"')";
            stmt.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Order Successfully inserted!!!");
            stmt.close();
            con.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error!!! "+ex);
        }
        }
    }//GEN-LAST:event_jButton_insert_orderActionPerformed

    private void jButton_homeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_homeActionPerformed
        GFTECH_Dashboard ds = new GFTECH_Dashboard();
        ds.setVisible(true);
        ds.pack();
        ds.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_jButton_homeActionPerformed

    int i = 1, productprice,producttotal,overalltotal;
String productname;
    private void jButton_add_toorderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_add_toorderActionPerformed
        if(flag==0||jTextField_order_quantity.getText().isEmpty()||jTextField_order_price.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Select Product and Enter quantity!!!");
        }else{
        productprice = Integer.valueOf(jTextField_order_price.getText());
        producttotal = Integer.valueOf(jTextField_order_quantity.getText()) * productprice;
        Vector v = new Vector();
        v.add(i);
        v.add(productname);
        v.add(jTextField_order_quantity.getText());
        v.add(productprice);
        v.add(producttotal);
        
        DefaultTableModel ord = (DefaultTableModel)jTable_order.getModel();
        ord.addRow(v);
        overalltotal = overalltotal +producttotal;
        jLabel_order_total_show.setText(String.valueOf(overalltotal));
        update();
        i++;
        }
    }//GEN-LAST:event_jButton_add_toorderActionPerformed

    private void jButton_printActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_printActionPerformed
        try{
            jTable_order.print();
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }//GEN-LAST:event_jButton_printActionPerformed

    private void jButton_view_orderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_view_orderActionPerformed
       GFTECH_order_admin oa = new GFTECH_order_admin();
       oa.setVisible(true);
       oa.pack();
       oa.setLocationRelativeTo(null);
       this.dispose();
    }//GEN-LAST:event_jButton_view_orderActionPerformed

    private void jTable_customersMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable_customersMouseClicked
        DefaultTableModel model = (DefaultTableModel)jTable_customers.getModel();
        int index = jTable_customers.getSelectedRow();
        jLabel_order_name_show.setText(model.getValueAt(index, 1).toString());
//        jTextField_customer_phoneno.setText(model.getValueAt(index, 2).toString());
    }//GEN-LAST:event_jTable_customersMouseClicked
int flag = 0,productid,oldqty;
    private void jTable_productsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable_productsMouseClicked
        DefaultTableModel model = (DefaultTableModel)jTable_products.getModel();
        int index = jTable_products.getSelectedRow();
        jTextField_order_id.setText(model.getValueAt(index, 0).toString());
        productid = Integer.valueOf(model.getValueAt(index, 0).toString());
        productname = model.getValueAt(index, 1).toString();
        oldqty = Integer.valueOf(model.getValueAt(index, 4).toString());
        jTextField_order_price.setText(model.getValueAt(index, 2).toString());
        flag = 1;
    }//GEN-LAST:event_jTable_productsMouseClicked

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
            java.util.logging.Logger.getLogger(GFTECH_order_form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GFTECH_order_form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GFTECH_order_form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GFTECH_order_form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GFTECH_order_form().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_add_toorder;
    private javax.swing.JButton jButton_home;
    private javax.swing.JButton jButton_insert_order;
    private javax.swing.JButton jButton_print;
    private javax.swing.JButton jButton_view_order;
    private javax.swing.JComboBox<String> jComboBox;
    private javax.swing.JLabel jLabel_customer_name;
    private javax.swing.JLabel jLabel_customerlist;
    private javax.swing.JLabel jLabel_gftech_logo;
    private javax.swing.JLabel jLabel_order_date;
    private javax.swing.JLabel jLabel_order_date_show;
    private javax.swing.JLabel jLabel_order_id;
    private javax.swing.JLabel jLabel_order_name_show;
    private javax.swing.JLabel jLabel_order_price;
    private javax.swing.JLabel jLabel_order_price1;
    private javax.swing.JLabel jLabel_order_quantity;
    private javax.swing.JLabel jLabel_order_total_show;
    private javax.swing.JLabel jLabel_productlist;
    private javax.swing.JLabel jLabel_sold_by;
    private javax.swing.JLabel jLabel_title;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable_customers;
    private javax.swing.JTable jTable_order;
    private javax.swing.JTable jTable_products;
    private javax.swing.JTextField jTextField_order_id;
    private javax.swing.JTextField jTextField_order_price;
    private javax.swing.JTextField jTextField_order_quantity;
    // End of variables declaration//GEN-END:variables
}
