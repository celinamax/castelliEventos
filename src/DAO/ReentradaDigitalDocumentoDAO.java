package DAO;

import Model.CadastroSaida;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ReentradaDigitalDocumentoDAO {

    private final Connection connection;
    private PreparedStatement stmt;
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

}
