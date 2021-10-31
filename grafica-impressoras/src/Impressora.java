public abstract class Impressora {

    private int documentosImpressos = 0;
    private int qtdFolhasRestantes;

    public boolean imprimirDocumento(Documento documento) {
        if(this.qtdFolhasRestantes < documento.getQuantPaginas()){
            return false;
        }
        documentosImpressos++;
        for (int i = 0; i < documento.getQuantPaginas(); i++) {
            executarImpressaoPagina(documento.getPagina(i));
            qtdFolhasRestantes--;
        }
        return true;
    }

    public void carregarPapel(int numeroDeFolhas) {
        this.qtdFolhasRestantes += numeroDeFolhas;
    }

    public int getQuantidadeFolhasRestantes() {
        return this.qtdFolhasRestantes;
    }

    public int getQuantidadeDocumentosImpressos() {
        return this.documentosImpressos;
    }

    public abstract void executarRotinaLimpeza();

    public abstract void executarImpressaoPagina(String pagina);
}