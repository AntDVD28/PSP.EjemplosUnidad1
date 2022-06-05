package tuberias;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Programa que contabiliza la frecuencia de las vocales 'a', 'e' y 'o'
 *
 * @author David Jiménez Riscardo
 * @version 1.0
 */
public class frecuencia {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        String cadena;
        int num_vocales[];
        try {
            
            if(args.length == 0)
                cadena = leeCadena();
            else{
                cadena = leeCadenaConsola();
            }
                
            
            num_vocales = cuentaVocales(cadena);
            System.out.println("("+num_vocales[0]+","+num_vocales[1]+","+num_vocales[2]+")");
        } catch (IOException ex) {
            System.out.println("ERROR: Error de E/S.");
        }
        
    }
    
    /**
     * Método para contabilicar el número de 'a', 'e' y 'o' en una cadena
     * @param cadena Cadena dónde contabilicar las vocales
     * @return Array con la cuenta
     */
    public static int[] cuentaVocales(String cadena){
        //declaro un array de caracteres donde guardaremos la cadena recibida
        char array_caracteres[];
        //array donde guardaremos el resultado obtenido
        int num_vocales[] = new int[3];
        //contadores de letras
        int cont_a=0, cont_e=0, cont_o=0;
        
        //Paso la cadena a minúsculas
        cadena = cadena.toLowerCase();  
        //Guardo la cadena en el array de caracteres
        array_caracteres = cadena.toCharArray();
        //Recorro el array de caracteres y contabilizo el número de vocales      
        for(int i=0;i<array_caracteres.length;i++){  

            if(array_caracteres[i]=='a')  cont_a++;

            if(array_caracteres[i]=='e')  cont_e++;

            if(array_caracteres[i]=='o')  cont_o++;                         
        }
        num_vocales[0] = cont_a;
        num_vocales[1] = cont_e;
        num_vocales[2] =cont_o;
        
        return num_vocales;
    }

    public static String leeCadenaConsola() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String cadena = br.readLine();
        System.out.println(cadena);
        br.close();
        return cadena;
    }
 
    /**
     * Método para leer una cadena válida desde teclado
     * @return Cadena válida
     * @throws UnsupportedEncodingException
     * @throws IOException 
     */
    public static String leeCadena() throws UnsupportedEncodingException, IOException{
        
        BufferedReader br;
        String cadena;
        do{
            
            System.out.print("Introduzca una cadena(FIN para terminar):");
            br = new BufferedReader(new InputStreamReader(System.in, "ISO-8859-1"));
            cadena = br.readLine();
       
            if((cadena.toUpperCase()).equals("FIN")){
                System.out.println("Programa terminado.");
                System.exit(0);
            }
            if(cadena.isEmpty() || !validaCadena(cadena)){
                System.out.println("Cadena no válida");
            }
        }while( cadena.isEmpty() || !validaCadena(cadena));
        
        br.close();
        return cadena;
    }

    /**
     * Método para validar una cadena Será válida si contiene alguno de los
     * caracteres indicados en el patrón
     *
     * @param cadena Cadena a validar
     * @return Devuelve true si es válida, false en caso contrario
     */
    public static boolean validaCadena(String cadena) {
        Pattern p = Pattern.compile("[ 0-9a-zA-ZñÑáéíóúÁÉÍÓÚ,.]*");       
        Matcher m = p.matcher(cadena);
        return m.matches();
    }

}
