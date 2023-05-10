package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import connection.ConnectionFactory;
import contas.Contas;

public class ContasDAO {

    
        private Connection conexao;

        public ContasDAO(){
            this.conexao = new ConnectionFactory().conectar();
        }
    


    public void insert(Contas conta) throws SQLException{

        String sql = "insert into tb_contas (id, nome, tipo, saldo) values (?, ?, ?, ?)";
        PreparedStatement stmt = conexao.prepareStatement(sql);
        stmt.setInt(1, conta.getNumeroConta());
        stmt.setString(2, conta.getNomeCompleto());
        stmt.setString(3, conta.getTipoConta());
        stmt.setLong(4, conta.getSaldo());
        stmt.execute();
        stmt.close();
    }
   
}