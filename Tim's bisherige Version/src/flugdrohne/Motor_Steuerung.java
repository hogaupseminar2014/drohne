/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flugdrohne;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;

/**
 *
 * @author Tim
 */
public class Motor_Steuerung {
    
    Motor m1;
    Motor m2;
    Motor m3;
    Motor m4;
    SimpleDateFormat sdf;
    File Datei;
    File file = new File("//"+ "log");
            
    Motor_Steuerung(){
        m1 = new Motor("1",1);
        m2 = new Motor("2",2);
        m3 = new Motor("3",3);
        m4 = new Motor("4",4);
    }
    
    void Motorkraft_Aendern(int k_m1, int k_m2, int k_m3, int k_m4, int zeit){ //Im normallfall ist die Zeit 1, wenn die Drohne z.b den Auftrag bekommen soll 20 Sekunden geradeaus zu fliegen, kann man die Zeit auf 20 setzen 
        
        Motor_schreiben(k_m1, k_m2, k_m3, k_m4);
        int i = 0;
        while (i < zeit){
            m1.KraftGeben(k_m1);
            m2.KraftGeben(k_m2);
            m3.KraftGeben(k_m3);
            m4.KraftGeben(k_m4);
            i = i + 1;
            
            try {
                Thread.sleep(5);                 //Zeit in Millisekunden - 1000ms sind eine Sekunde
                }
            catch(InterruptedException ex) {
                Thread.currentThread().interrupt();
                }
        }
    }
    
    int Motor_Testen(){
        Motorkraft_Aendern(10,10,10,10,10);
        try {
                Thread.sleep(5000);                 //Zeit in Millisekunden - 1000ms sind eine Sekunde
                }
            catch(InterruptedException ex) {
                Thread.currentThread().interrupt();
                }
        return 10;
    }
    
    void schreiben(String eingabe){
        File file = new File("//"+ "log");
     try {
       // new FileWriter(file ,true) - falls die Datei bereits existiert
       // werden die Bytes an das Ende der Datei geschrieben
       
       // new FileWriter(file) - falls die Datei bereits existiert
       // wird diese überschrieben
       FileWriter schreiben = new FileWriter(file ,true); // Platformunabhängiger Zeilenumbruch wird in den Stream geschrieben
       schreiben.write(System.getProperty("line.separator")); //neue Zeile wird eingefügt   
       schreiben.write(getdate() + ": " + eingabe); // Text wird in den Stream geschrieben
       schreiben.flush(); //Stream wird gespeichert
       schreiben.close(); //FileWriter wird beendet
       
    } catch (IOException e) {
      JOptionPane.showMessageDialog(null, "Datei nicht /log konnte nicht geschrieben werden", "Error", JOptionPane.ERROR_MESSAGE);
    }
    }
    
    void Motor_schreiben(int m1, int m2, int m3, int m4){
        File file = new File("//"+ "log");
     try {
       // new FileWriter(file ,true) - falls die Datei bereits existiert
       // werden die Bytes an das Ende der Datei geschrieben
       
       // new FileWriter(file) - falls die Datei bereits existiert
       // wird diese überschrieben
       FileWriter schreiben = new FileWriter(file ,true); // Platformunabhängiger Zeilenumbruch wird in den Stream geschrieben
       schreiben.write(System.getProperty("line.separator")); //neue Zeile wird eingefügt   
       schreiben.write(getdate() + ": " + "Motorkraft geändert M1: " + m1 + "% M2: " + m2 + "% M3: " + m3 + "% M4: " + m4); // Text wird in den Stream geschrieben
       schreiben.flush(); //Stream wird gespeichert
       schreiben.close(); //FileWriter wird beendet
       
    } catch (IOException e) {
      file = new File(JOptionPane.showInputDialog("Datei /log konnte nicht geschrieben werden, bitte geben sie den Pfad ein"));
    }
    }
   
    String getdate(){
        
    sdf = new SimpleDateFormat("dd.MM.yyyy hh:mm:ss"); //Layout für die Zeit
    Timestamp time = new Timestamp(System.currentTimeMillis()); //fragt die Systemzeit ab und speichert sie in "time"
    return sdf.format(time); //gibt den fertigen String zutück
    }
}
