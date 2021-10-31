public class ContaInvestimento extends Conta{

    private String tipoInvestimento;
    private float taxaJuros;

    public ContaInvestimento(int numeroDaConta, Correntista correntista, String tipoInvestimento, float taxaJuros) {
        super(numeroDaConta, correntista);
        if (correntista.getContaCorrente() == null){
            throw new RuntimeException("Correntista sem conta corrente!");
        } else{
            this.tipoInvestimento = tipoInvestimento;
            this.taxaJuros = taxaJuros;
        }
    }

    public void aplicarJuros(){
        super.atualizarSaldoComJuros(this.taxaJuros);
    }

    public void resgatarTotal(Conta conta){
        super.efetuarTransferencia(conta, this.getSaldoEmReais());
        super.zerarContaInvestimento(this);
    }

}
