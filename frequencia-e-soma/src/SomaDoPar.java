import java.util.ArrayList;
import java.util.HashSet;

public class SomaDoPar {

    /**
     * Percorre a lista dada para encontrar um par de elementos
     * cuja soma seja o valor desejado.
     *
     * @param numeros uma lista de inteiros
     * @param somaDesejada a soma desejada
     *
     * @return O menor dos elementos do par encontrado;
     *         ou null, caso nenhum par de elementos some o valor desejado
     */
    public static Integer encontrarParComSomaDadaIngenua(
            ArrayList<Integer> numeros, int somaDesejada) {

        // Algoritmo ineficiente (quadrático):

        for (int i = 0; i < numeros.size(); i++) {
            for (int j = i + 1; j < numeros.size(); j++) {
                int x = numeros.get(i);
                int y = numeros.get(j);
                if (x + y == somaDesejada) {
                    return Math.min(x, y);
                }
            }
        }
        return null;
    }

    public static Integer encontrarParComSomaDadaEficiente(
            ArrayList<Integer> numeros, int somaDesejada) {

        // Algoritmo eficiente (linear):

        HashSet<Integer> listaDeNumeros = new HashSet<>();
        listaDeNumeros.addAll(numeros);
        for (int i = 0; i < numeros.size(); i++){
            if(listaDeNumeros.contains(somaDesejada-numeros.get(i))){
                return numeros.get(i);
            }
        }
        return null;
    }
}