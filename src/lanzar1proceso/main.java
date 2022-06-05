package lanzar1proceso;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
/* Clases necesarias para poder crear procesos. */
import java.lang.Process;
import java.lang.Runtime;



/**
 * Ejemplo básico de como lanzar un proceso en JAVA
 * @author  David Jiménez Riscardo
 * @version 1.0
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
        Process proceso;
        
        try {
            
            //Obtenemos el nombre del SO
            String osName = System.getProperty("os.name");
            
            if (osName.toUpperCase().contains("WIN")){ //Windows
                proceso = Runtime.getRuntime().exec("cmd /c start cmd /k java -jar resources/generador.jar");
                //proceso = Runtime.getRuntime().exec("notepad");
            }   
        } catch (IOException ex) {
            Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SecurityException ex){
            System.out.println("Ha ocurrido el siguiente error de seguridad. "+
            "No se ha podido crear el proceso por falta de permiso.");
        }

    }
    
}
