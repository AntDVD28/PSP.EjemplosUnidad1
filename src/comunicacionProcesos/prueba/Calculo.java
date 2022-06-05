/**
 * Clase para calcular el doble de un número dado
 *
 * @author David Jiménez Riscardo
 */
public class Calculo {

    private int resultado;

    public Calculo() {

    }

    public void calculaDoble(int numero) {
        this.resultado = numero * 2;
    }

    public int getResultado() {
        return resultado;
    }

}
