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

import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.PinState;
import com.pi4j.io.gpio.RaspiPin;
import java.io.IOException;

public class Motor {
    
    //nur für Pi// final GpioPinDigitalOutput pin;
   
    Motor(String Bezeichner, int GPIO){ //Name des GPIOs, kann frei gewählt werden, GPIO an der der Controller angeschlossen wurde
        
            // nur für Pi// final GpioController gpio = GpioFactory.getInstance(); // Initialisieren der Steureinheit für die GPIOs
            // nur für Pi// pin = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_20, "Motor " + Bezeichner, PinState.LOW); //gibt den zu benutzenden GPIO an, den Namen und den GPIO Status (low == aus)
        
    }
    
    void KraftGeben(int motorkraft){ //motorkraft in % angeben
        
        int impuls = 1000 + (motorkraft * 10); //rechnet die Motorkraft (in %) in eine Zeit um
        //nur für Pi// pin.pulse(impuls,true); // gibt die errechnete Zeit an den Motor weiter
    }
}
