/**
 * Crear una clase java "P1" que se ejecute desde consola, al que se la pasa
 * como parámetro un numero de hasta 5 dígitos. Debe sumar sus dígitos, y el
 * resultarlo pasarlo a través de un "|" a otro programa P2 Esta clase P2
 * recibirá mediante pipe "|" lo enviado por P1, y lanzará un proceso "Calculo"
 * enviándole al mismo como parámetro lo que ha recibido por la tubería, y
 * después leerá el resultado de "Calculo", mostrando su valor por pantalla La
 * clase “Calculo", lo que hace es calcular el doble de lo que ha recibido por
 * parámetros, y lo devuelve por su salida standard La ejecución debería ser
 * algo así: java P1 11114 | java P2
 * Resultado:
 * El doble de la suma de los dígitos es 16
 * Deben intervenir las tres clases indicadas P1, P2 y Calculo, y de la forma indicada.
 */
/**
 * Clase que suma los dígitos de un número introducido por consola
 *
 * @author David Jiménez Riscardo
 */
public class P1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        int numero = 0;
        int resultado = 0;
        boolean parametroCorrecto = true;
        try {
            if (args.length != 1) {
                System.out.println("Error de parámetros: Sólo se admite un parámetro");
            } else {
                if (args[0].length() > 5) {
                    System.out.println("Error de parámetros: El parámetro sólo puede tener 5 dígitos");
                } else {
                    numero = Integer.parseInt(args[0]);
                    parametroCorrecto = true;
                }
            }
            if (parametroCorrecto) {
                while (numero > 0) {
                    resultado += numero % 10;
                    numero = numero / 10;
                }
                System.out.println(resultado);
            }
        } catch (NumberFormatException exception) {
            System.err.println("No es un numero");
        }
    }
}
