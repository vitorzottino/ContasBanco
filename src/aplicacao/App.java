package aplicacao;

import java.sql.SQLException;
import java.util.Scanner;

import contas.Contas;
import repository.ContasDAO;

public class App {

  public static void main(String[] args) throws SQLException{
    Scanner input = new Scanner(System.in);
    ContasDAO dao = new ContasDAO();
    int opcao = 0;
    int i = 0;
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
          System.out.println("Informe o saldo da conta: ");
          conta.setSaldo(input.nextLong());
          conta.setNumeroConta(i+=1);
          dao.insert(conta);
          break;
        default:
      }
    }
    input.close();
  }
  
}
