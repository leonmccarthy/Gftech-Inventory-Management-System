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
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author leon
 */
public class GFTECH_view_orders extends javax.swing.JFrame {

    /**
     * Creates new form GFTECH_view_orders
     */
    public GFTECH_view_orders() {
        initComponents();
        scaleImage();
        load();
        setIcon();
        updateCombo();
        this.setTitle("GFTECH_System");
        this.setLocationRelativeTo(null);
    }
    private void setIcon() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/images/GFTECH logo.jpg")));
    }
    public void scaleImage(){
        ImageIcon icon = new ImageIcon(getClass().getResource("/images/GFTECH logo.jpg"));
        //Scaling image
        Image img = icon.getImage();
        Image imgscale = img.getScaledInstance(jLabel_gftech_logo.getWidth(), jLabel_gftech_logo.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(imgscale);
        jLabel_gftech_logo.setIcon(scaledIcon);
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
            jComboBox_order_user.addItem(rs.getString("Name"));
        }
        pst.close();
        con.close();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Error!!!"+ e);
        }
    }
    
    public void load(){
        try {
            Connection con = DriverManager.getConnection("jdbc:sqlite:gftech_db.db");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from gftech_order");
            jTable_order.setModel(DbUtils.resultSetToTableModel(rs));
            stmt.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
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
        jLabel_categorylist = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_order = new javax.swing.JTable();
        jButton_back = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel_order_orderid = new javax.swing.JLabel();
        jLabel_order_custname = new javax.swing.JLabel();
        jLabel_order_orderdate = new javax.swing.JLabel();
        jLabel_order_soldby = new javax.swing.JLabel();
        jButton_update = new javax.swing.JButton();
        jButton_delete = new javax.swing.JButton();
        jButton_clear = new javax.swing.JButton();
        jTextField_order_custname = new javax.swing.JTextField();
        jButton_search = new javax.swing.JButton();
        jComboBox_order_user = new javax.swing.JComboBox<>();
        jTextField_order_orderdate = new javax.swing.JTextField();
        jTextField_order_orderid = new javax.swing.JTextField();
        jLabel_order_amount = new javax.swing.JLabel();
        jTextField_order_amount = new javax.swing.JTextField();
        jButton_home = new javax.swing.JButton();

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
            .addComponent(jLabel_title, javax.swing.GroupLayout.DEFAULT_SIZE, 896, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(400, 400, 400)
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

        jLabel_categorylist.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel_categorylist.setForeground(new java.awt.Color(254, 0, 0));
        jLabel_categorylist.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_categorylist.setText("Orders");

        jTable_order.setBackground(new java.awt.Color(175, 175, 175));
        jTable_order.setFont(new java.awt.Font("Dubai", 1, 15)); // NOI18N
        jTable_order.setForeground(new java.awt.Color(0, 0, 0));
        jTable_order.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "OrderID", "CustName", "OrderDate", "Amount", "Sold by"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTable_order.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable_orderMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable_order);

        jButton_back.setBackground(new java.awt.Color(254, 0, 0));
        jButton_back.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton_back.setForeground(new java.awt.Color(255, 255, 255));
        jButton_back.setText("Back");
        jButton_back.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(254, 0, 0), 10, true));
        jButton_back.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton_backMouseClicked(evt);
            }
        });
        jButton_back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_backActionPerformed(evt);
            }
        });

        jPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPanel3.setOpaque(false);

        jLabel_order_orderid.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel_order_orderid.setForeground(new java.awt.Color(254, 0, 0));
        jLabel_order_orderid.setText("OrderID:");

        jLabel_order_custname.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel_order_custname.setForeground(new java.awt.Color(254, 0, 0));
        jLabel_order_custname.setText("CustName:");

        jLabel_order_orderdate.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel_order_orderdate.setForeground(new java.awt.Color(254, 0, 0));
        jLabel_order_orderdate.setText("OrderDate:");

        jLabel_order_soldby.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel_order_soldby.setForeground(new java.awt.Color(254, 0, 0));
        jLabel_order_soldby.setText("Sold by:");

        jButton_update.setBackground(new java.awt.Color(254, 0, 0));
        jButton_update.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton_update.setForeground(new java.awt.Color(255, 255, 255));
        jButton_update.setText("EDIT");
        jButton_update.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton_update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_updateActionPerformed(evt);
            }
        });

        jButton_delete.setBackground(new java.awt.Color(254, 0, 0));
        jButton_delete.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton_delete.setForeground(new java.awt.Color(255, 255, 255));
        jButton_delete.setText("DELETE");
        jButton_delete.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton_delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_deleteActionPerformed(evt);
            }
        });

        jButton_clear.setBackground(new java.awt.Color(254, 0, 0));
        jButton_clear.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton_clear.setForeground(new java.awt.Color(255, 255, 255));
        jButton_clear.setText("CLEAR");
        jButton_clear.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton_clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_clearActionPerformed(evt);
            }
        });

        jTextField_order_custname.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N
        jTextField_order_custname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_order_custnameActionPerformed(evt);
            }
        });

        jButton_search.setBackground(new java.awt.Color(254, 0, 0));
        jButton_search.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton_search.setForeground(new java.awt.Color(255, 255, 255));
        jButton_search.setText("SEARCH");
        jButton_search.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton_search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_searchActionPerformed(evt);
            }
        });

        jComboBox_order_user.setBackground(new java.awt.Color(254, 0, 0));
        jComboBox_order_user.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jComboBox_order_user.setForeground(new java.awt.Color(255, 255, 255));
        jComboBox_order_user.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jTextField_order_orderdate.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N

        jTextField_order_orderid.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N

        jLabel_order_amount.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel_order_amount.setForeground(new java.awt.Color(254, 0, 0));
        jLabel_order_amount.setText("Amount:");

        jTextField_order_amount.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N

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

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel_order_amount)
                    .addComponent(jLabel_order_orderdate)
                    .addComponent(jLabel_order_custname)
                    .addComponent(jLabel_order_orderid)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jButton_update)
                        .addComponent(jLabel_order_soldby)))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addComponent(jComboBox_order_user, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jTextField_order_orderid, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                                    .addComponent(jTextField_order_custname, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextField_order_amount, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextField_order_orderdate, javax.swing.GroupLayout.Alignment.LEADING))
                                .addGap(18, 18, 18)
                                .addComponent(jButton_search)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jButton_home)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jButton_delete)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 60, Short.MAX_VALUE)
                                .addComponent(jButton_clear)
                                .addGap(19, 19, 19))))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_order_orderid, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_order_orderid, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField_order_custname, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel_order_custname, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_search))
                .addGap(33, 33, 33)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField_order_orderdate, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel_order_orderdate, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField_order_amount, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel_order_amount, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(45, 45, 45)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox_order_user, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel_order_soldby, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton_update, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_delete, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_clear, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addComponent(jButton_home, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel_categorylist, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 486, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(409, 409, 409)
                        .addComponent(jButton_back, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel_categorylist, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton_back, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(57, 57, 57))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 900, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 900, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 700, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 700, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_backMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton_backMouseClicked
        //        jTextField_username.setText(null);
        //        jPasswordField.setText(null);
    }//GEN-LAST:event_jButton_backMouseClicked

    private void jButton_backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_backActionPerformed
        GFTECH_order_form od = new GFTECH_order_form();
        od.setVisible(true);
        od.pack();
        od.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_jButton_backActionPerformed

    private void jButton_updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_updateActionPerformed
        if(jTextField_order_orderid.getText().isEmpty()||jTextField_order_custname.getText().isEmpty()||
            jTextField_order_orderdate.getText().isEmpty()||jTextField_order_amount.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Cannot store empty field!!!");
        }else
        try {
            Class.forName("org.sqlite.JDBC");
            Connection con = DriverManager.getConnection("jdbc:sqlite:gftech_db.db");
            Statement stmt = con.createStatement();
            String query = "update gftech_order set CustName = '"+jTextField_order_custname.getText()+"',  OrderDate = '"+jTextField_order_orderdate.getText()+"',"
            + " Soldby = '"+jComboBox_order_user.getSelectedItem().toString()+"', Amount = '"+jTextField_order_amount.getText()+"'"
            + " where OrderID ='"+jTextField_order_orderid.getText()+"'";
            stmt.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Order Successfully updated!!!");
            load();
            stmt.close();
            con.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error!!! "+ex);
        }
    }//GEN-LAST:event_jButton_updateActionPerformed

    private void jButton_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_deleteActionPerformed
        try {
            Class.forName("org.sqlite.JDBC");
            Connection con = DriverManager.getConnection("jdbc:sqlite:gftech_db.db");
            Statement stmt = con.createStatement();
            String query = "delete from gftech_order where OrderID ='"+jTextField_order_orderid.getText()+"'";
            stmt.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Order Successfully deleted!!!");
            load();
            stmt.close();
            con.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error!!! "+ex);
        }
    }//GEN-LAST:event_jButton_deleteActionPerformed

    private void jButton_clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_clearActionPerformed
        jTextField_order_orderid.setText(null);
        jTextField_order_custname.setText(null);
        jTextField_order_orderdate.setText(null);
        jTextField_order_amount.setText(null);
    }//GEN-LAST:event_jButton_clearActionPerformed

    private void jTextField_order_custnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_order_custnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_order_custnameActionPerformed

    private void jButton_searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_searchActionPerformed
        try {
            Class.forName("org.sqlite.JDBC");
            Connection con = DriverManager.getConnection("jdbc:sqlite:gftech_db.db");
            //            Statement stmt = con.createStatement();
            String query = "select * from gftech_order where CustName = '"+jTextField_order_custname.getText()+"' ";
            PreparedStatement stmt = con.prepareStatement(query);
            //            stmt.executeUpdate(query);
            ResultSet set = stmt.executeQuery();
            while(set.next()){
                jTextField_order_orderid.setText(set.getString("OrderID"));
                jTextField_order_custname.setText(set.getString("CustName"));
                jTextField_order_orderdate.setText(set.getString("OrderDate"));
                jTextField_order_amount.setText(set.getString("Amount"));
                jComboBox_order_user.setSelectedItem(set.getString("Soldby"));
            }
            stmt.close();
            con.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error!!! "+ex);
        }
    }//GEN-LAST:event_jButton_searchActionPerformed

    private void jButton_homeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_homeActionPerformed
        GFTECH_Dashboard ds = new GFTECH_Dashboard();
        ds.setVisible(true);
        ds.pack();
        ds.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_jButton_homeActionPerformed

    private void jTable_orderMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable_orderMouseClicked
        DefaultTableModel model = (DefaultTableModel)jTable_order.getModel();
        int index = jTable_order.getSelectedRow();
        jTextField_order_orderid.setText(model.getValueAt(index, 0).toString());
        jTextField_order_custname.setText(model.getValueAt(index, 1).toString());
        jTextField_order_orderdate.setText(model.getValueAt(index, 2).toString());
        jTextField_order_amount.setText(model.getValueAt(index, 3).toString());
        jComboBox_order_user.setSelectedItem(model.getValueAt(index, 4).toString());
    }//GEN-LAST:event_jTable_orderMouseClicked

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
            java.util.logging.Logger.getLogger(GFTECH_view_orders.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GFTECH_view_orders.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GFTECH_view_orders.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GFTECH_view_orders.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GFTECH_view_orders().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_back;
    private javax.swing.JButton jButton_clear;
    private javax.swing.JButton jButton_delete;
    private javax.swing.JButton jButton_home;
    private javax.swing.JButton jButton_search;
    private javax.swing.JButton jButton_update;
    private javax.swing.JComboBox<String> jComboBox_order_user;
    private javax.swing.JLabel jLabel_categorylist;
    private javax.swing.JLabel jLabel_gftech_logo;
    private javax.swing.JLabel jLabel_order_amount;
    private javax.swing.JLabel jLabel_order_custname;
    private javax.swing.JLabel jLabel_order_orderdate;
    private javax.swing.JLabel jLabel_order_orderid;
    private javax.swing.JLabel jLabel_order_soldby;
    private javax.swing.JLabel jLabel_title;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable_order;
    private javax.swing.JTextField jTextField_order_amount;
    private javax.swing.JTextField jTextField_order_custname;
    private javax.swing.JTextField jTextField_order_orderdate;
    private javax.swing.JTextField jTextField_order_orderid;
    // End of variables declaration//GEN-END:variables
}
