/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.ClassesAndFrames.models;

import com.ClassesAndFrames.logic.AllPacksClass;
import com.ClassesAndFrames.DatabaseConnectors.DataBaseConnector;
import com.ClassesAndFrames.MainFrame;
import com.ClassesAndFrames.common.DateTime;
import com.ClassesAndFrames.common.ExportData;

import java.awt.HeadlessException;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;


public final class AllPacksFrame extends javax.swing.JFrame {
    private DefaultTableModel model;
    private final Connection connection = new DataBaseConnector().getConnection();
    private PreparedStatement preparedStatement;
    private String id;
    private String query;
    private final ExportData export = new ExportData();

    public AllPacksFrame() throws SQLException {
        initComponents();
        currentDate();
        show_id();
        show_count();
    }

    public void show_count() {
        int count = packs().size();
        sum.setText(String.valueOf(count));

    }

    public ArrayList<AllPacksClass> packs() {
        ArrayList<AllPacksClass> list = new ArrayList<>();
        try {
            Class.forName("org.h2.Driver");
            query = "SELECT * from OPAKOVKI";

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            AllPacksClass AllPacks;
            while (resultSet.next()) {
                AllPacks = new AllPacksClass(resultSet.getString("IDopakovka"), resultSet.getString("Status"), resultSet.getString("Location"), resultSet.getString("datestamp"), resultSet.getString("numWh"));
                list.add(AllPacks);
            }
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return list;
    }

    public void show_id() {
        ArrayList<AllPacksClass> list1 = packs();
        model = (DefaultTableModel) AllPacksTable.getModel();

        Object[] rows = new Object[5];
        for (AllPacksClass allPacksClass : list1) {
            rows[0] = allPacksClass.getNumWh();
            rows[1] = allPacksClass.getIDopakovka();
            rows[2] = allPacksClass.getStatus();
            rows[3] = allPacksClass.getLocation();
            rows[4] = allPacksClass.getDatestamp();
            model.addRow(rows);
        }
    }

    public void currentDate() {
        DateTime date = new DateTime();
        date1.setText(date.getDate());
    }

    public void comment() throws ClassNotFoundException, SQLException {
        try {
            Class.forName("org.h2.Driver");
            model = (DefaultTableModel) AllPacksTable.getModel();
            int row = AllPacksTable.getSelectedRow();

            id = (AllPacksTable.getModel().getValueAt(row, 1).toString());
            String comment = (AllPacksTable.getModel().getValueAt(row, 5).toString());
            query = "insert into comments values (?,?,?)";

            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, id);
            preparedStatement.setString(2, comment);
            preparedStatement.setString(3, date1.getText());

            preparedStatement.executeUpdate();
            String value = (AllPacksTable.getModel().getValueAt(row, 1).toString());
            JOptionPane.showMessageDialog(null, "Добавихте коментар за опаковка " + value + "!");
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Вече има добавен коментар за опаковка " + id);
        }
    }

    public void refreshInfo() {
        model = (DefaultTableModel) AllPacksTable.getModel();
        model.setRowCount(0);
        show_id();
        show_count();
    }

    public void search(String str) {
        model = (DefaultTableModel) AllPacksTable.getModel();
        TableRowSorter<DefaultTableModel> tableModelTableRowSorter = new TableRowSorter<>(model);

        AllPacksTable.setRowSorter(tableModelTableRowSorter);
        tableModelTableRowSorter.setRowFilter(RowFilter.regexFilter(str));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.JPanel jPanel1 = new javax.swing.JPanel();
        search = new javax.swing.JTextField();
        javax.swing.JLabel jLabel2 = new javax.swing.JLabel();
        date1 = new javax.swing.JLabel();
        javax.swing.JPanel jPanel2 = new javax.swing.JPanel();
        javax.swing.JScrollPane jScrollPane1 = new javax.swing.JScrollPane();
        AllPacksTable = new javax.swing.JTable();
        javax.swing.JPanel jPanel3 = new javax.swing.JPanel();
        javax.swing.JLabel jLabel1 = new javax.swing.JLabel();
        sum = new javax.swing.JLabel();
        javax.swing.JButton refreshInfo = new javax.swing.JButton();
        javax.swing.JButton delete = new javax.swing.JButton();
        javax.swing.JButton saveAs = new javax.swing.JButton();
        javax.swing.JButton coment = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 51, 51));

        search.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchhActionPerformed(evt);
            }
        });
        search.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchKeyReleased(evt);
            }
        });

        jLabel2.setBackground(new java.awt.Color(0, 102, 102));
        jLabel2.setFont(new java.awt.Font("SansSerif", 2, 18)); // NOI18N
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
                                .addComponent(search, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(0, 15, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(date1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(search, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );

        jPanel2.setForeground(new java.awt.Color(51, 51, 51));

        AllPacksTable.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        AllPacksTable.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{

                },
                new String[]{
                        "Складова Разписка", "Опаковка", "Статус", "Местоположение", "Дата", "Коментар"
                }
        ));
        AllPacksTable.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                AllPacksTableKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(AllPacksTable);

        jLabel1.setFont(new java.awt.Font("Dialog", 2, 14)); // NOI18N
        jLabel1.setText("Sum:");

        sum.setFont(new java.awt.Font("Dialog", 3, 14)); // NOI18N

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

        saveAs.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        saveAs.setText(".XLS");
        saveAs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveAsActionPerformed(evt);
            }
        });

        coment.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        coment.setText("Добави Коментар");
        coment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                commentActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(coment, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(saveAs, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(27, 27, 27)
                                .addComponent(delete, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addComponent(jLabel1)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(sum, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(refreshInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(sum, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(refreshInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(delete, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(coment, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(saveAs, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 855, Short.MAX_VALUE)
                                        .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void commentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comentActionPerformed

        try {
            comment();
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, ex);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Вече има добавен коментар за опаковка " + id);
        } catch (ArrayIndexOutOfBoundsException ex) {
            JOptionPane.showMessageDialog(null, "Празно поле!");
        }
    }//GEN-LAST:event_comentActionPerformed

    private void saveAsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveAsActionPerformed

        try {
            export.export(AllPacksTable);
        } catch (IOException e) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, e);
        }
    }//GEN-LAST:event_saveAsActionPerformed

    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed

        try {
            Class.forName("org.h2.Driver");
            int row = AllPacksTable.getSelectedRow();
            String value = (AllPacksTable.getModel().getValueAt(row, 1).toString());

            query = "DELETE FROM OPAKOVKI where IDopakovka='" + value + "'";

            preparedStatement = connection.prepareStatement(query);
            preparedStatement.executeUpdate();
            model = (DefaultTableModel) AllPacksTable.getModel();
            model.setRowCount(0);

            show_id();
            JOptionPane.showMessageDialog(null, "Изтрихте " + value);
        } catch (HeadlessException | ClassNotFoundException | SQLException e) {
            System.out.println(e);
        } catch (ArrayIndexOutOfBoundsException ex) {
            JOptionPane.showMessageDialog(null, "Няма избрано поле!");
        }
    }//GEN-LAST:event_deleteActionPerformed

    private void deleteKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_deleteKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_deleteKeyReleased

    private void refreshInfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshInfoActionPerformed
        refreshInfo();        // TODO add your handling code here:
    }//GEN-LAST:event_refreshInfoActionPerformed

    private void searchhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchhActionPerformed
        // TODO add your handling code here: update sum when search filter is on

    }//GEN-LAST:event_searchhActionPerformed

    private void searchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchhKeyReleased
        String searchTxt = search.getText();
        search(searchTxt);
    }//GEN-LAST:event_searchKeyReleased

    private void deleteMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteMouseReleased
        refreshInfo();
    }//GEN-LAST:event_deleteMouseReleased

    private void AllPacksTableKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_AllPacksTableKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_DELETE) {
            try {
                Class.forName("org.h2.Driver");
                int row = AllPacksTable.getSelectedRow();
                String value = (AllPacksTable.getModel().getValueAt(row, 1).toString());

                query = "DELETE FROM OPAKOVKI where IDopakovka='" + value + "'";
                preparedStatement = connection.prepareStatement(query);
                preparedStatement.executeUpdate();
                model = (DefaultTableModel) AllPacksTable.getModel();
                model.setRowCount(0);

                show_id();
                refreshInfo();
                JOptionPane.showMessageDialog(null, "Изтрихте " + value);
            } catch (Exception e) {
                Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            try {
                comment();
            } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(AllPacksFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
            refreshInfo();
        }
    }//GEN-LAST:event_AllPacksTableKeyPressed

    /**
     * @param args the command line arguments
     */


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable AllPacksTable;
    private javax.swing.JLabel date1;
    private javax.swing.JTextField search;
    private javax.swing.JLabel sum;
    // End of variables declaration//GEN-END:variables
}
