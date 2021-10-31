import java.util.ArrayList;

public class Documento {

    private ArrayList<String> paginas = new ArrayList<>();
    private boolean emCores;

    public Documento(ArrayList<String> paginas, boolean emCores) {
        this.paginas = paginas;
        this.emCores = emCores;
    }

    public boolean isEmCores() {
        return emCores;
    }

    public int getQuantPaginas() {
        return this.paginas.size();
    }

    public String getPagina(int numeroDaPagina) {
        return this.paginas.get(numeroDaPagina);
    }
}
