
package com.ClassesAndFrames;
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
    BufferedOutputStream out;
    FileOutputStream FOS;
    File file;
    Row row;
    Cell cell;
    Workbook wb;
    XSSFSheet sheet;
    ExportData(){}
    public void openFile(String file){
    try{
    File path =new File(file);
    java.awt.Desktop.getDesktop().open(path);
            }catch(IOException e){}
    }
    public void export(JTable jt) throws FileNotFoundException, IOException{
    JFileChooser fileChooser = new JFileChooser();
    fileChooser.showSaveDialog(jt);
    File saveFile = fileChooser.getSelectedFile();
    if(saveFile != null){
    saveFile=new File(saveFile.toString()+".xlsx");
     wb = new XSSFWorkbook();
     sheet = (XSSFSheet) wb.createSheet("opakovki");
    Row rowCol = sheet.createRow(0);
        for (int i = 0; i < jt.getColumnCount(); i++) {
             cell = rowCol.createCell(i);
            cell.setCellValue(jt.getColumnName(i));
        }
        for (int j = 0; j < jt.getRowCount(); j++) {
             row = sheet.createRow(j+1);
            for (int k = 0; k < jt.getColumnCount(); k++) {
                 cell = row.createCell(k);
                if(jt.getValueAt(j, k)!= null){
                cell.setCellValue(jt.getValueAt(j,k).toString());
                }
            }
        }
         FOS = new FileOutputStream(new File(saveFile.toString()));
        wb.write(out);
        wb.close();
        out.close();
        openFile(saveFile.toString());
    }else{JOptionPane.showMessageDialog(null, "error");}
    }
}
