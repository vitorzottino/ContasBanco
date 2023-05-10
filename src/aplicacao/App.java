package aplicacao;

import contas.Contas;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.Random;
import java.util.Scanner;
import repository.ContasDAO;

public class App {

  public static void main(String[] args) throws SQLException {
    Scanner input = new Scanner(System.in);
    ContasDAO dao = new ContasDAO();
    DecimalFormat df = new DecimalFormat("00000");
    Random r = new Random();
    int opcao = 0;

    System.out.println("Operações");

    while (opcao != 4) {
      System.out.println("0 - Cadastrar Cliente");
      System.out.println("1 - Consultar saldos");
      System.out.println("2 - Receber valor");
      System.out.println("3 - Transferir valor");
      System.out.println("4 - Sair");
      opcao = input.nextInt();

      switch (opcao) {
        case 0:
          Contas conta = new Contas();
          System.out.println("Informe o nome completo: ");
          input.nextLine();
          conta.setNome(input.nextLine());
          System.out.println("Selecione o tipo da conta");
          System.out.println("1- Corrente\t 2- Poupança");
          switch (input.nextInt()) {
            case 1:
              conta.setTipoConta("Corrente");
              break;
            case 2:
              conta.setTipoConta("Poupança");
              break;
            default:
              System.out.println("Selecao Invalida");
          }

          conta.setNumeroConta(r.nextInt(1, 9999));
          dao.insertConta(conta);
          break;
        case 1:
          System.out.println("Informe o numero da conta: ");
          int aux = input.nextInt();
          System.out.println("\tCONTA " + df.format(aux));
          System.out.println("Saldo corrente: R$" + dao.showSaldo(aux));
          System.out.println("Pressione qualquer tecla para continuar");
          input.nextLine();
          input.nextLine();

          break;
        case 2:
          System.out.println("Informe o numero da conta: ");
          int numeroConta = input.nextInt();
          System.out.println("Informe o valor a ser depositado: ");
          double valor = input.nextDouble();
          dao.deposita(numeroConta, valor);
          break;
        case 3:
          System.out.println("Informe o numero da conta: ");
          numeroConta = input.nextInt();
          System.out.println("Informe o valor da transferencia: ");
          valor = input.nextDouble();
          dao.transfere(numeroConta, valor);
          break;
        default:
      }
    }
    input.close();
  }
}
