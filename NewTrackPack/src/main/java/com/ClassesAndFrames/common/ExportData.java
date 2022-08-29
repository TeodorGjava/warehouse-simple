
package com.ClassesAndFrames.common;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTable;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExportData {
    public ExportData() {
    }

    private final JFileChooser fileChooser = new JFileChooser();
    private final Workbook wb = new XSSFWorkbook();

    public void openFile(String file) throws IOException {
        File path = new File(file);
        java.awt.Desktop.getDesktop().open(path);
    }

    public void export(JTable jTable) throws IOException {
        fileChooser.showSaveDialog(jTable);
        File saveFile = fileChooser.getSelectedFile();
        if (saveFile != null) {
            saveFile = new File(saveFile + ".xlsx");
            XSSFSheet sheet = (XSSFSheet) wb.createSheet("опаковки");
            Row rowCol = sheet.createRow(0);
            Cell cell;
            for (int i = 0; i < jTable.getColumnCount(); i++) {
                cell = rowCol.createCell(i);
                cell.setCellValue(jTable.getColumnName(i));
            }
            for (int j = 0; j < jTable.getRowCount(); j++) {
                Row row = sheet.createRow(j + 1);
                for (int k = 0; k < jTable.getColumnCount(); k++) {
                    cell = row.createCell(k);
                    if (jTable.getValueAt(j, k) != null) {
                        cell.setCellValue(jTable.getValueAt(j, k).toString());
                    }
                }
            }
            FileOutputStream FOS = new FileOutputStream(saveFile.toString());
            wb.write(FOS);
            wb.close();
            FOS.close();
            openFile(saveFile.toString());

        } else {
            JOptionPane.showMessageDialog(null, "Error!");
        }
    }
}
