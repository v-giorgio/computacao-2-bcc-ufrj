import java.util.ArrayList;

public class Grafica {

    private float precoEmCoresFalse;
    private float precoEmCoresTrue;
    private boolean emCores;
    ArrayList<Impressora> impressoras = new ArrayList<>();
    private int numeroRevezamento = 0;

    public void imprimirDocumento(Documento documento) {
        int numeroDeImpressoras = impressoras.size();
        if (numeroRevezamento == numeroDeImpressoras){
            numeroRevezamento = 0; //zerar o indice quando chegar à ultima impressora
        }
        impressoras.get(numeroRevezamento).imprimirDocumento(documento);
        numeroRevezamento++;
    }

    public float orcarImpressao(Documento documento) {
        if(documento.isEmCores()){
            return documento.getQuantPaginas()*precoEmCoresTrue;
        } else{
            return documento.getQuantPaginas()*precoEmCoresFalse;
        }
    }

    public void adicionarImpressora(Impressora impressora) {
        this.impressoras.add(impressora);
    }

    public void setPrecoPorPagina(float precoPorPagina, boolean emCores) {
        if (emCores){
            this.precoEmCoresTrue = precoPorPagina;
        } else{
            this.precoEmCoresFalse = precoPorPagina;
        }
    }
}