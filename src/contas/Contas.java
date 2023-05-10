package contas;

public class Contas {

  int numeroConta;
  String nomeCompleto;
  String tipoConta;
  double saldo;

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

  public double getSaldo() {
    return this.saldo;
  }

  public void setSaldo(double saldo) {
    this.saldo = saldo;
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
