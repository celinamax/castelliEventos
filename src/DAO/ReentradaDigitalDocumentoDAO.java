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
     
    public ReentradaDigitalDocumentoDAO(Connection connection) {
        this.connection = connection;
    }

    public CadastroSaida digitalExiste(byte[] reentrada) throws SQLException{
        
        CadastroSaida cs = null;
        
        String sql = "select * from cadastrosaida where digital = ? ";
        stmt = connection.prepareStatement(sql);
        stmt.setBytes(1, reentrada);
        stmt.execute();
        result = stmt.executeQuery();
        while (result.next()) {
            cs = new CadastroSaida();
            cs.setNome(result.getString("nome"));
            cs.setDocumento(result.getString("documento"));
            cs.setFoto(result.getBytes("imagem"));
        }
        return cs;        
    }
    
    public CadastroSaida validaDocumento(String documento) throws SQLException {

        CadastroSaida cs = null;

        String sql = "SELECT * FROM cadastrosaida WHERE documento = ?";
        
        stmt = connection.prepareStatement(sql);
        stmt.setString(1, documento);
        result = stmt.executeQuery();
        while (result.next()) {
            cs = new CadastroSaida();
            cs.setNome(result.getString("nome"));
            cs.setDocumento(result.getString("documento"));
            cs.setFoto(result.getBytes("imagem"));
        }
        return cs;
    }
    
    public boolean validarEntrada(String doc) throws SQLException{
        
        String sql = "SELECT entrou FROM cadastrosaida WHERE documento = ?";
        
        st =  connection.createStatement();  
        stmt.setString(1, doc);
        result = st.executeQuery(sql);     
        return result.next();        
    }
    
    public void updateEntrada(String doc) throws SQLException{
        String sql = "UPDATE cadastroSaida SET entrou = ? WHERE documento =?";
        stmt = connection.prepareStatement(sql);
        stmt.setBoolean(1, true);
        stmt.setString(1, doc);
        stmt.execute();
        stmt.close();
    }
}
