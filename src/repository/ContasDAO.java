package repository;

import connection.ConnectionFactory;
import contas.Contas;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ContasDAO {

  private Connection conexao;

  public ContasDAO() {
    this.conexao = new ConnectionFactory().conectar();
  }

  public void insertConta(Contas conta) throws SQLException {
    String sql =
      "insert into tb_contas (id, nome, tipo, saldo) values (?, ?, ?, ?)";
    PreparedStatement stmt = conexao.prepareStatement(sql);
    stmt.setInt(1, conta.getNumeroConta());
    stmt.setString(2, conta.getNomeCompleto());
    stmt.setString(3, conta.getTipoConta());
    stmt.setDouble(4, conta.getSaldo());
    stmt.execute();
    stmt.close();
  }

  public void deposita(int id, double valor) throws SQLException {
    String oldSaldo = "select saldo from tb_contas where id=?";
    PreparedStatement stmtSaldo = conexao.prepareStatement(oldSaldo);
    stmtSaldo.setInt(1, id);
    ResultSet rs = stmtSaldo.executeQuery();
    rs.next();

    double saldo = rs.getDouble("saldo");
    String sql = "update tb_contas set saldo=? where id=?";
    PreparedStatement stmt = conexao.prepareStatement(sql);
    stmt.setDouble(1, saldo += valor);
    stmt.setInt(2, id);
    stmt.execute();
    stmt.close();
    stmtSaldo.close();
  }

  public void transfere(int id, double valor) throws SQLException {
    String oldSaldo = "select saldo from tb_contas where id=?";
    PreparedStatement stmtSaldo = conexao.prepareStatement(oldSaldo);
    stmtSaldo.setInt(1, id);
    ResultSet rs = stmtSaldo.executeQuery();
    rs.next();

    double saldo = rs.getDouble("saldo");
    String sql = "update tb_contas set saldo=? where id=?";
    PreparedStatement stmt = conexao.prepareStatement(sql);
    stmt.setDouble(1, saldo -= valor);
    stmt.setInt(2, id);
    stmt.execute();
    stmt.close();
    stmtSaldo.close();
  }

  public double showSaldo(int id) throws SQLException {
    String sql = "select saldo from tb_contas where id=?";
    PreparedStatement stmt = conexao.prepareStatement(sql);
    stmt.setInt(1, id);
    ResultSet rs = stmt.executeQuery();
    rs.next();
    double saldo = rs.getDouble("saldo");
    stmt.close();
    return saldo;
  }
}
