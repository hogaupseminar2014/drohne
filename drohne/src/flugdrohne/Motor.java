/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flugdrohne;

import java.io.IOException;
import javax.swing.JOptionPane;

/**
 *
 * @author Tim
 */

public class Motor {
   
    Motor(){ //Name des GPIOs, kann frei gewählt werden, GPIO an der der Controller angeschlossen wurde

    }
    
    void setSpeed(int motorkraft,int pin){ //motorkraft in % angeben
        
        int impuls = 1000 + (motorkraft * 10); //rechnet die Motorkraft (in %) in eine Zeit um
        try {
            Runtime.getRuntime().exec("pigs s " + pin + "" + impuls);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Fehler beim Ausführen von pigs s " + pin + "" + impuls,"Error", JOptionPane.ERROR_MESSAGE);
            writer.schreiben("FATAL: Fehler beim Ausführen von pigs s " + pin + "" + impuls);
        }
    }
}
