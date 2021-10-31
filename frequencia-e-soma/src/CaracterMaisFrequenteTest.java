import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CaracterMaisFrequenteTest {

    public String myStringGrande;
    public StringBuilder stringGrande;

    @Before
    public void setUp() {
        stringGrande = new StringBuilder();

        stringGrande.append("aacd".repeat(10000));
        myStringGrande = stringGrande.toString();
    }

    @Test
    public void testarCaracterMaisFrequente() {
        assertEquals('a', CaracterMaisFrequente.encontrarCaracterMaisFrequenteIngenuo("arara"));
        assertEquals(' ', CaracterMaisFrequente.encontrarCaracterMaisFrequenteIngenuo("a r a r a 345 sdf hhh"));

        assertEquals('a', CaracterMaisFrequente.encontrarCaracterMaisFrequenteEficiente("arara"));
        assertEquals(' ', CaracterMaisFrequente.encontrarCaracterMaisFrequenteEficiente("a r a r a 345 sdf hhh"));
    }

    @Test
    public void testarEficienciaEntreDoisMetodos(){

        long inicioEficiente = System.currentTimeMillis();
        assertEquals('a', CaracterMaisFrequente.encontrarCaracterMaisFrequenteEficiente(myStringGrande));
        long tempoEficiente = System.currentTimeMillis() - inicioEficiente;

        long inicioIngenuo = System.currentTimeMillis();
        assertEquals('a', CaracterMaisFrequente.encontrarCaracterMaisFrequenteIngenuo(myStringGrande));
        long tempoIngenuo = System.currentTimeMillis() - inicioIngenuo;

        System.out.printf("%d < %d", tempoEficiente, tempoIngenuo);

        long teste = tempoIngenuo - tempoEficiente;
        assertTrue("Usando hashset consome menos tempo", teste > 0);
    }

}