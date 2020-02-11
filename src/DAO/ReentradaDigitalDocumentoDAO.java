
package DAO;


import Model.CadastroSaida;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ReentradaDigitalDocumentoDAO {
    
    private final Connection connection;
    private PreparedStatement stmt;
    private Statement st;
    private ResultSet result;  
    
        
    public ReentradaDigitalDocumentoDAO(Connection connection){
        this.connection = connection;        
    }
    
    public boolean digitalExiste(String reentrada) throws SQLException{
        
        String sql = "select * from cadastrosaida where digital = '"+reentrada+"' ";
        stmt = connection.prepareStatement(sql);
        stmt.execute();
        result = stmt.getResultSet();      
        return result.next();        
    }

    public boolean documentoExiste(String reentrada) throws SQLException {  
       
        String sql = "select * from cadastrosaida where documento = '"+reentrada+"'";
        stmt = connection.prepareStatement(sql);
        stmt.execute();
        result = stmt.getResultSet();
        return result.next();
    } 
    
    
    public CadastroSaida busca(String documento) throws SQLException{
        
        CadastroSaida cs = null;
        
        String sql = "SELECT * FROM cadastrosaida WHERE documento = '"+documento+"'";
        st = connection.createStatement();
        //stmt.setString(1, documento);
       
        result = st.executeQuery(sql);
        while(result.next()){
            cs = new CadastroSaida();
            //cs.setId(result.getInt("id"));
            cs.setNome(result.getString("nome"));
            cs.setDocumento(result.getString("documento"));
            cs.setFoto(result.getBytes("imagem"));
   
        }
        return cs;
    }
   
    
}
