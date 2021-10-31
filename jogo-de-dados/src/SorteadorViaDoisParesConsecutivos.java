public class SorteadorViaDoisParesConsecutivos extends DadoComum {

    private DadoComum dado = new DadoComum();

    public SorteadorViaDoisParesConsecutivos(DadoComum dado) {
        this.dado = dado;
    }

    @Override
    public Integer sortear(){
        int A = dado.sortear();
        int B = dado.sortear();
        int C = dado.sortear();
        int D = dado.sortear();
        if (A == B && C == D){
            return 1;
        }
        return 0;
    }
}
