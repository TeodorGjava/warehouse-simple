/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.ClassesAndFrames;

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
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author LL
 */
public class ProblemPacksFrame extends javax.swing.JFrame {
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
    String newID;
    /**
     * Creates new form ProblemPacksFrame
     * @throws java.sql.SQLException
     */
    public void refreshInfo() throws SQLException, ClassNotFoundException{
    model = (DefaultTableModel)problemTable.getModel();
     model.setRowCount(0);
     show_table();
}
    public void currentDate() {
        GregorianCalendar cal = new GregorianCalendar();
        int month = cal.get(Calendar.MONTH);
        int day = cal.get(Calendar.DAY_OF_MONTH);
        int year = cal.get(Calendar.YEAR);
        date1.setText(day + "/" + (month + 1) + "/" + year);
    }
    public ProblemPacksFrame() throws SQLException, ClassNotFoundException {
        initComponents();
        show_table();
        currentDate();
    }
    public void insertProblem() throws SQLException, ClassNotFoundException{
    try{
Class.forName("org.h2.Driver");
              conn = DriverManager.getConnection("jdbc:h2:~/DB;IFEXISTS=TRUE", "test", "test");
            model = (DefaultTableModel) problemTable.getModel();
            int row = problemTable.getSelectedRow();
            id = (problemTable.getModel().getValueAt(row, 0).toString());
            newID =(problemTable.getModel().getValueAt(row, 1).toString());
            querry = "update new set newID=?, datestamp = ? WHERE oldID='"+id+"'";
            prs = conn.prepareStatement(querry);
            prs.setString(1, newID);
            prs.setString(2, date1.getText());
            prs.executeUpdate();
            conn.close();}catch(Exception e){
            System.out.println(e);}
    
    
    
    }
    public ArrayList<ProblemPacksClass> problems() throws SQLException, ClassNotFoundException{
        ArrayList<ProblemPacksClass> list = new ArrayList();
        try {
            Class.forName("org.h2.Driver");
            conn = DriverManager.getConnection("jdbc:h2:~/DB;IFEXISTS=TRUE", "test", "test");
            querry = "SELECT * from new";
            Statement stm = conn.createStatement();
            rs = stm.executeQuery(querry);
            ProblemPacksClass problemPacks = null;
            while(rs.next()){
            problemPacks = new ProblemPacksClass(rs.getString("oldID"),rs.getString("newID"),rs.getString("datestamp"));
            list.add(problemPacks);
            }
        }catch(ClassNotFoundException | SQLException e){
            System.out.println(e);}
        return list;
    }
    public void show_table() throws SQLException, ClassNotFoundException{
    ArrayList<ProblemPacksClass> list1 = problems();
    model = (DefaultTableModel) problemTable.getModel();
    Object[] rows = new Object[3];
    for(int i = 0; i< list1.size();i++){
    rows[0] = list1.get(i).getIDopakovka();
    rows[1] = list1.get(i).getNewID();
    rows[2] = list1.get(i).getDatestamp();
    model.addRow(rows); 
    }
    
    }
public void search(String str) {
        model = (DefaultTableModel) problemTable.getModel();
        TableRowSorter<DefaultTableModel> trs = new TableRowSorter<>(model);
        problemTable.setRowSorter(trs);
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
        problemTable = new javax.swing.JTable();
        setNewID = new javax.swing.JButton();
        refreshInfo = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 51, 51));

        jLabel2.setBackground(new java.awt.Color(0, 102, 102));
        jLabel2.setFont(new java.awt.Font("SansSerif", 2, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(204, 255, 204));
        jLabel2.setText("Търсене:");

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

        problemTable.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        problemTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Дублиран номер", "Нов номер", "Дата"
            }
        ));
        problemTable.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                problemTableKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(problemTable);

        setNewID.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        setNewID.setText("Добави нов номер");
        setNewID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                setNewIDActionPerformed(evt);
            }
        });

        refreshInfo.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
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
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(setNewID, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(refreshInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 744, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 407, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(setNewID, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
                    .addComponent(refreshInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
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
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
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

    private void setNewIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_setNewIDActionPerformed
        try {
            insertProblem();    
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(ProblemPacksFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_setNewIDActionPerformed

    private void refreshInfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshInfoActionPerformed
        try {        
            refreshInfo();
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(ProblemPacksFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_refreshInfoActionPerformed

    private void problemTableKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_problemTableKeyPressed
if(evt.getKeyCode()==KeyEvent.VK_ENTER){
try {
            insertProblem();  
            refreshInfo();
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(ProblemPacksFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
}        // TODO add your handling code here:
    }//GEN-LAST:event_problemTableKeyPressed

  

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel date1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable problemTable;
    private javax.swing.JButton refreshInfo;
    private javax.swing.JTextField searchh;
    private javax.swing.JButton setNewID;
    // End of variables declaration//GEN-END:variables
}
