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
public class Motor_Steuerung {

    Motor motor;
    int speed_m1;
    int speed_m2;
    int speed_m3;
    int speed_m4;
    
    Motor_Steuerung(){
        motor = new Motor();
        try {
            Runtime.getRuntime().exec("sudo pigpiod");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Fehler beim Ausführen von pigpiod", "Error", JOptionPane.ERROR_MESSAGE);
            writer.schreiben("FATAL: Fehler beim Ausführen von pigpiod");
        }
    }
    
    void changeSpeed(int k_m1, int k_m2, int k_m3, int k_m4){ 
        motor.setSpeed(k_m1,4);
        motor.setSpeed(k_m2,5);
        motor.setSpeed(k_m3,6);
        motor.setSpeed(k_m4,7);
        speed_m1 = k_m1;
        speed_m2 = k_m2;
        speed_m3 = k_m3;
        speed_m4 = k_m4;
        
    }
    
    int Motor_Testen(){
        changeSpeed(50,50,50,50);
        try {
                Thread.sleep(5000);                 //Zeit in Millisekunden - 1000ms sind eine Sekunde
                }
            catch(InterruptedException ex) {
                Thread.currentThread().interrupt();
                }
        changeSpeed(0,0,0,0);
        return 10;
    }

}
