/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.ClassesAndFrames;

import java.awt.HeadlessException;
import java.awt.event.KeyEvent;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author LL
 */
public final class CommentsFrame extends javax.swing.JFrame {
 DefaultTableModel model;
    Connection conn;
    PreparedStatement prs;
    ResultSet rs;
    BufferedOutputStream out;
    FileOutputStream FOS;
    File file;
    String num;
    String id;
    String comment;
    String querry;
    
    public CommentsFrame() throws SQLException, ClassNotFoundException {
        initComponents();
        show_comments();
        currentDate();
    }
    public void refreshInfo() throws SQLException, ClassNotFoundException{
    model = (DefaultTableModel)commentsTable.getModel();
     model.setRowCount(0);
     show_comments();
}
    public void currentDate() {
        GregorianCalendar cal = new GregorianCalendar();
        int month = cal.get(Calendar.MONTH);
        int day = cal.get(Calendar.DAY_OF_MONTH);
        int year = cal.get(Calendar.YEAR);
        date1.setText(day + "/" + (month + 1) + "/" + year);
    }
    public void delete(){
     try {
            Class.forName("org.h2.Driver");
             conn = DriverManager.getConnection("jdbc:h2:./DB/db;IFEXISTS=TRUE", "test", "test");

            int row = commentsTable.getSelectedRow();
            String value = (commentsTable.getModel().getValueAt(row, 0).toString());
            String query1 = "DELETE FROM comments where id='" + value + "'";
            PreparedStatement pst = conn.prepareStatement(query1);
            pst.executeUpdate();
            model = (DefaultTableModel) commentsTable.getModel();
            model.setRowCount(0);
            show_comments();
            JOptionPane.showMessageDialog(null, "???????????????? " + value);
            refreshInfo();
        } catch (HeadlessException | ClassNotFoundException | SQLException e) {
            System.out.println(e);
        }catch(ArrayIndexOutOfBoundsException ex){
            JOptionPane.showMessageDialog(null, "???????? ?????????????? ????????!");
        }}
 public void search(String str) {
        model = (DefaultTableModel) commentsTable.getModel();
        TableRowSorter<DefaultTableModel> trs = new TableRowSorter<>(model);
        commentsTable.setRowSorter(trs);
        trs.setRowFilter(RowFilter.regexFilter(str));
    }
  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        searchh = new javax.swing.JTextField();
        date1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        commentsTable = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        refreshInfo = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 51, 51));

        jLabel2.setBackground(new java.awt.Color(0, 102, 102));
        jLabel2.setFont(new java.awt.Font("Dialog", 2, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(204, 255, 204));
        jLabel2.setText("??????????????:");

        searchh.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        searchh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchhActionPerformed(evt);
            }
        });
        searchh.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchhKeyReleased(evt);
            }
        });

        date1.setBackground(new java.awt.Color(0, 102, 102));
        date1.setFont(new java.awt.Font("Dialog", 3, 18)); // NOI18N
        date1.setForeground(new java.awt.Color(204, 255, 204));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(date1, javax.swing.GroupLayout.DEFAULT_SIZE, 131, Short.MAX_VALUE)
                .addGap(251, 251, 251)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(searchh, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(date1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 53, Short.MAX_VALUE)
                        .addComponent(searchh, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(10, 10, 10))
        );

        commentsTable.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        commentsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "????????????????", "????????????????", "????????"
            }
        ));
        commentsTable.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                commentsTableKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(commentsTable);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        refreshInfo.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        refreshInfo.setText("????????????");
        refreshInfo.setIconTextGap(0);
        refreshInfo.setPreferredSize(new java.awt.Dimension(40, 42));
        refreshInfo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshInfoActionPerformed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jButton1.setText("????????????");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jButton1MouseReleased(evt);
            }
        });
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(refreshInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(12, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(refreshInfo, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void searchhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchhActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchhActionPerformed

    private void searchhKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchhKeyReleased
        String searchTxt = searchh.getText();
        search(searchTxt);
    }//GEN-LAST:event_searchhKeyReleased

    private void refreshInfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshInfoActionPerformed
     try {
         refreshInfo();        // TODO add your handling code here:
     } catch (SQLException | ClassNotFoundException ex) {
         Logger.getLogger(CommentsFrame.class.getName()).log(Level.SEVERE, null, ex);
     }
    }//GEN-LAST:event_refreshInfoActionPerformed

    private void jButton1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseReleased
     try {
         refreshInfo();        // TODO add your handling code here:
     } catch (SQLException | ClassNotFoundException ex) {
         Logger.getLogger(CommentsFrame.class.getName()).log(Level.SEVERE, null, ex);
     }
    }//GEN-LAST:event_jButton1MouseReleased

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
      delete();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void commentsTableKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_commentsTableKeyPressed
if(evt.getKeyCode()==KeyEvent.VK_DELETE){
 delete();    
    
}   
    }//GEN-LAST:event_commentsTableKeyPressed
public ArrayList<Comments> comments() throws SQLException, ClassNotFoundException{
ArrayList<Comments> list = new ArrayList<>();
try{
Class.forName("org.h2.Driver");
            conn = DriverManager.getConnection("jdbc:h2:./DB/db;IFEXISTS=TRUE", "test", "test");
            querry = "SELECT * from comments";
            Statement stm = conn.createStatement();
            rs = stm.executeQuery(querry);
            Comments comments = null;
            while(rs.next()){
            comments = new Comments(rs.getString("id"),rs.getString("comment"),rs.getString("datestamp"));
            list.add(comments);
            }
}catch(ClassNotFoundException | SQLException e){
    System.out.println(e);}
return list;

}
    public void show_comments() throws SQLException, ClassNotFoundException{
    ArrayList<Comments> list1 = comments();
    model = (DefaultTableModel) commentsTable.getModel();
    Object[] rows = new Object[3];
        for (int i = 0; i < list1.size(); i++) {
            rows[0] = list1.get(i).getIDopakovka();
            rows[1] = list1.get(i).getComment();
            rows[2] = list1.get(i).getDatestamp();
            model.addRow(rows);
        }
    }
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable commentsTable;
    private javax.swing.JLabel date1;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton refreshInfo;
    private javax.swing.JTextField searchh;
    // End of variables declaration//GEN-END:variables
}
