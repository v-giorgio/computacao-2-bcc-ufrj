import java.util.Collections;
import java.util.Map;
import java.util.Random;

public class DadoGenerico<T> implements Sorteador<T> {

    Map<T, Integer> frequenciaByResultado;

    public DadoGenerico(Map<T, Integer> frequenciaByResultado) {
        this.frequenciaByResultado = frequenciaByResultado;
    }

    @Override
    public T sortear() {
        T maiorKey = null;
        Integer max = Collections.max(frequenciaByResultado.values());
        Integer valorSorteado = new Random().nextInt(max);
        for (T key : frequenciaByResultado.keySet()){
            if (valorSorteado < frequenciaByResultado.get(key)){
                maiorKey = key;
            }
        }

        return maiorKey;
    }
}
