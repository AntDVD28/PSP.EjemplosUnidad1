package clienteSuministrador;

import java.io.File;
import java.io.RandomAccessFile;
import java.io.PrintStream;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.nio.channels.FileLock;

/**
 * La clase Suministrador accede a un fichero para escribir un dato
 * Incluimos mecanismos de sincronización
 * @author usuario
 */
public class Suministrador {

    /**
     * @param args Argumentos de la línea de comando
     * El primer argumento pasado, será la ruta del fichero
     */
    public static void main(String[] args) {
      int orden = 0;
      String nombreFichero = "";
      File archivo = null;
      RandomAccessFile raf = null;
      FileLock bloqueo = null;
      
//      //Comprobamos si estamos recibiendo argumentos en la línea de comandos
//      if (args.length > 0){
//        orden = Integer.parseInt(args[0]);
//        //Número de orden de creación de este proceso
        try{
            //Rediregimos salida y error estándar a un fichero
            PrintStream ps = new PrintStream(
                             new BufferedOutputStream(new FileOutputStream(
                             new File("javalog_suministrador.txt"),true)), true);
            System.setOut(ps);
            System.setErr(ps);
        }catch(Exception e){
            System.err.println("Suministrador. No he podido redirigir salidas.");
        }
//      }
      //Identificamos el sistema operativo para poder acceder por su ruta al
      //fichero de forma correcta.
      String osName = System.getProperty("os.name");
      if (osName.toUpperCase().contains("WIN")){ //Windows
        if (args.length > 0)
            nombreFichero = args[0].replace("\\", "\\\\");
            //Hemos recibido la ruta del fichero en la línea de comandos
        else{
            nombreFichero = "buffer.txt";
            //Fichero que se utilizará por defecto
          }
      }else{ //GNU/Linux
          if (args.length > 0)
            nombreFichero = args[0];
          //Hemos recibido la ruta del fichero en la línea de comandos
          else{
               nombreFichero = "/home/usuario/buffer.txt";
               //Fichero que se utilizará por defecto
        }
      }
      //Preparamos el acceso al fichero
      archivo = new File(nombreFichero);
      int i = 0;
      while(i<10){//escribiremos 10 datos
         try{
            raf = new RandomAccessFile(archivo,"rwd"); //Abrimos el fichero
            //***************
            //Sección crítica
            bloqueo = raf.getChannel().lock();
            //bloqueamos el canal de acceso al fichero. Obtenemos el objeto que
            //representa el bloqueo para después poder liberarlo
            System.out.println("Suministrador: ENTRA sección");
            // Lectura del fichero
            if (raf.length() == 0){
               raf.writeInt(i); //escribimos el valor
               System.out.println("Suministrador: valor escrito " + i);
               i ++;
            }else
                System.out.println("Suministrador: no puede escribir.");
            System.out.println("Suministrador: SALE sección");
            bloqueo.release(); //Liberamos el bloqueo del canal del fichero
            bloqueo = null;
            //Fin sección crítica
            //*******************
            Thread.sleep(500); //Simulamos tiempo de creación del dato
        }catch(Exception e){
            System.err.println("Suministrador. Error al acceder al fichero.");
            System.err.println(e.toString());
        }finally{
            try{
                if( null != bloqueo) bloqueo.release();
                if( null != raf ) raf.close();                
            }catch (Exception e2){
                System.err.println("Suministrador. Error al cerrar el fichero.");
                System.err.println(e2.toString());
                System.exit(1);  //Si hay error, finalizamos
            }
        }
        }

    }

}

