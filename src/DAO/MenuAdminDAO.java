
package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author HMS
 */
public class MenuAdminDAO {

    private final Connection connection;
    private PreparedStatement stmt;
    private Statement st;
    private ResultSet rs;
    
    public MenuAdminDAO(Connection connection){
        this.connection = connection;        
    }    
    
    public void deletarCamposTabela() throws SQLException{
        String sql = "TRUNCATE TABLE";
        stmt = connection.prepareStatement(sql);        
        stmt.execute();
        stmt.close();        
    }   
   
    
}
