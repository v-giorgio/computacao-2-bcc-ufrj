import java.util.ArrayList;
import java.util.HashMap;

public class CaracterMaisFrequente {

    public static char encontrarCaracterMaisFrequenteIngenuo(String texto) {

        // Algoritmo ineficiente (quadrático):

        char maisFrequente = texto.charAt(0);
        int ocorrenciasDoMaisFrequente = 1;

        for (int i = 0; i < texto.length(); i++) {
            char caracterDaVez = texto.charAt(i);
            int contOcorrencias = 1;
            for (int j = i + 1; j < texto.length(); j++) {
                if (texto.charAt(j) == caracterDaVez) {
                    contOcorrencias++;
                }
            }

            if (contOcorrencias > ocorrenciasDoMaisFrequente) {
                maisFrequente = caracterDaVez;
                ocorrenciasDoMaisFrequente = contOcorrencias;
            }
        }

        return maisFrequente;
    }

    public static char encontrarCaracterMaisFrequenteEficiente(String texto) {

        // Algoritmo eficiente (linear):

        HashMap<Character, Integer> mapeamentoLetrasEQuantidades = new HashMap<>();
        Integer value = 1;
        for(int i = 0; i < texto.length(); i++){
            Character key = texto.charAt(i);
            if (mapeamentoLetrasEQuantidades.containsKey(key)){
                mapeamentoLetrasEQuantidades.put(key, mapeamentoLetrasEQuantidades.get(key)+1);
            } else {
                mapeamentoLetrasEQuantidades.put(key, value);
            }
        }

        ArrayList<Character> letras = new ArrayList<>();
        for (int i = 0; i < texto.length(); i++){
            if(!letras.contains(texto.charAt(i))){
                letras.add(texto.charAt(i));
            }
        }

        Integer valorDefault = 1;
        char charMaisRepetido = ' ';

        for (Character letra : letras) {
            if (mapeamentoLetrasEQuantidades.get(letra) >= valorDefault) {
                charMaisRepetido = letra;
                valorDefault = mapeamentoLetrasEQuantidades.get(letra);
            }
        }

        return charMaisRepetido;
    }
}
