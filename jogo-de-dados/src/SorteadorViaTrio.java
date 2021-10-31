public class SorteadorViaTrio extends DadoComum{

    private DadoComum dado = new DadoComum();

    public SorteadorViaTrio(DadoComum dado) {
        this.dado = dado;
    }

    @Override
    public Integer sortear(){
        int X = dado.sortear();
        int Y = dado.sortear();
        int Z = dado.sortear();
        if (X == Y && Y == Z){
            return 1;
        }
        return 0;
    }
}