#Bibliotheken einbinden
import RPi.GPIO as GPIO
import time

GPIO.setwarnings(False)

#GPIO Modus (BOARD / BCM)
GPIO.setmode(GPIO.BOARD)

#GPIO Pins zuweisen
#GPIO_TRIGGER = 18
#GPIO_ECHO = 24

#Richtung der GPIO~Pins festlegen (IN / OUT)
GPIO.setup(12, GPIO.OUT)
GPIO.setup(18, GPIO.IN)

def distanz():
    
    time.sleep(0.3)

    # setze Trigger auf HIGH
    GPIO.output(12, True)

    # setze Trigger nach 0.01ms auf LOW
    time.sleep(0.00001)
    GPIO.output(12, False)

    StartZeit = time.time()
    StopZeit = time.time()

    # speichere Startzeit
    while GPIO.input(18) == 0:
        StartZeit = time.time()

    #speichere Ankunftszeit
    while GPIO.input(18) == 1:
        StopZeit = time.time()

    #Zeit Differenz zwischen Start und Ankunft
    TimeElapsed = StopZeit - StartZeit
    #mit der Schallgeschwindigkeit (34300 cm/s) multiplizieren
    #und durch 2 teilen, da hin und zurueck
    distanz = (TimeElapsed * 34300) / 2

    GPIO.cleanup()

    return distanz

if __name__ == "__main__":
    try:
        while True:
            abstand = distanz()
            print ("%.1f cm" % abstand)
            time.sleep(1)
            
    #Beim Abbruch duch STRG+C resetten
    except KeyboardInterrupt:
        print ("Messung vom User gestoppt")
        GPIO.cleanup()
