
package DAO;


import Model.CadastroSaida;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.sql.rowset.serial.SerialBlob;

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
    
    public byte[] acharFoto(CadastroSaida cs) throws SQLException, IOException{ 
       String sql = "SELECT imagem FROM cadastrosaida where documento = ?;";
       stmt = connection.prepareStatement(sql);
       stmt.setString(1, cs.getDocumento());
       stmt.execute();
       ResultSet Rs = stmt.getResultSet();
       System.out.println(Rs.getByte("imagem"));
       
       SerialBlob blob = new SerialBlob(Rs.getBlob("imagem"));   
        
       //BufferedInputStream stream = new BufferedInputStream(blob.getBinaryStream());
       //byte[] dado = new byte[stream.available()];
       //stream.read(dado,0,dado.length);
       
       stmt.close();
       
       return null;
    }
    
}
