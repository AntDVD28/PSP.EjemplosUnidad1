package tuberias;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


/**
 * Programa para generar y mostrar cadenas aleatorias de 10 caracteres de longitud
 * @author David Jiménez Riscardo
 * @version 1.0
 */
public class generador {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        //Array de tipo String dónde guardaremos todas las cadenas generadas
        String cadenas_generadas[];
        
        //Variable dónde guardaremos el número de cadenas
        int num_cadenas;
        
        //String para mostrar todas las cadenas concatenadas
        String cadena = "";
        
        //El número de cadenas podemos introducirlo como argumento o desde teclado
        if(args.length > 0){
            num_cadenas = Integer.parseInt(args[0]);
        }else {
           num_cadenas = leeEntero(); 
        }       
               
        //Creo el array de tamaño num_cadenas
        cadenas_generadas = new String[num_cadenas];

        //Generamos cadenas y las guardamos en el array
        for(int i=0;i<num_cadenas;i++){
            cadenas_generadas[i] = generarCadena();
        }
        
        //Recorro el array para concatenar todas las cadenas generadas en un string
        for(int i=0; i<num_cadenas;i++){
            cadena = cadena + cadenas_generadas[i] + " ";
        }
        //Imprimio en salida estándar el texto compuesto por las palabras generadas
        System.out.println(cadena);
   
    }
    
     /**
     * Lee un número entero desde la entrada estándar hasta el siguiente salto de línea
     * @return El valor numérico leido (como int)
     */
    public static int leeEntero(){
        
        BufferedReader br;
        String cadena;
        while(true){
            System.out.print("Introduzca un número entero:");
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
     * Genera una cadena de 10 caracteres, formada por letras mayúsculas y minúsculas
     * @return Cadena de 10 caracteres formada por letras mayúsculas y minúsculas
     */
    public static String generarCadena(){
        //Longitud de la cadena generada
        int longitud = 10;
        //Cadena generada
        String cadena_generada = "";
        //Variable auxiliar que contendrá el valor 0 ó 1
        int aux;
        
        for(int i=0;i<longitud;i++){
            //Obtenemos dos posibles valores, 0 ó 1          
            aux = (int) Math.round(Math.random());
            //Si obtenemos el valor 0 generamos una letra minúscula
            if(aux==0){
                cadena_generada = cadena_generada + generarLetraMinuscula();
            }
            //Si obtenemos el valor 1 generamos una letra mayúscula           
            if(aux==1){
                cadena_generada = cadena_generada + generarLetraMayuscula();
            }              
        }       
        return cadena_generada;       
    }
    
    /**
     * Función que genera letras minúsculas
     * @return Letra minúscula generada
     */
    public static char generarLetraMinuscula(){
              
        //inicio tiene el valor ascii que corresponde a la primera letra minúscula 'a', podríamos haber puesto también 97
        int inicio = 'a';
        //número de letras minúsculas
        int limite = 26;
        //El número aleatorio generado estará comprendido entre el número 97 y 122 ambos inclusives
        int num = (int) (Math.random()*limite)+inicio;

        char caracter = (char)num;

        return caracter;
    }
    
    /**
     * Función que genera letras mayúsculas
     * @return Letra mayúscula generada
     */
    public static char generarLetraMayuscula(){
              
        //inicio tiene el valor ascii que corresponde a la primera letra mayúscula 'A', podríamos haber puesto también 65
        int inicio = 'A';
        //número de letras mayúsculas
        int limite = 26;
        //El número aleatorio generado estará comprendido entre el número 65 y 90 ambos inclusives
        int num = (int) (Math.random()*limite)+inicio;

        char caracter = (char)num;

        return caracter;
    }
}
