
package DAO;

import Model.CadastroSaida;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CadastroSaidaDAO {
    
    private final Connection connection;
    private PreparedStatement stmt;
   

    public CadastroSaidaDAO(Connection connection) {
        this.connection = connection;
    }
    
    public void insert(CadastroSaida cs) throws SQLException{
        String sql = "INSERT INTO CADASTROSAIDA (nome, documento)VALUES (?, ?)";
        stmt = connection.prepareStatement(sql);
        stmt.setString(1, cs.getNome());
        stmt.setString(2, cs.getDocumento());
        stmt.execute();
        stmt.close();
    }

  
    
    
    
    
    
}
