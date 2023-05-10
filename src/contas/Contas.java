package contas;

public class Contas {

  int numeroConta;
  String nomeCompleto;
  String tipoConta;
  Long saldo = 2000L;

  public void showSaldo() {
    System.out.println("Saldo : R$" + saldo);
  }

  public void receberValor(Long valor) {
    setSaldo(this.saldo + valor);
  }

  public void transferirValor(Long valor, Contas conta) {
    setSaldo(this.saldo - valor);
    conta.receberValor(valor);
  }

  public String getNomeCompleto() {
    return this.nomeCompleto;
  }

  public void setNomeCompleto(String nomeCompleto) {
    this.nomeCompleto = nomeCompleto;
  }

  public String getTipoConta() {
    return this.tipoConta;
  }

  public void setTipoConta(String tipoConta) {
    this.tipoConta = tipoConta;
  }

  public Long getSaldo() {
    return this.saldo;
  }

  public void setSaldo(Long saldoInicial) {
    this.saldo = saldoInicial;
  }

  public void setNome(String nome) {
    this.nomeCompleto = nome;
  }

  public int getNumeroConta() {
    return this.numeroConta;
  }

  public void setNumeroConta(int numeroConta) {
    this.numeroConta = numeroConta;
  }
}
