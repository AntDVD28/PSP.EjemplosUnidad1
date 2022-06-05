package comunicacionProcesos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Clase que llamará a la clase Cálculo
 *
 * @author AntDVD
 */
public class P2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        //Leo por consola lo que me llega a través de la tubería
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            String cadena = br.readLine();
            int numero = Integer.parseInt(cadena);
            Calculo c = new Calculo();
            c.calculaDoble(numero);
            System.out.println("El doble de la suma de los dígitos es: " + c.getResultado());
        } catch (IOException ex) {
            System.err.println("Error de E/S");
        }
    }

}
