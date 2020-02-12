
package DAO;

import Model.CadastroSaida;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class CadastroSaidaDAO {
    
    private final Connection connection;
    private PreparedStatement stmt;
    private Statement st;
    private ResultSet rs;
    private ArrayList<CadastroSaida> lista;

    public CadastroSaidaDAO(Connection connection) {
        this.connection = connection;
    }
    
    public void insert(CadastroSaida cs) throws SQLException{
        String sql = "INSERT INTO cadastroSaida (nome, documento, imagem, digital) VALUES (?, ?, ?, ?)";
        stmt = connection.prepareStatement(sql);
        stmt.setString(1, cs.getNome());
        stmt.setString(2, cs.getDocumento());
        stmt.setBytes(3, cs.getFoto());
        stmt.setBytes(4, cs.getDigital());
        stmt.execute();
        stmt.close();
    }
    
    public void update(CadastroSaida cs) throws SQLException{
        String sql = "UPDATE cadastroSaida SET nome = ?, documento = ? WHERE id =?";
        stmt = connection.prepareStatement(sql);
        stmt.setString(1, cs.getNome());
        stmt.setString(1, cs.getDocumento());
        stmt.execute();
        stmt.close();
    }
    
    public ArrayList<CadastroSaida> listAll() throws SQLException{
        String sql = "SELECT * FROM cadastrosaida";
        st = connection.createStatement();
        rs = st.executeQuery(sql);
        while(rs.next()){
            CadastroSaida cs = new CadastroSaida();
            cs.setId(rs.getInt("id"));
            cs.setNome(rs.getString("nome"));
            cs.setDocumento(rs.getString("documento"));
            cs.setFoto(rs.getBytes("imagem"));
            lista.add(cs);
        }
        return lista;
    }
    
}
