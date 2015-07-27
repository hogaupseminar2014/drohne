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
public class writer {
        
    static void schreiben(String eingabe){
        
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
    
    static void Motor_schreiben(int m1, int m2, int m3, int m4){
        
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
   
    static String getdate(){
        
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy hh:mm:ss"); //Layout für die Zeit
        Timestamp time = new Timestamp(System.currentTimeMillis()); //fragt die Systemzeit ab und speichert sie in "time"
        return sdf.format(time); //gibt den fertigen String zutück
    }
}
