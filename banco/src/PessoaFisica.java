import java.util.Date;

public class PessoaFisica {

    private final long cpf;
    private String nome;
    private Date dataNascimento;
    private String endereco;

    public PessoaFisica(String nome, long cpf) {
        this.nome = nome;
        this.cpf = cpf;
        this.endereco = "Nao informado";
        // etc.
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public long getCpf() {
        return cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (nome.length() > 30) {
            return;  // ToDo lançaria uma exceção
        }
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
}