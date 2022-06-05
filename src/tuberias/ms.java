package tuberias;

import java.util.Random;
import java.util.Scanner;

/**
 * Generamos una cadena de forma aletoria que representa a un programa en Windows
 * @author David Jiménez Riscardo
 * @version 1.0
 */
public class ms {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion;
        
        Random r = new Random();
        opcion = r.nextInt(4);
        
        switch(opcion){
            case 1:
                System.out.println("mspaint");
                break;
            case 2: 
                System.out.println("calc");
                break;
            default:
                System.out.println("notepad");
        }
    }
    
}
