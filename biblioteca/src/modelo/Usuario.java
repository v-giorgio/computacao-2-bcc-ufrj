package modelo;

import java.util.*;

public class Usuario {

    private String nome;

    private final long cpf;

    private String endereco;

    private final ArrayList<Livro> objetosADevolver = new ArrayList<>();

    private final HashMap<Integer, Usuario> cpfEUsuarios = new HashMap<>();

    public Usuario(String nome, long cpf) {
        this.nome = nome;
        this.cpf = cpf;
    }

    public long getCpf() {
        return this.cpf;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return this.endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public void devolverLivro( Livro livro) {
        objetosADevolver.remove(livro);
    }

    public void emprestarLivro (Livro livro) {
        objetosADevolver.add(livro);
    }

    public int getSizeObjetosADevolver() {
        return objetosADevolver.size();
    }

    public List<Livro> getObjetosADevolver() {
        return Collections.unmodifiableList(objetosADevolver);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Usuario)) return false;
        Usuario usuario = (Usuario) o;
        return cpf == usuario.cpf;
    }

    @Override
    public int hashCode() {
        return Objects.hash(cpf);
    }

}
