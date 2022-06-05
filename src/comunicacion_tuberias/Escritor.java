package comunicacion_tuberias;
/**
 * Ejemplo de comunicación entre procesos utilizando tuberías
 * @author usuario
 */
public class Escritor {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Lo único que hacemos es escribir los números de 0 a 9 en
        // la salida estándar del proceso
        for (int i=0; i<10; i++)
            System.out.println(i);
    }

}
