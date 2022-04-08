/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.ClassesAndFrames;

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


public final class AllPacksFrame extends javax.swing.JFrame {
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
    ExportData export = new ExportData();
     public ArrayList<AllPacksClass> opakovki() {
        ArrayList<AllPacksClass> list = new ArrayList<>();
        try {
            Class.forName("org.h2.Driver");
            conn = DriverManager.getConnection("jdbc:h2:~/DB;IFEXISTS=TRUE", "test", "test");
            querry = "SELECT * from OPAKOVKI";

            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(querry);
            AllPacksClass AllPacks = null;
            while (rs.next()) {
                AllPacks = new AllPacksClass(rs.getString("IDopakovka"), rs.getString("Status"), rs.getString("Location"), rs.getString("datestamp"), rs.getString("numWh"));
                list.add(AllPacks);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return list;
    }
     public void show_id() {
        ArrayList<AllPacksClass> list1 = opakovki();
        model = (DefaultTableModel) AllPacksTable.getModel();
        Object[] rows = new Object[5];
        for (int i = 0; i < list1.size(); i++) {
            rows[0] = list1.get(i).getNumWh();
            rows[1] = list1.get(i).getIDopakovka();
            rows[2] = list1.get(i).getStatus();
            rows[3] = list1.get(i).getLocation();
            rows[4] = list1.get(i).getDatestamp();
            model.addRow(rows);
        }
    } 
public void currentDate() {
        GregorianCalendar cal = new GregorianCalendar();
        int month = cal.get(Calendar.MONTH);
        int day = cal.get(Calendar.DAY_OF_MONTH);
        int year = cal.get(Calendar.YEAR);
        date1.setText(day + "/" + (month + 1) + "/" + year);
    }
public void comment() throws ClassNotFoundException, SQLException{ 
try{
Class.forName("org.h2.Driver");
              conn = DriverManager.getConnection("jdbc:h2:~/DB;IFEXISTS=TRUE", "test", "test");
            model = (DefaultTableModel) AllPacksTable.getModel();
            int row = AllPacksTable.getSelectedRow();
            id = (AllPacksTable.getModel().getValueAt(row, 1).toString());
            comment= (AllPacksTable.getModel().getValueAt(row, 5).toString());
            querry ="insert into comments values (?,?,CURRENT_DATE)";
             prs = conn.prepareStatement(querry);
            prs.setString(1,id);
            prs.setString(2,comment);
            prs.executeUpdate();
}catch(Exception e){
JOptionPane.showMessageDialog(null, "Вече има добавен коментар за опаковка "+id );}
}
    public AllPacksFrame() {
        initComponents();
        currentDate();
        show_id();   
    }
    public void refreshInfo(){
    model = (DefaultTableModel)AllPacksTable.getModel();
     model.setRowCount(0);
     show_id();
}
    public void search(String str) {
        model = (DefaultTableModel) AllPacksTable.getModel();
        TableRowSorter<DefaultTableModel> trs = new TableRowSorter<>(model);
        AllPacksTable.setRowSorter(trs);
        trs.setRowFilter(RowFilter.regexFilter(str));
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        searchh = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        date1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        AllPacksTable = new javax.swing.JTable();
        coment = new javax.swing.JButton();
        saveAs = new javax.swing.JButton();
        delete = new javax.swing.JButton();
        refreshInfo = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 51, 51));

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

        jLabel2.setBackground(new java.awt.Color(0, 102, 102));
        jLabel2.setFont(new java.awt.Font("Dialog", 2, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(204, 255, 204));
        jLabel2.setText("Търсене:");

        date1.setBackground(new java.awt.Color(0, 102, 102));
        date1.setFont(new java.awt.Font("Dialog", 3, 18)); // NOI18N
        date1.setForeground(new java.awt.Color(204, 255, 204));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(date1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(368, 368, 368)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(searchh, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 15, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(date1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(searchh, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );

        jPanel2.setForeground(new java.awt.Color(51, 51, 51));

        AllPacksTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Складова Разписка", "Опаковка", "Статус", "Местоположение", "Дата", "Коментар"
            }
        ));
        jScrollPane1.setViewportView(AllPacksTable);

        coment.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        coment.setText("Добави Коментар");
        coment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comentActionPerformed(evt);
            }
        });

        saveAs.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        saveAs.setText(".XLS");
        saveAs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveAsActionPerformed(evt);
            }
        });

        delete.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        delete.setText("Изтрий");
        delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActionPerformed(evt);
            }
        });
        delete.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                deleteKeyReleased(evt);
            }
        });

        refreshInfo.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        refreshInfo.setText("Обнови");
        refreshInfo.setIconTextGap(0);
        refreshInfo.setPreferredSize(new java.awt.Dimension(40, 42));
        refreshInfo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshInfoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(coment, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(saveAs, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(delete, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(refreshInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 442, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(refreshInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(delete, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(coment, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(saveAs, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(27, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void comentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comentActionPerformed

        try {
            comment();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AllPacksFrame.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Вече има добавен коментар за опаковка "+id );
        }
    }//GEN-LAST:event_comentActionPerformed

    private void saveAsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveAsActionPerformed

        try {
            export.export(AllPacksTable);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_saveAsActionPerformed

    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed

        try {
            Class.forName("org.h2.Driver");
            Connection conn = DriverManager.getConnection("jdbc:h2:~/DB;IFEXISTS=TRUE", "test", "test");

            int row = AllPacksTable.getSelectedRow();
            String value = (AllPacksTable.getModel().getValueAt(row, 1).toString());
            String query1 = "DELETE FROM OPAKOVKI where IDopakovka='" + value + "'";
            PreparedStatement pst = conn.prepareStatement(query1);
            pst.executeUpdate();
            model = (DefaultTableModel) AllPacksTable.getModel();
            model.setRowCount(0);
            show_id();
            JOptionPane.showMessageDialog(null, "Изтрихте " + value);
        } catch (Exception e) {
            System.out.println(e);
        }
    }//GEN-LAST:event_deleteActionPerformed

    private void deleteKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_deleteKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_deleteKeyReleased

    private void refreshInfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshInfoActionPerformed
        refreshInfo();        // TODO add your handling code here:
    }//GEN-LAST:event_refreshInfoActionPerformed

    private void searchhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchhActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchhActionPerformed

    private void searchhKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchhKeyReleased
         String searchTxt = searchh.getText();
        search(searchTxt);
    }//GEN-LAST:event_searchhKeyReleased

    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable AllPacksTable;
    private javax.swing.JButton coment;
    private javax.swing.JLabel date;
    private javax.swing.JLabel date1;
    private javax.swing.JButton delete;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton refreshInfo;
    private javax.swing.JButton saveAs;
    private javax.swing.JTextField search;
    private javax.swing.JTextField searchh;
    // End of variables declaration//GEN-END:variables
}
