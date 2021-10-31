

public class Principal {

    private static final int CONT_REPETICOES_POR_SIMULACAO = 2_000_000;

    private static DadoComum dadoComum = new DadoComum();
    private static SorteadorViaTrio sorteadorTrio = new SorteadorViaTrio(dadoComum);
    private static SorteadorViaDoisParesConsecutivos sorteadorPares = new SorteadorViaDoisParesConsecutivos(dadoComum);

    private static void obterPercentuaisEmpiricos(int numeroDeRodadasPorPartida) {

        JogoMalucoComSorteadores<SorteadorViaTrio, SorteadorViaDoisParesConsecutivos> jogoMaluco;

        jogoMaluco = new JogoMalucoComSorteadores<>(
                "SorteadorTrio", "SorteadorPares",
                numeroDeRodadasPorPartida, sorteadorTrio, sorteadorPares);

        for (int i = 0; i < CONT_REPETICOES_POR_SIMULACAO; i++) {
            jogoMaluco.jogar();
        }

        System.out.println(String.format("\n\n" +
                        "      Para partidas com %d rodada(s):\n" +
                        "      Vitórias do Jogador 1: %f%%\n" +
                        "      Vitórias do Jogador 2: %f%%\n" +
                        "      Empates: %f%%",
                numeroDeRodadasPorPartida,
                jogoMaluco.getPercentualVitoriasJogador1(),
                jogoMaluco.getPercentualVitoriasJogador2(),
                jogoMaluco.getPercentualEmpates()));
    }


    public static void main(String[] args) {

        for (int numeroDeRodadas = 1; numeroDeRodadas <= 1000000; numeroDeRodadas++) {
            obterPercentuaisEmpiricos(numeroDeRodadas);
        }
    }
}