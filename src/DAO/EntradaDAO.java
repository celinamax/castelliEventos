
package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class EntradaDAO {
    
    private final Connection connection;
    private PreparedStatement stmt;
    private ResultSet result;  

    public EntradaDAO(Connection connection) {
        this.connection = connection;
    }
    
    public boolean conviteExiste(String entrada) throws SQLException{
        String sql = "SELECT codConvite FROM codigoconvite WHERE codConvite = ?";
        stmt = connection.prepareStatement(sql);
        stmt.setString(1, entrada);
        stmt.execute();
        result = stmt.getResultSet(); 
        return result.next();   
    }
}
