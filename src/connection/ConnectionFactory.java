package connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {

    
    public Connection conectar(){
        try {
            return DriverManager.getConnection("jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL", "rm93360", "100903");
        } catch (Exception e) {
            System.out.println("Erro ao conectar com o db");
            throw new RuntimeException(e);
        }
    }
    


}