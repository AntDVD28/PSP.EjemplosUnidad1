package tuberias;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Ejemplo de como lanzar un proceso
 * El nombre del proceso lo rescataremos de una tubería
 * @author David Jiménez Riscardo
 * @version 1.0
 */
public class inicia {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Process proceso;
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String cadena = null;
        try {
            cadena = br.readLine();
        } catch (IOException ex) {
            Logger.getLogger(inicia.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("He cogido de la tubería "+cadena);
        try {
            proceso = Runtime.getRuntime().exec(cadena);
            
        } catch (IOException ex) {
            Logger.getLogger(inicia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
