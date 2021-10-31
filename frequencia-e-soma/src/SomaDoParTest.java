import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class SomaDoParTest {

    private ArrayList<Integer> lista;
    private ArrayList<Integer> listaLong;

    @Before
    public void setUp() {
        int[] array = new int[] {1, 45, -8, 50, 12, 900, -7, 4, 49};
        lista = new ArrayList<>();
        for (int elemento : array) {
            lista.add(elemento);
        }

        int j = 1;
        int[] arrayLong = new int[1000];
        listaLong = new ArrayList<>();
        for (int i = 0; i < arrayLong.length; i++) {
            arrayLong[i] = j++;
            listaLong.add(j);
        }
    }

    @Test
    public void testarSomaDoParQuandoEncontra() {
        assertEquals(Integer.valueOf(-8), SomaDoPar.encontrarParComSomaDadaEficiente(lista, 4));
        assertEquals(Integer.valueOf(4), SomaDoPar.encontrarParComSomaDadaEficiente(lista, 53));

        assertEquals(Integer.valueOf(-8), SomaDoPar.encontrarParComSomaDadaIngenua(lista, 4));
        assertEquals(Integer.valueOf(4), SomaDoPar.encontrarParComSomaDadaIngenua(lista, 53));
    }

    @Test
    public void testarSomaDoParQuandoNaoEncontra() {
        assertNull(SomaDoPar.encontrarParComSomaDadaEficiente(lista, 1000000));
        assertNull(SomaDoPar.encontrarParComSomaDadaEficiente(lista, 1));
        assertNull(SomaDoPar.encontrarParComSomaDadaEficiente(lista, 0));

        assertNull(SomaDoPar.encontrarParComSomaDadaIngenua(lista, 1000000));
        assertNull(SomaDoPar.encontrarParComSomaDadaIngenua(lista, 1));
        assertNull(SomaDoPar.encontrarParComSomaDadaIngenua(lista, 0));
    }

    @Test
    public void testarEficienciaEntreDoisMetodos(){

        long inicioEficiente = System.currentTimeMillis();
        assertEquals(Integer.valueOf(996), SomaDoPar.encontrarParComSomaDadaEficiente(listaLong, 1997));
        long tempoEficiente = System.currentTimeMillis() - inicioEficiente;

        long inicioIngenuo = System.currentTimeMillis();
        assertEquals(Integer.valueOf(996), SomaDoPar.encontrarParComSomaDadaIngenua(listaLong, 1997));
        long tempoIngenuo = System.currentTimeMillis() - inicioIngenuo;

        System.out.printf("%d < %d", tempoEficiente, tempoIngenuo);

        long teste = tempoIngenuo - tempoEficiente;
        assertTrue("Usando hashset consome menos tempo", teste > 0);
    }

}