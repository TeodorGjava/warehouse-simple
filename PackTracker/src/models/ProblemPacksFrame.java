/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.ClassesAndFrames.models;

import com.ClassesAndFrames.DatabaseConnectors.DataBaseConnector;
import com.ClassesAndFrames.logic.ProblemPacksClass;
import com.ClassesAndFrames.common.DateTime;

import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 * @author LL
 */
public final class ProblemPacksFrame extends javax.swing.JFrame {
    private DefaultTableModel model;
    private final Connection connection = new DataBaseConnector().getConnection();
    private PreparedStatement preparedStatement;
    private String query;

    /**
     * Creates new form ProblemPacksFrame
     *
     * @throws java.sql.SQLException
     */
    public void refreshInfo() throws SQLException, ClassNotFoundException {
        model = (DefaultTableModel) problemTable.getModel();
        model.setRowCount(0);
        show_table();
    }

    public void currentDate() {
        DateTime dt = new DateTime();
        date1.setText(dt.getDate());
    }

    public ProblemPacksFrame() throws SQLException, ClassNotFoundException {
        initComponents();
        show_table();
        currentDate();
    }

    public void insertProblem() throws SQLException, ClassNotFoundException {
        try {
            Class.forName("org.h2.Driver");
            model = (DefaultTableModel) problemTable.getModel();
            int row = problemTable.getSelectedRow();
            String id = (problemTable.getModel().getValueAt(row, 0).toString());
            String newID = (problemTable.getModel().getValueAt(row, 1).toString());

            query = "update new set newID=?, datestamp = ? WHERE oldID='" + id + "'";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, newID);
            preparedStatement.setString(2, date1.getText());

            preparedStatement.executeUpdate();
            connection.close();
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);
        } catch (ArrayIndexOutOfBoundsException ex) {
            JOptionPane.showMessageDialog(null, "Запишете нов номер!");
        }
    }

    public List<ProblemPacksClass> problems() {
        List<ProblemPacksClass> list = new ArrayList();
        try {
            Class.forName("org.h2.Driver");
            query = "SELECT * from new";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            ProblemPacksClass problemPacks;
            while (resultSet.next()) {
                problemPacks = new ProblemPacksClass(resultSet.getString("oldID"), resultSet.getString("newID"), resultSet.getString("datestamp"));
                list.add(problemPacks);
            }
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    public void show_table() throws SQLException, ClassNotFoundException {
        List<ProblemPacksClass> list1 = problems();
        model = (DefaultTableModel) problemTable.getModel();

        Object[] rows = new Object[3];
        for (ProblemPacksClass problemPacksClass : list1) {
            rows[0] = problemPacksClass.getIDopakovka();
            rows[1] = problemPacksClass.getNewID();
            rows[2] = problemPacksClass.getDatestamp();
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

        javax.swing.JPanel jPanel1 = new javax.swing.JPanel();
        javax.swing.JLabel jLabel2 = new javax.swing.JLabel();
        search = new javax.swing.JTextField();
        date1 = new javax.swing.JLabel();
        javax.swing.JPanel jPanel2 = new javax.swing.JPanel();
        javax.swing.JScrollPane jScrollPane1 = new javax.swing.JScrollPane();
        problemTable = new javax.swing.JTable();
        javax.swing.JButton setNewID = new javax.swing.JButton();
        javax.swing.JButton refreshInfo = new javax.swing.JButton();
        javax.swing.JButton delete = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 51, 51));

        jLabel2.setBackground(new java.awt.Color(0, 102, 102));
        jLabel2.setFont(new java.awt.Font("SansSerif", 2, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(204, 255, 204));
        jLabel2.setText("Търсене:");

        search.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchhActionPerformed(evt);
            }
        });
        search.addKeyListener(new java.awt.event.KeyAdapter() {
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
                                .addComponent(search, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                                                .addComponent(search, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(10, 10, 10))
        );

        problemTable.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        problemTable.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{

                },
                new String[]{
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

        delete.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        delete.setText("Изтрий");
        delete.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                deleteMouseReleased(evt);
            }
        });
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

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addComponent(setNewID, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(58, 58, 58)
                                                .addComponent(delete, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(refreshInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 744, Short.MAX_VALUE))
                                .addContainerGap())
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[]{delete, refreshInfo, setNewID});

        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 407, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(setNewID, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(refreshInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(delete))
                                .addContainerGap())
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[]{delete, refreshInfo, setNewID});

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
        String searchTxt = search.getText();
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
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            try {
                insertProblem();
                refreshInfo();
            } catch (SQLException | ClassNotFoundException ex) {
                Logger.getLogger(ProblemPacksFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }        // TODO add your handling code here:
    }//GEN-LAST:event_problemTableKeyPressed

    private void deleteMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteMouseReleased
        try {
            refreshInfo();
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(ProblemPacksFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_deleteMouseReleased

    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed

        try {
            Class.forName("org.h2.Driver");

            int row = problemTable.getSelectedRow();
            String value = (problemTable.getModel().getValueAt(row, 0).toString());
            query = "DELETE FROM new where OLDID='" + value + "'";

            preparedStatement = connection.prepareStatement(query);
            preparedStatement.executeUpdate();
            model = (DefaultTableModel) problemTable.getModel();
            model.setRowCount(0);

            show_table();
            JOptionPane.showMessageDialog(null, "Изтрихте " + value);
        } catch (ArrayIndexOutOfBoundsException ex) {
            JOptionPane.showMessageDialog(null, "Няма избрано поле!");
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(ProblemPacksFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_deleteActionPerformed

    private void deleteKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_deleteKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_deleteKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel date1;
    private javax.swing.JTable problemTable;
    private javax.swing.JTextField search;
    // End of variables declaration//GEN-END:variables
}
