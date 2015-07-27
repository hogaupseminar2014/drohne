/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flugdrohne;

/**
 *
 * @author Tim
 */
public class Motor_Steuerung {

    Motor motor;
    
    Motor_Steuerung(){
        motor = new Motor();
    }
    
    void Motorkraft_Aendern(int k_m1, int k_m2, int k_m3, int k_m4){ //Im normallfall ist die Zeit 1, wenn die Drohne z.b den Auftrag bekommen soll 20 Sekunden geradeaus zu fliegen, kann man die Zeit auf 20 setzen 
        motor.setSpeed(k_m1,4);
        motor.setSpeed(k_m2,5);
        motor.setSpeed(k_m3,6);
        motor.setSpeed(k_m4,7);
        
    }
    
    int Motor_Testen(){
        Motorkraft_Aendern(50,50,50,50);
        try {
                Thread.sleep(5000);                 //Zeit in Millisekunden - 1000ms sind eine Sekunde
                }
            catch(InterruptedException ex) {
                Thread.currentThread().interrupt();
                }
        return 10;
    }

}
