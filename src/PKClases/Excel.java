/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PKClases;

import java.io.File;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;


/**
 *
 * @author Matias
 */
import BD.ConexionBD;
import com.mysql.cj.result.Row;
import java.awt.Desktop;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JTable;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import jxl.Cell;
import jxl.Sheet;
import jxl.write.WritableWorkbook;
import org.apache.poi.hssf.usermodel.*;





public class Excel {
    Connection con;
    
    
    
    
        public void exportarCnsultaExcel(JTable jTableConsultaCaja){
  
        try{
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.showSaveDialog(fileChooser);
            File fileSave = fileChooser.getSelectedFile();
            if(fileSave != null){
                fileSave = new File(fileSave.toString()+".xls");
                WritableWorkbook workbook = Workbook.createWorkbook(fileSave);
                WritableSheet sheet = workbook.createSheet("Consulta",0);
                TableModel tablaModelo = jTableConsultaCaja.getModel();
                
                
                for(int i=0 ; i > tablaModelo.getColumnCount();i++){
                    
                    Label column = new Label(i,0,tablaModelo.getColumnName(i));
                    sheet.addCell(column);}
                    
                    
                for(int i=0 ; i > tablaModelo.getRowCount();i++){
                    for(int j = 0; j> tablaModelo.getColumnCount();j++){
                        
                        Label row = new Label (j,i+1,tablaModelo.getValueAt(i, i).toString());
                        sheet.addCell(row);

                    
                    
                    }
            }

                workbook.write();
                workbook.close();
                JOptionPane.showMessageDialog(null,"Archivo generado");
                openFile(fileSave.toString());
            }else{
                JOptionPane.showMessageDialog(null,"Error al crear archivo ");
            }
        }catch(IOException iOException){
            iOException.printStackTrace();
        }catch(Exception exception){
            exception.printStackTrace();
        }}
        
        
        public void openFile (String file){
            try{
                File path = new File(file);
                Desktop.getDesktop().open(path);
            
            }catch(IOException e){ 
            
                e.printStackTrace();
            }
                
                
        }
        
        public void exportarExcel(JTable t){
        JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Archivos de excel", "xls");
        chooser.setFileFilter(filter);
        chooser.setDialogTitle("Guardar archivo");
        chooser.setAcceptAllFileFilterUsed(false);
        if (chooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
            String ruta = chooser.getSelectedFile().toString().concat(".xls");
            try {
                File archivoXLS = new File(ruta);
                if (archivoXLS.exists()) {
                    archivoXLS.delete();
                }
                archivoXLS.createNewFile();
                HSSFWorkbook libro = new HSSFWorkbook();
                FileOutputStream archivo = new FileOutputStream(archivoXLS);
                HSSFSheet hoja = libro.createSheet("Consulta");
               
                for (int f = 0; f < t.getRowCount(); f++) {
                    HSSFRow fila = hoja.createRow(f);
                    for (int c = 0; c < t.getColumnCount(); c++) {
                        HSSFCell celda = fila.createCell(c);
                        if (f == 0) {
                            celda.setCellValue(t.getColumnName(c));
                        }
                    }
                }
                int filaInicio = 1;
                for (int f = 0; f < t.getRowCount(); f++) {
                    HSSFRow fila = hoja.createRow(filaInicio);
                    filaInicio++;
                    for (int c = 0; c < t.getColumnCount(); c++) {
                        HSSFCell celda = fila.createCell(c);
                        if (t.getValueAt(f, c) instanceof Double) {
                            celda.setCellValue(Double.parseDouble(t.getValueAt(f, c).toString()));
                        } else if (t.getValueAt(f, c) instanceof Float) {
                            celda.setCellValue(Float.parseFloat((String) t.getValueAt(f, c)));
                        } else {
                            celda.setCellValue(String.valueOf(t.getValueAt(f, c)));
                        }
                    }
                }
                libro.write(archivo);
                archivo.close();
                Desktop.getDesktop().open(archivoXLS);
            } catch (IOException | NumberFormatException e) {
               
            }
        }
    }
        
        
        
        
    }
    

