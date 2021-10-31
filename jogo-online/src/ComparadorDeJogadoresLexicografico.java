import java.util.ArrayList;

public class ComparadorDeJogadoresLexicografico {
    public ArrayList<String> compararUsernames(ArrayList<String> listaDeJogadores){
        for (int i = 0; i <= listaDeJogadores.size(); i++){
            for (int j = i + 1; j < listaDeJogadores.size(); j++){
                int compareTo = listaDeJogadores.get(i).compareTo(listaDeJogadores.get(j));
                if (compareTo > 0){
                    String temp = listaDeJogadores.get(i);
                    listaDeJogadores.set(i, listaDeJogadores.get(j));
                    listaDeJogadores.set(j, temp);
                }
            }
        }
        return listaDeJogadores;
    }
}
