package lanzarvariosprocesos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;
/* Clases necesarias para poder crear procesos. */
import java.lang.Process;
import java.lang.Runtime;

/**
 * Ejemplo de como lanzar varios procesos en JAVA
 * @author  David Jiménez Riscardo
 * @version 1.0
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Process proceso;
        
        int num_procesos, num_cadenas;
        
        num_procesos = leeEntero("Introduzca el número de procesos:", 2, 10);
        
 
        for(int i=0;i<num_procesos;i++){
            
            try {
                
                num_cadenas = leeEntero("Indique el número de cadenas a generar del proceso "+(i+1)+":");
                
                proceso = Runtime.getRuntime().exec("java -jar resources/generador.jar " + num_cadenas);
                
                InputStream is = proceso.getInputStream();
                
                BufferedReader br = new BufferedReader(new InputStreamReader(is));
                System.out.printf("Proceso Generador %d: \n", i+1);                           
                String linea;
                try {
                    while ((linea = br.readLine()) != null) {
                        System.out.println(linea);
                    }
                } catch (IOException ex) {
                    System.err.println("Fallo en la lectura");
                    System.err.println(ex.toString());
                }
                
            } catch (IOException ex) {
                Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SecurityException ex){
            System.out.println("Ha ocurrido el siguiente error de seguridad. "+
            "No se ha podido crear el proceso por falta de permiso.");
        }
        }   
    }
    
     /**
     * Lee un número entero desde la entrada estándar hasta el siguiente salto de línea
     * @param mensaje Mensaje que mostraremos al usuario
     * @return El valor numérico leido (como int)
     */
    public static int leeEntero(String mensaje){
        
        BufferedReader br;
        String cadena;
        while(true){
            System.out.print(mensaje);
            br = new BufferedReader(new InputStreamReader(System.in));            
            try {
                cadena = br.readLine();
                return Integer.valueOf(cadena.trim());
            } catch (NumberFormatException ex) {
                System.out.println("ERROR: Formato incorrecto. Vuelve a intentarlo.");
            } catch (IOException ex){
                System.out.println("ERROR: Error de E/S");
            } 
        }
    }
    
    /**
     * Método para controlar que la lectura del entero esté entre un mínimo y un máximo
     * @param mensaje Mensaje que mostraremos al usuario
     * @param minimo Valor mínimo
     * @param maximo Valor máximo
     * @return Número entero válido
     */
    public static int leeEntero(String mensaje, int minimo, int maximo){
        int entero;
        do {
            entero = leeEntero(mensaje);
            if( entero < minimo)
               System.out.println("ERROR: Valor mínimo = "+minimo); 
            else if ( entero > maximo)
                System.out.println("ERROR: Valor máximo = "+maximo); 
        }while( entero < minimo || entero > maximo);
        
        return entero;
    }
    
}
